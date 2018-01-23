package com.didi.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.didi.model.DApi;
import com.didi.model.DApiExample;

@Repository
public interface DApiMapper {
    long countByExample(DApiExample example);

    int deleteByExample(DApiExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DApi record);

    int insertSelective(DApi record);

    List<DApi> selectByExample(DApiExample example);

    DApi selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DApi record, @Param("example") DApiExample example);

    int updateByExample(@Param("record") DApi record, @Param("example") DApiExample example);

    int updateByPrimaryKeySelective(DApi record);

    int updateByPrimaryKey(DApi record);
}