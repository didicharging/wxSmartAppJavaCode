package com.didi.mapper;

import com.didi.model.EOrders;
import com.didi.model.EOrdersExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EOrdersMapper {
    int countByExample(EOrdersExample example);

    int deleteByExample(EOrdersExample example);

    int deleteByPrimaryKey(String id);

    int insert(EOrders record);

    int insertSelective(EOrders record);

    List<EOrders> selectByExample(EOrdersExample example);

    EOrders selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EOrders record, @Param("example") EOrdersExample example);

    int updateByExample(@Param("record") EOrders record, @Param("example") EOrdersExample example);

    int updateByPrimaryKeySelective(EOrders record);

    int updateByPrimaryKey(EOrders record);
    
    List<EOrders> selectChangeOrders(EOrders record);

	int endOrders(String userId);

	List<EOrders> getCorporateCanChangeOrdre(Map<String, Object> param);

	List<Map<String, Object>> getDayOrder();

	List<Map<String, Object>> getWeekOrder();

	List<Map<String, Object>> getMonthOrder();
}