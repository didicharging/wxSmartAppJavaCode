package com.didi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.didi.mapper.EComplainMapper;
import com.didi.model.EComplain;
import com.didi.model.EComplainExample;


@Service
public class ComplainService {
   
	@Resource
	EComplainMapper complainMapper;

	public int insert(EComplain comlain) {
		
		return complainMapper.insert(comlain);
        		
	}
	
	public Map<String, Object> list(EComplainExample example, int page, int perPage) {

		Map<String, Object> result = new HashMap<String, Object>();
	   

		List<EComplain> list = complainMapper.selectByExample(example);

		result.put("data", list);
		result.put("total", complainMapper.countByExample(example));

		return result;
	}
	
	
	
	
}
