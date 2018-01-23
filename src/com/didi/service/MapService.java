package com.didi.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.didi.mapper.EStationMapper;
import com.didi.mapper.MapMapper;
import com.didi.model.EStation;
import com.didi.model.EStationExample;

@Service
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MapService  {

	@Resource
	MapMapper mapper;
	
	@Resource
	EStationMapper stationMapper;

	public Map<String, Object> getPointList(double longitude, double latitude, String city, String userId) {
		
		Map<String, Object> res = new HashMap<String, Object>();
		
		List<Map<String, Object>> Stationlist=mapper.getStationList();
		List<Map<String, Object>> list=mapper.getshareList();
     		
		List<Map<String, Object>> sharelist=new ArrayList<Map<String,Object>>();
	
		Iterator<Map<String, Object>> it = list.iterator();
		
		int i=0;
		
		List<String> userList=new ArrayList<String>();
		userList.add("ca2a1737154a4821a713a2cb431afd11");
		
		
		if(!userList.contains(userId)){
					
		while(it.hasNext()){
			Map<String, Object> map = it.next();			
			double longitude1 = (double) map.get("longitude");
			double latitude1 = (double) map.get("latitude");
			double distance=getDistance(longitude, latitude, longitude1, latitude1);			
			if(distance<30000){
				  i++;			  
				  if(i<=200){
					  sharelist.add(map);
				  }
			}		
		}
		
		}else{
		   sharelist=list;
		}
		
		res.put("stationlist", Stationlist);
		res.put("sharelist", sharelist);
		
		return res;
	}
	  
	
	   
	   private static double EARTH_RADIUS = 6378.137;    
	   
	   private static double rad(double d) {    
	       return d * Math.PI / 180.0;    
	   }    
	   
	   /**   
	    * 通过经纬度获取距离(单位：米)   
	    * @param lat1   
	    * @param lng1   
	    * @param lat2   
	    * @param lng2   
	    * @return   
	    */    
	   
	   public static double getDistance(double lat1, double lng1, double lat2,    
	                                    double lng2) {    
	       double radLat1 = rad(lat1);    
	       double radLat2 = rad(lat2);    
	       double a = radLat1 - radLat2;    
	       double b = rad(lng1) - rad(lng2);    
	       double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)    
	               + Math.cos(radLat1) * Math.cos(radLat2)    
	               * Math.pow(Math.sin(b / 2), 2)));    
	       s = s * EARTH_RADIUS;    
	       s = Math.round(s * 10000d) / 10000d;    
	       s = s*1000;    
	       return s;    
	   }

	   
	public int insertStaion(EStation station) {
		// TODO Auto-generated method stub
		stationMapper.insert(station);
		return 1;
	}

	public List<Map<String, Object>> getStationList() {
		// TODO Auto-generated method stub
		return mapper.getStationList();
	}

	public int deleteStation(String id) {
		// TODO Auto-generated method stub
		return stationMapper.deleteByPrimaryKey(id);
	}

//	@Test
	public List<EStation> nearbyStation(String id, double longitude, double latitude) {
	
		String userId="7d248e45aafb4628aac7c39f56be6b6c";

		Map<String, Object> res = new HashMap<String, Object>();
		EStationExample example =new EStationExample();
		stationMapper.selectByExample(example);
		
		List<EStation> list=stationMapper.selectByExample(example);
		
		for (EStation eStation : list) {
			int distance=(int)getDistance(longitude, latitude, eStation.getLongitude(), eStation.getLatitude());
			eStation.setDistance(distance);
		}
		
		list.sort(null);
		
		for (EStation eStation : list) {
			System.out.println(eStation);
		}
		
				
		return list.subList(0, 5);
	} 
	
	   
	
}
