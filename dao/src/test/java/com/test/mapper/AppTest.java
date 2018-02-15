package com.test.mapper;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.didi.mapper.MapMapper;

import junit.framework.TestCase;


/**
 * Unit test for simple App.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class AppTest 
    extends TestCase
{
	@Resource
	MapMapper mapper;
	
	@Test
	public void daoTest(){		
		// TODO Auto-generated method stub
		List<Map<String, Object>> list=mapper.getStationList();
		System.out.println(list.size());
		
	}
}
