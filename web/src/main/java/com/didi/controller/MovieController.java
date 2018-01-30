package com.didi.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.didi.model.EMovie;
import com.didi.model.EMovieExample;
import com.didi.model.EMovieVisit;
import com.didi.model.EMovieVisitExample;
import com.didi.service.MovieService;
import com.didi.unti.TextUtils;

@Controller
@RequestMapping("/resource-service/movie")
public class MovieController {

	@Resource
	MovieService movieService;
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	   @ResponseBody
	public Map<String, Object> list() {
		Map<String, Object> res = new HashMap<String, Object>();
		
		try {
            
			EMovieExample example=new EMovieExample();
			
			List<EMovie> list =(List<EMovie>) movieService.list(example, 0, 0).get("data");
					
	        res.put("list", list);
			res.put("status", 200);
			res.put("message", "查找成功!");
			return res;		
		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "查找失败!错误原因：" + e.getMessage());
			return res;		
		}
		
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	   @ResponseBody
	public Map<String, Object> get(
			@RequestParam(required=true) String id,
			@RequestParam(required=true) String userId) {
		Map<String, Object> res = new HashMap<String, Object>();
		
		try {
		
			   res=movieService.get(id,userId);
			   res.put("status", 200);
			   res.put("message", "查找成功!");
			return res;		
			
		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "查找失败!错误原因：" + e.getMessage());
			return res;
		}
	 
	}
	
	
	@RequestMapping(value = "/insertAct", method = RequestMethod.GET)
	   @ResponseBody
	public Map<String, Object> insertAct(
			@RequestParam(required=true) String id,
			@RequestParam(required=true) String userId,
			@RequestParam(required=true) String content
			) {
		Map<String, Object> res = new HashMap<String, Object>();
		
		try {
		
			   EMovieVisit movieVisit=new EMovieVisit();
			   
			   movieVisit.setId(TextUtils.getIdByUUID());
			   movieVisit.setCreateTime(new Date());
			   movieVisit.setMovieid(id);
			   movieVisit.setUserid(userId);
			   movieVisit.setContent(content);
			   
			   movieService.insertAct(movieVisit);
			   
			   res.put("status", 200);
			   res.put("message", "插入弹幕成功!");
			return res;		
			
		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "查找失败!错误原因：" + e.getMessage());
			return res;
		}
	 
	}
	
	
	@RequestMapping(value = "/getAct", method = RequestMethod.GET)
	   @ResponseBody
	public Map<String, Object> getAct(
			@RequestParam(required=true) String id
			) {
		Map<String, Object> res = new HashMap<String, Object>();
		
		try {
		
			   EMovieVisitExample movieVisit=new EMovieVisitExample();
			   EMovieVisitExample.Criteria criteria=movieVisit.createCriteria();
			   criteria.andMovieidEqualTo(id);
			   criteria.andContentNotEqualTo("");
			   movieVisit.setOrderByClause("create_time desc");
			   
			   
			   List<MovieService> list =(List<MovieService>) movieService.ActList(movieVisit, 0, 0).get("data");
			   
			   res.put("list", list);
			   res.put("status", 200);
			   res.put("message", "查找成功!");
			return res;		
			
		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "查找失败!错误原因：" + e.getMessage());
			return res;
		}
	 
	}
	

}
