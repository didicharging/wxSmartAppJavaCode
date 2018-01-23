package com.didi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.didi.model.EShareAct;
import com.didi.model.EShareActExample;

@Repository
public interface EShareActMapper {
	int countByExample(EShareActExample example);

	int deleteByExample(EShareActExample example);

	int deleteByPrimaryKey(String id);

	int insert(EShareAct record);

	int insertSelective(EShareAct record);

	List<EShareAct> selectByExample(EShareActExample example);

	EShareAct selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") EShareAct record,
			@Param("example") EShareActExample example);

	int updateByExample(@Param("record") EShareAct record,
			@Param("example") EShareActExample example);

	int updateByPrimaryKeySelective(EShareAct record);

	int updateByPrimaryKey(EShareAct record);

	List<EShareAct> getActMeList(String userId);
}