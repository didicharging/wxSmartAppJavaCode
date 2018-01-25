package com.didi.mapper;

import com.didi.model.EMovieVisit;
import com.didi.model.EMovieVisitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EMovieVisitMapper {
    int countByExample(EMovieVisitExample example);

    int deleteByExample(EMovieVisitExample example);

    int deleteByPrimaryKey(String id);

    int insert(EMovieVisit record);

    int insertSelective(EMovieVisit record);

    List<EMovieVisit> selectByExampleWithBLOBs(EMovieVisitExample example);

    List<EMovieVisit> selectByExample(EMovieVisitExample example);

    EMovieVisit selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EMovieVisit record, @Param("example") EMovieVisitExample example);

    int updateByExampleWithBLOBs(@Param("record") EMovieVisit record, @Param("example") EMovieVisitExample example);

    int updateByExample(@Param("record") EMovieVisit record, @Param("example") EMovieVisitExample example);

    int updateByPrimaryKeySelective(EMovieVisit record);

    int updateByPrimaryKeyWithBLOBs(EMovieVisit record);

    int updateByPrimaryKey(EMovieVisit record);

	List<EMovieVisit> getPassUser(String id);
}