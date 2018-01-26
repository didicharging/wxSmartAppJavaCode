package com.didi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.didi.unti.sms.SmsSingleSender;
import com.didi.unti.sms.SmsSingleSenderResult;

/**
 * Created by wangh09 on 2017/4/30.
 */
@Controller
@RequestMapping("/resource-service/sms")
public class SmsSendController {
	
    @RequestMapping(value="/sendValiCode",method= RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> sendValiCode(@RequestParam String phone,HttpServletRequest request){
     
    	Map<String, Object> res = new HashMap<String, Object>();
		
    	//判断输入的参数是否合法
    //	Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
	//	boolean isMobileNo = p.matcher(phone).matches();
//		if(true){
//			res.put("status",210);
//            res.put("message","参数格式不对");
//            return res;
//		}
		
		//生成要发送的验证码
   	    String text="0123456789";
   	    String valiCode="";
   	    Random random=new Random();
   	    for(int i=0;i<6;i++){
   		   char c=text.charAt(random.nextInt(text.length()));
   		    valiCode+=c;
 		 }
   	 
   	    System.out.println("计算得到的验证码为:"+valiCode);
    	    	
    	try {
    		//发送验证码
    		int appid = 1400034856;
    		String appkey = "f9c860f93cb4139642bd3205d4c67f64";
    		int tmplId = 27716;    
    		ArrayList<String> params = new ArrayList<>();
    		params.add(valiCode);
    		SmsSingleSender singleSender = new SmsSingleSender(appid, appkey);
    		SmsSingleSenderResult singleSenderResult;
    		singleSenderResult = singleSender.sendWithParam("86", phone, tmplId, params, "", "", "");
//    		System.out.println(singleSenderResult);
			
    	  //发送失败	
    	  if(singleSenderResult.result!=0){
  			res.put("status",211);
            res.put("message","验证码发送失败,错误原因:"+singleSenderResult.errMsg);
            return res;
    	  }
    	  //发送成功
 //   	  request.getSession().setMaxInactiveInterval(10*60);
 //   	  request.getSession().setAttribute("valiCode",valiCode);
    	
          res.put("status",200);
          res.put("valiCode",valiCode);
          res.put("message","验证码成功");
          return res;
    	  
		} catch (Exception e) {
			res.put("status",210);
            res.put("message","错误原因: "+e.getMessage());
            return res;
            
		}
  
    }
    
    @RequestMapping(method = { RequestMethod.GET }, value = "/checkValiCode")
    @ResponseBody
	public Map<String,Object> checkValiCode(HttpServletRequest request,String valiCode) {
    	
    	Map<String, Object> res = new HashMap<String, Object>();
    	
    	if (valiCode == null || valiCode.toString().equalsIgnoreCase("")) {
			res.put("status", 210);
			res.put("message", "输入不能为空");
			return res;
		}
    	
    	if(valiCode.equalsIgnoreCase((String) request.getSession().getAttribute("valiCode"))){
    	    res.put("status", 200);
			res.put("message", "校验成功");
    	}else{
    		res.put("status", 211);
 			res.put("message", "验证码输入错误");
    	}
    	
    	return res;
	}
        
}
