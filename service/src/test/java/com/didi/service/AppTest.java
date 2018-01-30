package com.didi.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.didi.model.EFans;

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
	private FansService fansService;
	
	@Test
	public void serviceTest(){
		
		EFans fans = new EFans();
		fans.setFansUserId("7d248e45aafb4628aac7c39f56be6b6c");
		
		// 判断是否已关注作者
		List<EFans> fansList = (List<EFans>) fansService.list(fans, 1, 20).get("data");
	    System.out.println(fansList.size());		
	}
	
	
}
