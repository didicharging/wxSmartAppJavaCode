package com.didi.mapper;

import com.didi.model.EMovie;
import com.didi.model.EMovieExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EMovieMapper {
    int countByExample(EMovieExample example);

    int deleteByExample(EMovieExample example);

    int deleteByPrimaryKey(String id);

    int insert(EMovie record);

    int insertSelective(EMovie record);

    List<EMovie> selectByExample(EMovieExample example);

    EMovie selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EMovie record, @Param("example") EMovieExample example);

    int updateByExample(@Param("record") EMovie record, @Param("example") EMovieExample example);

    int updateByPrimaryKeySelective(EMovie record);

    int updateByPrimaryKey(EMovie record);
}