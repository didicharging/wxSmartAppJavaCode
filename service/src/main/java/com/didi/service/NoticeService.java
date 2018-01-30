package com.didi.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.didi.mapper.ENoticeMapper;
import com.didi.model.ENotice;
import com.didi.model.ENoticeExample;
import com.didi.unti.TextUtils;

@Service
public class NoticeService implements BaseCRUDService {

	@Resource
	ENoticeMapper mapper;

	@Override
	public int edit(Object object) {
		ENotice notice = (ENotice) object;
		return mapper.updateByPrimaryKeySelective(notice);
	}

	@Override
	public int insert(Object object) {
		ENotice notice = (ENotice) object;
		notice.setId(TextUtils.getIdByUUID());
		return mapper.insert(notice);
	}

	@Override
	public int delete(String id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public Map<String, Object> list(Object object, int page, int perPage) {
		if (object == null)
			return null;
		ENotice notice = (ENotice) object;
		ENoticeExample example = new ENoticeExample();
		if (page >= 0 && perPage >= 0) {
			example.setLimit(perPage);
			example.setOffset((page - 1) * perPage);
		}
		
		if (notice.getIsDelete() != null) {
			example.setIsDelete(notice.getIsDelete());
		}
		
				
		Map<String, Object> result = new HashMap<String, Object>();
		example.setOrderByClause("pub_date desc");
		List<ENotice> list = mapper.selectByExample(example);
		result.put("data", list);
		result.put("total", mapper.countByExample(example));
		return result;
	}

	@Override
	public Object get(String id) {
		return null;
	}

}
