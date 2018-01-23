package com.didi.service;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.didi.mapper.EShareMapper;
import com.didi.mapper.EWalletLogMapper;
import com.didi.model.EWalletLog;
import com.didi.model.EWalletLogExample;


@Service
public class WalletLogService  {
	@Resource
	EWalletLogMapper mapper;
	
	@Resource
	EShareMapper shareMapper;


	public int edit(Object object) {
		EWalletLog log = (EWalletLog) object;
		return mapper.updateByPrimaryKeySelective(log);
	}

	public int update(EWalletLog log) {
		return mapper.updateByPrimaryKey(log);
	}


	public int insert(Object object) {
		EWalletLog log = (EWalletLog) object;
		return mapper.insert(log);
	}


	public int delete(String id) {
		return mapper.deleteByPrimaryKey(id);
	}

	
	
	public Map<String, Object> list(EWalletLogExample example, int page, int perPage) {

		Map<String, Object> result = new HashMap<String, Object>();
		
		List<EWalletLog> list = mapper.selectByExample(example);
		
		result.put("data", list);
		result.put("total", mapper.countByExample(example));
		return result;
	}
	
	

	public Object get(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	// 获取用户的押金交纳记录
//	public EWalletLog getShareMoneyPayLog(String userId) {
//		return mapper.getShareMoneyPayLog(userId);
//	}

	


	
	

}
