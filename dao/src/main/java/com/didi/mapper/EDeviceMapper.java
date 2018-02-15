package com.didi.mapper;

import com.didi.model.EDevice;
import com.didi.model.EDeviceExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EDeviceMapper {
	int countByExample(EDeviceExample example);

	int deleteByExample(EDeviceExample example);

	int deleteByPrimaryKey(String id);

	int insert(EDevice record);

	int insertSelective(EDevice record);

	List<EDevice> selectByExample(EDeviceExample example);

	EDevice selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") EDevice record, @Param("example") EDeviceExample example);

	int updateByExample(@Param("record") EDevice record, @Param("example") EDeviceExample example);

	int updateByPrimaryKeySelective(EDevice record);

	int updateByPrimaryKey(EDevice record);

	List<Map<String, Object>> getPastUserList(String deviceId);

	List<Map<String, Object>> MydeviceList(EDeviceExample example);

	Map<String, Object> getDetail(String id);

	EDevice getByDeviceNo(String deviceNo);

	int investDevice(Map<String, Object> param);

}