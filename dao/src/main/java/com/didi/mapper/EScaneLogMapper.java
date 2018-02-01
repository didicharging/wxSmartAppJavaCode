package com.didi.mapper;

import com.didi.model.EScaneLog;
import com.didi.model.EScaneLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EScaneLogMapper {
    int countByExample(EScaneLogExample example);

    int deleteByExample(EScaneLogExample example);

    int deleteByPrimaryKey(String id);

    int insert(EScaneLog record);

    int insertSelective(EScaneLog record);
   
    List<EScaneLog> selectByExample(EScaneLogExample example);

    EScaneLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EScaneLog record, @Param("example") EScaneLogExample example);

    int updateByExample(@Param("record") EScaneLog record, @Param("example") EScaneLogExample example);

    int updateByPrimaryKeySelective(EScaneLog record);

    int updateByPrimaryKey(EScaneLog record);
    
    
}