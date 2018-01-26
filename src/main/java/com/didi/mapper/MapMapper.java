package com.didi.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface MapMapper {
		
	List<Map<String, Object>> getshareList();

	List<Map<String, Object>> getStationList();
	
}