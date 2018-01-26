package com.didi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.didi.model.Student;
import com.didi.service.StudentService;

@Controller
@RequestMapping("/stu")
public class StudentController {
	
	@Resource
	private StudentService studentService;

	@RequestMapping("/save")
	public ModelAndView addStu(HttpServletRequest request, Model model) {

		String username = request.getParameter("name");
		String age = request.getParameter("age");
		String sex = request.getParameter("sex");
		Student student = new Student();
		student.setName(username);
		student.setAge(age);
		student.setSex(sex);
		
		int i = this.studentService.addStu(student);
		String url = "addStu";
		if(i>0&&username!=null){
			url="success";
		}
		else{
			url="addStu";
		}
		
		ModelAndView view = new ModelAndView(url);
		return view;
	}
	
	@RequestMapping(value = "/getBanner", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getBanner(){
		Map<String, Object> res = new HashMap<String, Object>();
		
		List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
		
		Map<String, Object> banner1 = new HashMap<String, Object>();
		
		banner1.put("img_url","http://didicharging-v2.oss-cn-beijing.aliyuncs.com/banner1.jpg");
		
		banner1.put("active_id","");
		
		banner1.put("titel", "");
			
		Map<String, Object> banner2 = new HashMap<String, Object>();
		banner2.put("img_url","http://didicharging-v2.oss-cn-beijing.aliyuncs.com/banner2.jpg");
		banner2.put("active_id","");
		banner2.put("titel", "");
		
		Map<String, Object> banner3 = new HashMap<String, Object>();
		banner3.put("img_url","http://didicharging-v2.oss-cn-beijing.aliyuncs.com/banner3.jpg");
		banner3.put("active_id","");
		banner3.put("titel", "");

		Map<String, Object> banner4 = new HashMap<String, Object>();
		banner4.put("img_url","http://didicharging-v2.oss-cn-beijing.aliyuncs.com/banner4.jpg");
		banner4.put("active_id","");
		banner4.put("titel", "");
		
		Map<String, Object> banner5 = new HashMap<String, Object>();
		banner5.put("img_url","http://didicharging-v2.oss-cn-beijing.aliyuncs.com/banner5.jpg");
		banner5.put("active_id","");
		banner5.put("titel", "");
		
		list.add(banner1);
		list.add(banner2);
		list.add(banner3);
		list.add(banner4);
		list.add(banner5);
				
		res.put("list", list);
		res.put("status", 200);
		res.put("message", "查找成功!");
		
		return res;
	}
	
	



}
