package com.didi.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.didi.model.EChat;
import com.didi.model.EChatExample;

@Repository
public interface EChatMapper {
	int countByExample(EChatExample example);

	int deleteByExample(EChatExample example);

	int deleteByPrimaryKey(String id);

	int insert(EChat record);

	int insertSelective(EChat record);

	List<Map<String, Object>> selectByExample(EChatExample example);

	EChat selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") EChat record,
			@Param("example") EChatExample example);

	int updateByExample(@Param("record") EChat record,
			@Param("example") EChatExample example);

	int updateByPrimaryKeySelective(EChat record);

	int updateByPrimaryKey(EChat record);
    
	List<Map<String, Object>> GetToMeList(EChatExample example);

	int readChat(EChatExample example);

}