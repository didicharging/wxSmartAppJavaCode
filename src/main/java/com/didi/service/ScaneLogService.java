package com.didi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.didi.mapper.EScaneLogMapper;
import com.didi.model.EScaneLog;
import com.didi.model.EScaneLogExample;

@Service
public class ScaneLogService {

	@Resource	
	EScaneLogMapper mapper;


	
	public int edit(EScaneLog scaneLog) {

		return mapper.updateByPrimaryKeySelective(scaneLog);
	}

	
	public int insert(EScaneLog scaneLog) {
	
		return mapper.insert(scaneLog);
	}


	public int delete(String id) {
		return mapper.deleteByPrimaryKey(id);
	}
	
	
	public Map<String, Object> list(EScaneLogExample example, int page, int perPage) {
	  
		Map<String, Object> result = new HashMap<String, Object>();
		
		if (page > 0 && perPage > 0) {
			example.setLimit(perPage);
			example.setOffset((page - 1) * perPage);
		}
	
		List<EScaneLog> list = mapper.selectByExample(example);
		result.put("data", list);
		result.put("total", mapper.countByExample(example));
		return result;
	}

}
