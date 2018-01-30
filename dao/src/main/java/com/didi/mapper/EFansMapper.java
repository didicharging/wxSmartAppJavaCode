package com.didi.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.didi.model.EFans;
import com.didi.model.EFansExample;

@Repository
public interface EFansMapper {
	int countByExample(EFansExample example);

	int deleteByExample(EFansExample example);

	int deleteByPrimaryKey(String id);

	int insert(EFans record);

	int insertSelective(EFans record);

	List<EFans> selectByExample(EFansExample example);

	EFans selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") EFans record,
			@Param("example") EFansExample example);

	int updateByExample(@Param("record") EFans record,
			@Param("example") EFansExample example);

	int updateByPrimaryKeySelective(EFans record);

	int updateByPrimaryKey(EFans record);

	Map<String, Object> selectUserById(String userId);
}