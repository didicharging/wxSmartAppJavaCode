package com.didi.service;

import java.util.Map;

/**
 * Created by wangh09 on 2017/4/12.
 */
public interface BaseCRUDService {
	int edit(Object object);

	int insert(Object object);

	int delete(String id);

	Map<String, Object> list(Object object, int page, int perPage);

	Object get(String id);
}
