package com.didi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.didi.mapper.EMovieMapper;
import com.didi.mapper.EMovieVisitMapper;
import com.didi.model.EMovie;
import com.didi.model.EMovieExample;
import com.didi.model.EMovieVisit;
import com.didi.model.EMovieVisitExample;
import com.didi.model.EUser;
import com.didi.unti.TextUtils;

@Service
public class MovieService {

	@Resource
	EMovieMapper mapper;

	@Resource
	EMovieVisitMapper movieVisitMapper;

	public Map<String, Object> list(EMovieExample example, int page, int perPage) {

		Map<String, Object> result = new HashMap<String, Object>();

		if (page > 0 && perPage > 0) {
			example.setLimit(perPage);
			example.setOffset((page - 1) * perPage);
		}
		example.setOrderByClause("count desc");
		List<EMovie> list = mapper.selectByExample(example);
		result.put("data", list);
		result.put("total", mapper.countByExample(example));
		return result;
	}

	public Map<String, Object> get(String id, String userId) {

		Map<String, Object> result = new HashMap<String, Object>();
	    //第一步 获取视频
		EMovie movie = mapper.selectByPrimaryKey(id);
        //第二步 查看量加一
		movie.setCount(movie.getCount() + 1);
		mapper.updateByPrimaryKey(movie);
        //第三步 获取以往查看用户
		List<EMovieVisit> visitList = movieVisitMapper.getPassUser(id);
        //第四步 查入查看记录
		EMovieVisit movisit = new EMovieVisit();
		movisit.setId(TextUtils.getIdByUUID());
		movisit.setMovieid(id);
		movisit.setUserid(userId);
		movisit.setCreateTime(new Date());
		movisit.setContent("");
		movieVisitMapper.insert(movisit);

        //第五步 拉取弹幕
		EMovieVisitExample movieVisit=new EMovieVisitExample();
		   EMovieVisitExample.Criteria criteria=movieVisit.createCriteria();
		   criteria.andMovieidEqualTo(id);
		   criteria.andContentNotEqualTo("");
		   movieVisit.setOrderByClause("create_time desc");
		
		   List<EMovieVisit> visitList1= movieVisitMapper.selectByExample(movieVisit);
		   List<String> actlist=new ArrayList<String>();
		   for (EMovieVisit eMovieVisit : visitList1) {
           actlist.add(eMovieVisit.getContent());			
		}
		
		   
		   
		//第六步 相关视频 
		   
		EMovieExample example=new EMovieExample();
		
	    List<EMovie> relativeMovieList = mapper.selectByExample(example);
			
		Random romdom =new Random();
		Set  set=new HashSet();
		
		while(set.size()<3){
			set.add(relativeMovieList.get(romdom.nextInt(relativeMovieList.size()-1)));
		}
	    
	       
	    result.put("relativeMovie", set);		 
        result.put("danmu", actlist);
		result.put("movie", movie);
		result.put("passVisit", visitList);

		return result;
	}

	public int insertAct(EMovieVisit movieVisit) {
		// TODO Auto-generated method stub
		return movieVisitMapper.insert(movieVisit);
	}

	public Map<String, Object> ActList(EMovieVisitExample example, int page, int perPage) {
		// TODO Auto-generated method stub

		Map<String, Object> result = new HashMap<String, Object>();

		if (page > 0 && perPage > 0) {
			example.setLimit(perPage);
			example.setOffset((page - 1) * perPage);
		}

		List<EMovieVisit> list = movieVisitMapper.selectByExample(example);
		result.put("data", list);
		result.put("total", movieVisitMapper.countByExample(example));
		return result;

	}

}
