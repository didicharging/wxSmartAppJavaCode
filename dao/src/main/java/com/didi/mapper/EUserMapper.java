package com.didi.mapper;

import com.didi.model.EUser;
import com.didi.model.EUserExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EUserMapper {
    int countByExample(EUserExample example);

    int deleteByExample(EUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(EUser record);

    int insertSelective(EUser record);

    List<EUser> selectByExample(EUserExample example);

    EUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EUser record, @Param("example") EUserExample example);

    int updateByExample(@Param("record") EUser record, @Param("example") EUserExample example);

    int updateByPrimaryKeySelective(EUser record);

    int updateByPrimaryKey(EUser record);
    
    Map<String, Object> getUserInfoById(String id);

  	int updateImageBug(EUser example);

  	int addInvideAmount(String invideUserId);

  	List<Map<String, Object>> getRankingList();

  	Map<String, Object> getMyRank(String userId);

  	int addOrdersAndElectric(String userId);
      
}