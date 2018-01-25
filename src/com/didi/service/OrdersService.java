package com.didi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.didi.mapper.EOrdersMapper;
import com.didi.model.EOrders;
import com.didi.model.EOrdersExample;


@Service
public class OrdersService {
  
	@Resource
	EOrdersMapper mapper;
	
	
	public EOrders get(String id){
		
		return mapper.selectByPrimaryKey(id); 
	}

	public int edit(EOrders orders) {

		return mapper.updateByPrimaryKeySelective(orders);
	}

	
	public int insert(EOrders orders) {
	
		return mapper.insert(orders);
	}


	public int delete(String id) {
		return mapper.deleteByPrimaryKey(id);
	}
	
	
	public Map<String, Object> list(EOrdersExample example, int page, int perPage) {
	  
		Map<String, Object> result = new HashMap<String, Object>();
		
		if (page > 0 && perPage > 0) {
			example.setLimit(perPage);
			example.setOffset((page - 1) * perPage);
		}
	
		List<EOrders> list = mapper.selectByExample(example);
		result.put("data", list);
		result.put("total", mapper.countByExample(example));
		return result;
	}
	
    public List<EOrders> getChangeList(EOrders orders){
    	return  mapper.selectChangeOrders(orders);
    }


	public int endOrders(String userId) {
		// TODO Auto-generated method stub
		return  mapper.endOrders(userId);
	}

	public List<Map<String, Object>> getDayOrder() {
		// TODO Auto-generated method stub
		return mapper.getDayOrder();
	}

	public List<Map<String, Object>> getWeekOrder() {
		// TODO Auto-generated method stub
		return mapper.getWeekOrder();
	}

	public List<Map<String, Object>> getMonthOrder() {
		// TODO Auto-generated method stub
		return mapper.getMonthOrder();
	}

	
}
