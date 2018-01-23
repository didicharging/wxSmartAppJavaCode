package com.didi.mapper;

import com.didi.model.EDdb;
import com.didi.model.EDdbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EDdbMapper {
	
    int countByExample(EDdbExample example);

    int deleteByExample(EDdbExample example);

    int deleteByPrimaryKey(String id);

    int insert(EDdb record);

    int insertSelective(EDdb record);

    List<EDdb> selectByExample(EDdbExample example);

    EDdb selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EDdb record, @Param("example") EDdbExample example);

    int updateByExample(@Param("record") EDdb record, @Param("example") EDdbExample example);

    int updateByPrimaryKeySelective(EDdb record);

    int updateByPrimaryKey(EDdb record);
}