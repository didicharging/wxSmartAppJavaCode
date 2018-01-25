package com.didi.mapper;

import com.didi.model.EStation;
import com.didi.model.EStationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EStationMapper {
    int countByExample(EStationExample example);

    int deleteByExample(EStationExample example);

    int deleteByPrimaryKey(String id);

    int insert(EStation record);

    int insertSelective(EStation record);

    List<EStation> selectByExample(EStationExample example);

    EStation selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EStation record, @Param("example") EStationExample example);

    int updateByExample(@Param("record") EStation record, @Param("example") EStationExample example);

    int updateByPrimaryKeySelective(EStation record);

    int updateByPrimaryKey(EStation record);
}