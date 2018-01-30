package com.didi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.didi.model.ENotice;
import com.didi.model.ENoticeExample;

@Repository
public interface ENoticeMapper {
	int countByExample(ENoticeExample example);

	int deleteByExample(ENoticeExample example);

	int deleteByPrimaryKey(String id);

	int insert(ENotice record);

	int insertSelective(ENotice record);

	List<ENotice> selectByExample(ENoticeExample example);

	ENotice selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") ENotice record,
			@Param("example") ENoticeExample example);

	int updateByExample(@Param("record") ENotice record,
			@Param("example") ENoticeExample example);

	int updateByPrimaryKeySelective(ENotice record);

	int updateByPrimaryKey(ENotice record);
}