package com.didi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.didi.mapper.EChatMapper;
import com.didi.mapper.EShareMapper;
import com.didi.model.EChat;
import com.didi.model.EChatExample;
import com.didi.unti.TextUtils;

@Service
public class ChatService implements BaseCRUDService {

	@Resource
	EChatMapper mapper;
    
	@Resource
	EShareMapper shareMapper;
	
	@Override
	public int edit(Object object) {
		EChat chat = (EChat) object;
		return mapper.updateByPrimaryKeySelective(chat);
	}

	@Override
	public int insert(Object object) {
		EChat chat = (EChat) object;
		chat.setId(TextUtils.getIdByUUID());
		chat.setIsDelete(0);
		chat.setIsRead(0);
		return mapper.insert(chat);
	}

	@Override
	public int delete(String id) {
		return 0;
	}

	@Override
	public Map<String, Object> list(Object object, int page, int perPage) {
		if (object == null)
			return null;
		EChat chat = (EChat) object;
		EChatExample example = new EChatExample();
		if (page >= 0 && perPage >= 0) {
			example.setLimit(perPage);
			example.setOffset((page - 1) * perPage);
		}
		if (chat.getFromUser() != null) {
			example.setFromUser(chat.getFromUser());
		}
		if (chat.getToUser() != null) {
			example.setToUser(chat.getToUser());
		}
		if (chat.getIsDelete() != null) {
			example.setIsDelete(chat.getIsDelete());
		}
		Map<String, Object> result = new HashMap<String, Object>();
		example.setOrderByClause("chat_date desc");
		//List<EChat> list = mapper.selectByExample(example);
		
		List<Map<String, Object>> list=mapper.selectByExample(example);
	    
	    int num= mapper.readChat(example);
	
		result.put("data", list);
		result.put("total", mapper.countByExample(example));
		return result;
	}

	@Override
	public EChat get(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	public Object GetToMeList(EChat chat, int page, int perPage) {
		EChatExample example = new EChatExample();
		if (page >= 0 && perPage >= 0) {
			example.setLimit(perPage);
			example.setOffset((page - 1) * perPage);
		}
	
		if (chat.getToUser() != null) {
			example.setToUser(chat.getToUser());
		}
	    
		Map<String, Object> result = new HashMap<String, Object>();
		example.setOrderByClause("chat_date desc");		
		List<Map<String, Object>> list=mapper.GetToMeList(example);
		result.put("data", list);
		result.put("total",list.size());
		return result;	

	}

}
