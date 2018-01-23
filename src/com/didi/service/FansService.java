package com.didi.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.didi.mapper.EFansMapper;
import com.didi.model.EFans;
import com.didi.model.EFansExample;
import com.didi.unti.TextUtils;

@Service
public class FansService implements BaseCRUDService {
	@Resource
	EFansMapper mapper;

	@Override
	public int edit(Object object) {
		return 0;
	}

	@Override
	public int insert(Object object) {
		EFans fans = (EFans) object;
		fans.setId(TextUtils.getIdByUUID());
		fans.setFansDate(new Date());
		return mapper.insert(fans);
	}

	@Override
	public int delete(String id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public Map<String, Object> list(Object object, int page, int perPage) {
		if (object == null)
			return null;
		EFans fans = (EFans) object;
		EFansExample example = new EFansExample();
		if (page >= 0 && perPage >= 0) {
			example.setLimit(perPage);
			example.setOffset((page - 1) * perPage);
		}
		if (fans.getFansUserId() != null) {
			example.setFansUserId(fans.getFansUserId());
		}
		if (fans.getStarUserId() != null) {
			example.setStarUserId(fans.getStarUserId());
		}
		Map<String, Object> result = new HashMap<String, Object>();
		example.setOrderByClause("fans_date");
		List<EFans> list = mapper.selectByExample(example);
		if (list != null) {
			for (EFans f : list) {
				Map<String, Object> fansMap = mapper.selectUserById(f
						.getFansUserId());
				Map<String, Object> starMap = mapper.selectUserById(f
						.getStarUserId());
				f.setFansUser(fansMap);
				f.setStarUser(starMap);
			}
		}
		result.put("data", list);
		result.put("total", mapper.countByExample(example));
		return result;
	}

	@Override
	public Object get(String id) {
		return null;
	}

	public Map<String, Object> selectUserById(String userId) {
		return mapper.selectUserById(userId);
	}
 
}
