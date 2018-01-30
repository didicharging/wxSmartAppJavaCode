package com.didi.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.didi.model.EShare;
import com.didi.model.EShareExample;
import com.didi.model.EUser;

@Repository
public interface EShareMapper {
	int countByExample(EShareExample example);

	int deleteByExample(EShareExample example);

	int deleteByPrimaryKey(String id);

	int insert(EShare record);

	int insertSelective(EShare record);
	
	int deleteByRecive(Map<String, Object> map);

	List<EShare> selectByExample(EShareExample example);

	EShare selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") EShare record,
			@Param("example") EShareExample example);

	int updateByExample(@Param("record") EShare record,
			@Param("example") EShareExample example);

	int updateByPrimaryKeySelective(EShare record);

	int updateByPrimaryKey(EShare record);
	
	int getShareDayCount(Map<String, Object> map);
	
//	Map<String, Object> selectUserById(String userId);

	int addElectric(EUser user);
	
	int subElectric(String userId);
	
	int subPoint(String userId);

	EShare getUserLastShare(String userId);

	List<EShare> selectByExampleHot(EShareExample example);


	int getDayShareCount(String userId);

	List<EShare> selectTop(int count);

	EShare getDayHot();

	EShare getWeekHot();

	EShare getMonthHot();

	EShare getMyNew(String userId);


		
}