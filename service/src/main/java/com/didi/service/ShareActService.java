package com.didi.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.didi.mapper.EChatMapper;
import com.didi.mapper.EShareActMapper;
import com.didi.mapper.EShareMapper;
import com.didi.mapper.EUserMapper;
import com.didi.mapper.EWalletMapper;
import com.didi.model.EChat;
import com.didi.model.EDdb;
import com.didi.model.EShare;
import com.didi.model.EShareAct;
import com.didi.model.EShareActExample;
import com.didi.model.EUser;
import com.didi.model.EWallet;
import com.didi.unti.EmojiDealUtil;
import com.didi.unti.TextUtils;

@Service
public class ShareActService {
	
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
	
	@Resource
	EChatMapper chatMapper;

	
	public EShareAct getShareActByid(String id) {
		return actMapper.selectByPrimaryKey(id);
	}

	public int editAct(Object object) {
		EShareAct act = (EShareAct) object;
		return actMapper.updateByPrimaryKeySelective(act);
	}
	
	public List<EShareAct> getActByExample(EShareActExample example, int page, int perPage) {

		
		if (page > 0 && perPage > 0) {
			example.setLimit(perPage);
			example.setOffset((page - 1) * perPage);
		}
		
		return  actMapper.selectByExample(example);
		
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
				
			EChat chat = new EChat();
			chat.setChatDate(new Date());

			chat.setContent("我给你点赞了呦，点开我的头像，去我相册，也给我点个赞吧");
			chat.setFromUser(act.getUserId());
			chat.setToUser(share.getUserId());
			
			chat.setId(TextUtils.getIdByUUID());
			chat.setIsDelete(0);
			chat.setIsRead(0);		    
			chatMapper.insert(chat);
					
			ddbService.insert(share.getUserId(),10,EDdb.SHARE);
			
			addAmount(wallet);
		}
		
		
		return actMapper.insert(act);
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
        	    	
        	EWallet wallet=new EWallet();	
        	wallet.setAmount(50);
        	wallet.setUserId(shareUserId);
        	subAmount(wallet);
      	
        }
        
        
	
		return num;
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

	public int addAmount(EWallet wallet){
		return walletMapper.addAmount(wallet);
	}
	
	public int subAmount(EWallet wallet){
		return walletMapper.subAmount(wallet);
	}

	
	
	
}
