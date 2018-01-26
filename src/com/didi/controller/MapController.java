package com.didi.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.didi.model.EStation;
import com.didi.service.MapService;
import com.didi.unti.TextUtils;

/**
 * Created by wangh09 on 2017/4/30.
 */
@RestController
@RequestMapping("/resource-service/map")
public class MapController {
	
	@Resource
	MapService mapService;
	
    @RequestMapping(value="/getPointList",method= RequestMethod.GET)
	@ResponseBody
    public Map<String,Object> getPointList(@RequestParam(required=true) double longitude,
    		@RequestParam(required=true) double latitude,
    		@RequestParam(required=false) double distance,
    		@RequestParam(required=false) String city,
    		@RequestParam(defaultValue="") String userId
    		){
       
    	Map<String, Object> res = new HashMap<String, Object>();
	
    	try {
    		
    	   System.out.println(city);
    		
    	   Map<String, Object> map=mapService.getPointList(longitude,latitude,city,userId);
    	     	      	   
    	   res.put("status", 200);
    	   res.put("result", map);
    	   res.put("message", "查找成功");
    	   
		} catch (Exception e) {
			e.printStackTrace();
			res.put("status",210);
            res.put("message","错误原因: "+e.getMessage());
            
		}
    	
    	return res;
    }
    
    
    @RequestMapping(value="/getStationList",method= RequestMethod.GET)
	@ResponseBody
    public Map<String,Object> getStationList(){
       
    	Map<String, Object> res = new HashMap<String, Object>();
	
		
    	try {
    		
    	   List<Map<String, Object>> stationlist=mapService.getStationList();

    	   res.put("status", 200);
    	   res.put("result", stationlist);
    	   res.put("message", "查找成功");
    	   
		} catch (Exception e) {
			e.printStackTrace();
			res.put("status",210);
            res.put("message","错误原因: "+e.getMessage());
            
		}
    	
    	return res;
    }
    
    
    @RequestMapping(value="/deleteStation",method= RequestMethod.GET)
	@ResponseBody
    public Map<String,Object> deleteStation(@RequestParam(required=false) String id){
       
    	Map<String, Object> res = new HashMap<String, Object>();
	
		
    	try {
    		
    	   mapService.deleteStation(id);
    	   res.put("status", 200);
    	   res.put("message", "删除成功");
    	   
		} catch (Exception e) {
			e.printStackTrace();
			res.put("status",210);
            res.put("message","错误原因: "+e.getMessage());
            
		}
    	
    	return res;
    }
    
    @RequestMapping(value="/nearbyStation",method= RequestMethod.GET)
	@ResponseBody
    public Map<String,Object> nearbyStation(@RequestParam(required=true) double longitude,
    		@RequestParam(required=true) double latitude,   		
    		@RequestParam(defaultValue="") String userId){
       
    	Map<String, Object> res = new HashMap<String, Object>();
			
    	try {
    		
    	   List<EStation> list=mapService.nearbyStation(userId,longitude,latitude);
    
    	   res.put("list",list);
    	   res.put("status", 200);
    	   res.put("message", "查找成功");
    	   
		} catch (Exception e) {
			e.printStackTrace();
			res.put("status",210);
            res.put("message","错误原因: "+e.getMessage());
            
		}
    	
    	return res;
    }
    
    
    
    
    
    
    @RequestMapping(value="/insertStation",method= RequestMethod.GET)
	@ResponseBody
    public Map<String,Object> insertStation(
    		@RequestParam(required=true) double longitude,
    		@RequestParam(required=true) double latitude,
    		@RequestParam(required=true) String StationName,            
    		@RequestParam(required=true) String address,
    		@RequestParam(required=false) String phone,
    		@RequestParam(required=false) String managerName	
    		
    		){
       
    	Map<String, Object> res = new HashMap<String, Object>();
	
    
		
    	try {
    		   	   
    	   EStation station =new EStation();
    	   station.setId(TextUtils.getIdByUUID());
    	   station.setAddress(new String(address.getBytes("ISO-8859-1"),"utf-8"));
    	   
    	   station.setLatitude(latitude);
    	   station.setLongitude(longitude);
    	   station.setName(new String(StationName.getBytes("ISO-8859-1"),"utf-8"));    	   
    	   
    	   station.setPhone(phone);
    	   station.setUser(new String(managerName.getBytes("ISO-8859-1"),"utf-8"));
    	     	   
    	   mapService.insertStaion(station);
    	       	   
    	   res.put("status", 200);
    	   res.put("message", "插入成功");
    	   
		} catch (Exception e) {
			e.printStackTrace();
			res.put("status",210);
            res.put("message","错误原因: "+e.getMessage());
            
		}
    	
    	return res; 
    }
    
    
}
