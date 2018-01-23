 package com.didi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.didi.mapper.EShareMapper;
import com.didi.mapper.EWalletLogMapper;
import com.didi.mapper.EWalletMapper;
import com.didi.model.EWallet;
import com.didi.model.EWalletExample;

@Service

public class WalletService implements BaseCRUDService {
	@Resource
	EWalletMapper mapper;
	
	@Resource
	EShareMapper shareMapper;

	@Resource
	EWalletLogMapper walletLogMapper;
	
	
	@Override
	public int edit(Object object) {
		EWallet wallet = (EWallet) object;
		return mapper.updateByPrimaryKeySelective(wallet);
	}

	@Override
	public int insert(Object object) {
		EWallet wallet = (EWallet) object;
		return mapper.insert(wallet);
	}

	@Override
	public int delete(String id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public Map<String, Object> list(Object object, int page, int perPage) {
		if (object == null)
			return null;
		EWallet wallet = (EWallet) object;
		EWalletExample example = new EWalletExample();
		
		EWalletExample.Criteria criteria=example.createCriteria();
	    criteria.andUserIdEqualTo(wallet.getUserId());	
		if (page > 0 && perPage > 0) {
			example.setLimit(perPage);
			example.setOffset((page - 1) * perPage);
		}
		
		Map<String, Object> result = new HashMap<String, Object>();
		example.setOrderByClause("id");
		List<EWallet> list = mapper.selectByExample(example);
		result.put("data", list);
		result.put("total", mapper.countByExample(example));
		return result;
	}

    
	public EWallet get(String id) {
		return mapper.selectByPrimaryKey(id);
	}
	
	@SuppressWarnings("unchecked")
	public EWallet getWalletByUser(String userId) {

		EWalletExample example=new EWalletExample();
		EWalletExample.Criteria criteria=example.createCriteria();
		criteria.andUserIdEqualTo(userId);

		List<EWallet> list=mapper.selectByExample(example);
	   
		for (EWallet eWallet : list) {
			System.out.println(list);
		}

		if(list==null || list.size()==0){
			return null;
		}else{
			return list.get(0);
		}
		
		
		 
	}

    @Transactional
	public void transfer(String formUserId, String toUserId, int amount) throws Exception {
		// TODO Auto-generated method stub

    	EWallet formUserWallet=mapper.selectByUserId(formUserId);
    	if(formUserWallet.getAmount()<amount)
    		throw new Exception("您余额小于打赏金额，不能打赏他人");
    	
    	formUserWallet.setAmount(formUserWallet.getAmount()-amount);
    	mapper.updateByPrimaryKey(formUserWallet);
    	
    	EWallet toUserWallet=mapper.selectByUserId(toUserId);
    	toUserWallet.setAmount(toUserWallet.getAmount()+amount);
    	mapper.updateByPrimaryKey(toUserWallet);

	}
    
    
    

    
    
    
 
    
    
}





















