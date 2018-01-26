package com.didi.service;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.didi.mapper.EShareActMapper;
import com.didi.mapper.EShareMapper;
import com.didi.mapper.EUserMapper;
import com.didi.mapper.EWalletMapper;
import com.didi.model.EChat;
import com.didi.model.EDdb;
import com.didi.model.EShare;
import com.didi.model.EShareAct;
import com.didi.model.EShareActExample;
import com.didi.model.EShareExample;
import com.didi.model.EUser;
import com.didi.model.EWallet;
import com.didi.unti.TextUtils;

@Service
public class ShareService implements BaseCRUDService {

	@Resource
	EShareMapper shareMapper;

	@Resource
	EShareActMapper actMapper;
	
	@Resource
	EWalletMapper walletMapper;

	@Resource
	DdbService ddbService;
	
	@Resource
	EUserMapper userMapper;

	@Override
	public int edit(Object object) {
		EShare share = (EShare) object;
		return shareMapper.updateByPrimaryKeySelective(share);
	}

	public EShareAct getShareActByid(String id) {
		return actMapper.selectByPrimaryKey(id);
	}

	public int editAct(Object object) {
		EShareAct act = (EShareAct) object;
		return actMapper.updateByPrimaryKeySelective(act);
	}

	@Override
	public int insert(Object object) {
		EShare share = (EShare) object;
		
		share.setShareDate(new Date());
		

		
		EShare shareLast=shareMapper.getUserLastShare(share.getUserId());
		
		System.out.println(shareLast);
		
		if(shareLast!=null){
			
			long diff = new Date().getTime()-shareLast.getShareDate().getTime();
			if(diff<=5000){
				return 0;
			}
		}
			
		// 发图加50ddb 每日上限500
		int dayShare=shareMapper.getDayShareCount(share.getUserId());
		if(dayShare<5){	
			EWallet wallet=new EWallet();
			wallet.setAmount(10);
			wallet.setUserId(share.getUserId());
					
			addAmount(wallet);
			
			ddbService.insert(share.getUserId(),10,EDdb.SHARE);
		   
		}
		
		
		
		return shareMapper.insert(share);
        		
		
		
	}

	public int insertAct(Object object) {
		EShareAct act = (EShareAct) object;
		act.setId(TextUtils.getIdByUUID());
		act.setActDate(new Date());
		EShare share = shareMapper.selectByPrimaryKey(act.getShareId());

		if(!act.getUserId().equals(share.getUserId()) && act.getActType()==1){
			EUser user =new EUser();
			user.setId(share.getUserId());
			user.setElectric(5);	
			addElectric(user);
						
			EWallet wallet=new EWallet();		
			wallet.setAmount(10);
			wallet.setUserId(share.getUserId());
			
			ddbService.insert(share.getUserId(),10,EDdb.SHARE);
			
			addAmount(wallet);
		}
		
		
		return actMapper.insert(act);
	}

	@Override
	public int delete(String id) {
		return shareMapper.deleteByPrimaryKey(id);
	}

	public int deleteByRecive(Map<String, Object> map) {

		return shareMapper.deleteByRecive(map);
	}

	public int deleteAct(EShareAct shareAct) {
		
		
        int num=0;	
        
		EShareActExample example=new  EShareActExample();
	
		example.setShareId(shareAct.getShareId());
	
		example.setUserId(shareAct.getUserId());

        num=actMapper.deleteByExample(example);
     
        System.out.println("num: "+num);
		
        String shareUserId = shareMapper.selectByPrimaryKey(shareAct.getShareId())
				.getUserId();
		
        if(num==1){
        	
        	subPoint(shareUserId);
        	
        	EWallet wallet=new EWallet();	
        	wallet.setAmount(50);
        	wallet.setUserId(shareUserId);
        	subAmount(wallet);
        	
       	
        }
	
		return num;
	}

	@Override
	public Map<String, Object> list(Object object, int page, int perPage) {
		if (object == null)
			return null;
		
		EShare share = (EShare) object;
		EShareExample example = new EShareExample();
		if (page >= 0 && perPage >= 0) {
			example.setLimit(perPage);
			example.setOffset((page - 1) * perPage);
		}
		if (share.getUserId() != null) {
			example.setUserId(share.getUserId());
		}
		if (share.getDeviceId() != null) {
			example.setDeviceId(share.getDeviceId());
		}
		if (share.getIsDelete() != null) {
			example.setIsDelete(share.getIsDelete());
		}

		Map<String, Object> result = new HashMap<String, Object>();
		example.setOrderByClause("share_date desc");
		
		List<EShare> list = shareMapper.selectByExample(example);

		result.put("data", list);
		result.put("total", shareMapper.countByExample(example));
		return result;
	}
	
	public Map<String, Object> getMyShareList(Object object, int page, int perPage) {
		if (object == null)
			return null;
		EShare share = (EShare) object;
		EShareExample example = new EShareExample();
		if (page >= 0 && perPage >= 0) {
			example.setLimit(perPage);
			example.setOffset((page - 1) * perPage);
		}
		if (share.getUserId() != null) {
			example.setUserId(share.getUserId());
		}
		if (share.getDeviceId() != null) {
			example.setDeviceId(share.getDeviceId());
		}
		if (share.getIsDelete() != null) {
			example.setIsDelete(share.getIsDelete());
		}

		Map<String, Object> result = new HashMap<String, Object>();
		example.setOrderByClause("share_date desc");
		List<EShare> list = shareMapper.selectByExample(example);
	
	    EUser ShareUser=	userMapper.selectByPrimaryKey(share.getUserId());
	
		
		result.put("shareUser", ShareUser);
		result.put("data", list);
		result.put("total", shareMapper.countByExample(example));
		return result;
	}
	
	

	public EUser selectUserById(String userId){

		
		EUser actUser = userMapper.selectByPrimaryKey(userId);
		
		return actUser;
	}
	
	

	public Map<String, Object> listAct(Object object, int page, int perPage) {
		if (object == null)
			return null;

		EShareAct act = (EShareAct) object;

		EShareActExample example = new EShareActExample();

		if (page >= 0 && perPage >= 0) {
			example.setLimit(perPage);
			example.setOffset((page - 1) * perPage);
		}
		if (act.getUserId() != null) {
			example.setUserId(act.getUserId());
		}
		if (act.getShareId() != null) {
			example.setShareId(act.getShareId());
		}
		if (act.getActType() != null) {
			example.setActType(act.getActType());
		}
		
		Map<String, Object> result = new HashMap<String, Object>();
		example.setOrderByClause("act_date desc");
		List<EShareAct> list = actMapper.selectByExample(example);
		result.put("data", list);
		result.put("total", actMapper.countByExample(example));
		return result;
	}
	
	public Map<String, Object> getActUser(String id) {

		EShare share = shareMapper.selectByPrimaryKey(id);
		Map<String, Object> result = null;
		
		if (null != share) {
            result=new HashMap<String, Object>();
            EShareActExample example = new EShareActExample();
            example.setShareId(share.getId());
            example.setActType(1);
 			example.setOrderByClause("act_date asc");
 			List<EShareAct> ActList = actMapper.selectByExample(example);
 			
 			int actNum=0;
			if(ActList!=null){
				actNum=ActList.size();
			}
			
			List<EUser> list=new ArrayList<EUser>();
			
			for (EShareAct shareAct : ActList) {
				EUser actUser = userMapper.selectByPrimaryKey(shareAct.getUserId());
				
				list.add(actUser);
			}
			
			result.put("actNum", actNum);
			result.put("actUserList", list);
		 					
		}
			
		return result;
		
	}
	
	

	@Override
	public Map<String, Object> get(String id) {

		EShare share = shareMapper.selectByPrimaryKey(id);

		share.setCount(share.getCount()+1);
		shareMapper.updateByPrimaryKey(share);
		
		Map<String, Object> result = null;
			
		if (null != share) {
            result=new HashMap<String, Object>();
			EShareActExample example = new EShareActExample();
			
			example.setShareId(share.getId());
			example.setActType(2);
			example.setOrderByClause("act_date asc");
			List<EShareAct> commentList = actMapper.selectByExample(example);
			
			int commentNum=0;
			if(commentList!=null){
				commentNum=commentList.size();
			}
			
			for (EShareAct shareAct : commentList) {
				
				EUser actUser=userMapper.selectByPrimaryKey(shareAct.getId());				
				
				
				shareAct.setActUser(actUser);
			}

			example.setActType(1);
			example.setOrderByClause("act_date desc");
			List<EShareAct> ActList = actMapper.selectByExample(example);

			int actNum=0;
			if(ActList!=null){
				actNum=ActList.size();
			}
			
			
			for (EShareAct shareAct : ActList) {

				EUser actUser=userMapper.selectByPrimaryKey(shareAct.getId());				
				
				
				shareAct.setActUser(actUser);
				
				
				
				shareAct.setActUser(actUser);
			}
            
			result.put("share", share);
			result.put("commentNum", commentNum);
			result.put("commentList", commentList);
			result.put("actNum", actNum);
			result.put("actList", ActList);
		}

		return result;
	}
	
	public int getShareDayCount(Map<String, Object> map) {
		return shareMapper.getShareDayCount(map);
	}

	public List<EShareAct> getActMeList(String userId) {
		// TODO Auto-generated method stub
				
		List<EShareAct> actList=actMapper.getActMeList(userId);
		
		for (EShareAct shareAct : actList) {
	
			EUser actUser=userMapper.selectByPrimaryKey(shareAct.getUserId());				
			
			shareAct.setActUser(actUser);

		}
			
		return actList;
	}
	
	public int addElectric(EUser user){
		
		return shareMapper.addElectric(user);	
	
	}
	
	public int subElectric(String userId){
		
		return shareMapper.subElectric(userId);	
	
	}
	
	public int  subPoint(String userId){
		return shareMapper.subPoint(userId);
	}
	
	public int addAmount(EWallet wallet){
		return walletMapper.addAmount(wallet);
	}
	
	public int subAmount(EWallet wallet){
		return walletMapper.subAmount(wallet);
	}
	
	//按热度拉列表
	public Map<String, Object> listHot(EShare share, int page, int perPage) {

		EShareExample example = new EShareExample();
		if (page >= 0 && perPage >= 0) {
			example.setLimit(perPage);
			example.setOffset((page - 1) * perPage);
		}

		List<EShare> list= new ArrayList<EShare>();
				
		EShare share1=shareMapper.getMyNew(share.getUserId());
		list.add(share1);
		
		EShare share2=shareMapper.getDayHot();
		list.add(share2);
		
		EShare share3=shareMapper.getWeekHot();
		list.add(share3);
		
		EShare share4=shareMapper.getMonthHot();
		list.add(share4);
		
		Map<String, Object> result = new HashMap<String, Object>();
		example.setOrderByClause("share_date desc");
		

		List<EShare> listTemp = shareMapper.selectByExampleHot(example);
		for (EShare eShare : listTemp) {
		    if(share1.getId().equals(eShare.getId())) continue;
		    if(share2.getId().equals(eShare.getId())) continue;
		    if(share3.getId().equals(eShare.getId())) continue;
		    if(share4.getId().equals(eShare.getId())) continue;
		    list.add(eShare);
		}
		
		
		result.put("data", list);
		result.put("total", shareMapper.countByExample(example));
		return result;
	}
	
	public List<EShareAct> getActByExample(EShareActExample example, int page, int perPage) {

	
		if (page > 0 && perPage > 0) {
			example.setLimit(perPage);
			example.setOffset((page - 1) * perPage);
		}
		
		return  actMapper.selectByExample(example);
		
	}

	public int getShareActCounmt(EShareActExample example) {

	
		return  actMapper.countByExample(example);
		
	}
	


}
