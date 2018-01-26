package com.didi.service;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.didi.mapper.EDdbMapper;
import com.didi.model.EDdb;
import com.didi.model.EDdbExample;
import com.didi.unti.TextUtils;

@Service
public class DdbService {

	@Resource
	EDdbMapper mapper;

	public int edit(EDdb ddb) {
		// TODO Auto-generated method stub

		return mapper.updateByPrimaryKey(ddb);
	}

	public int insert(EDdb ddb) {
		// TODO Auto-generated method stub

		return mapper.insert(ddb);
	}

	public int insert(String userId, int amount, int type) {

		EDdb ddb = new EDdb();
		ddb.setId(TextUtils.getIdByUUID());
		ddb.setAmount(amount);
		ddb.setCreateTime(new Date());
		ddb.setLogType(type);
		ddb.setUserId(userId);

		return mapper.insert(ddb);
	}

	public int delete(EDdb ddb) {
		// TODO Auto-generated method stub

		return mapper.deleteByPrimaryKey(ddb.getId());
	}

	public Map<String, Object> list(EDdbExample example, int page, int perPage) {
		// TODO Auto-generated method stub

		return null;
	}

	public EDdb get(String id) {
		// TODO Auto-generated method stub

		return mapper.selectByPrimaryKey(id);
	}

}
