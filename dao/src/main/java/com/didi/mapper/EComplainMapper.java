package com.didi.mapper;

import com.didi.model.EComplain;
import com.didi.model.EComplainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EComplainMapper {
    int countByExample(EComplainExample example);

    int deleteByExample(EComplainExample example);

    int deleteByPrimaryKey(String id);

    int insert(EComplain record);

    int insertSelective(EComplain record);

    List<EComplain> selectByExample(EComplainExample example);

    EComplain selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EComplain record, @Param("example") EComplainExample example);

    int updateByExample(@Param("record") EComplain record, @Param("example") EComplainExample example);

    int updateByPrimaryKeySelective(EComplain record);
    	
    int updateByPrimaryKey(EComplain record);
}