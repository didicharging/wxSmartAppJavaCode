package com.didi.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.data.redis.core.script.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.didi.model.EUser;
import com.didi.service.UserService;
import com.didi.unti.EmojiDealUtil;
import com.didi.unti.JWTUtils;
import com.didi.unti.ServerUtils;
import com.didi.unti.StateUtils;
import com.didi.unti.TextUtils;

import net.sf.json.JSONObject;

/**
 * Created by wangh09 on 2017/5/26.
 */
@Controller
@RequestMapping("/gateway")
public class MainController {

    @Resource
    UserService service;
	

    @RequestMapping(value="/onMiniProgramLogin",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> onMiniProgramLogin(
    		@RequestBody Map<String,Object> data   
    )
    { 
        Map<String,Object> res = new HashMap<String,Object>();
        
       //  res.put("pages", "../main/main?sence=");
 
         res.put("pages", "../main/main?sence=");         
       
 //      res.put("pages", "../payShare/payShare?deviceId=3&money=2&sence=");
 //        res.put("pages", "../reciveCharging/reciveCharging?deviceId=3");
                      
 //       res.put("pages", "../scaneCode/scaneCode?deviceNo=didi5010001002&sence=");
       
        
        System.out.println("成功进入函数");
        
        try {
        	
            String code = (String)data.get("code");
            
            //用于校验签名
            String rawData = (String)data.get("rawData");
            String signature = (String)data.get("signature");

            //获取邀请码
            String invideCode=(String)data.get("invideCode");
        
            //获取用户信息    
            Map<String,Object> userInfo = (Map<String,Object>)data.get("userInfo");
            String avatarUrl = (String)userInfo.get("avatarUrl");  //拉取头像          
            String nickName = (String)userInfo.get("nickName");    //拉取尼称            
            nickName= EmojiDealUtil.getNonEmojiString(nickName);   
            int gender = (int)userInfo.get("gender");              //拉取性别 
            
            String country = (String)userInfo.get("country");       
            String province = (String)userInfo.get("province");
            String city = (String)userInfo.get("city");            
            String address =country+","+province+","+city;         //拉取地址
            
            
            //通过js_code 获取openId和sessionKey
            String getParam="appid="+ServerUtils.MINIPROGRAM_APPID
            		        +"&secret="+ServerUtils.MINIPROGRAM_APPSECRET
            		        +"&js_code="+code
            		        +"&grant_type="+"authorization_code";
            
            Map<String, Object> getResponseBody=ClientGet(ServerUtils.MINIPROGRAM_CODE2SESSION_URL,getParam);
            
            String openid = (String)getResponseBody.get("openid");
            String sessionKey = (String)getResponseBody.get("session_key");
            
            //参数校验
            String signedData = DigestUtils.sha1DigestAsHex(rawData + sessionKey);
            if(!signedData.equals(signature)){
            	 res.put("status",210);
                 res.put("message","数据校验失败!");
            }
            
            
            //通过openId查找用用户
            EUser userForList=new EUser();
            userForList.setWechatId(openid);
                      
            Map<String, Object> userMap=service.list(userForList, 1, 99);
            
            Integer num=(Integer)userMap.get("total");
            
            //如果只找一个用户
            if(num==1){
            	          	
            	 List<Map<String,Object>> userData = (List<Map<String,Object>>)userMap.get("data");
                 EUser user = (EUser) userData.get(0);
                 Map<String,Object> respData = new HashMap<String,Object>();
                                                  
                 
                 Integer role=user.getRole();
               
                 if(role == null) role = 2;
        
                 
                 String jwt = JWTUtils.createJWT(user.getId(),"2",1000*60*30);
     
                 respData.put("data",user);
                 //respData.put("accessToken",jwt); 
                 respData.put("accessToken","hoauifjij");
                 res.put("result",respData);               
                 res.put("status",200);
                 res.put("isNew", "false");
                 res.put("message","用户已注册！");
                 return res;
            }
            
            //没有找到用户
            if(num==0){
            	 
            	 System.out.println("开始注册函数");
            	 
            	 EUser user=new EUser();
            	 user.setId(TextUtils.getIdByUUID());
                 user.setAddress(address);
                 user.setElectric(0);
                 user.setOrders(0);
                 user.setState(StateUtils.STATE_NORMAL);
                 Date createTime = new Date();
                 user.setCreateTime(createTime);
                     
            	 user.setWechatId(openid);
            	 user.setNickName(nickName);
            	 user.setSex(gender);
            	 
            	 user.setProfileImage(avatarUrl);
            	 user.setInvideUser(invideCode);
            	         	 
            	 String qrImgUrl=service.getQrImgUrl(user.getId());	
         		 user.setQrImg(qrImgUrl);
            	             	             	 
    			 user.setRole(EUser.NORMAL);
    			 
    		     user.setLastLoginTime(createTime);        	 
              
            	 int num1=service.insert(user);
            	 System.out.println(num1);
            	 
            	 
            	 if(num1==1){
            		                   
                     Map<String,Object> respData = new HashMap<String,Object>();
      
                     Integer role=user.getRole();
                     if(role == null) role = 2;
                     String jwt = JWTUtils.createJWT(user.getId(),"2",1000*60*30);
         
                     respData.put("data",user);
                     respData.put("accessToken",jwt);
                     res.put("result",respData);
                     
                     res.put("status",200);
                     res.put("isNew", "true");
                     res.put("message","用户已注册！");
                     return res;
            		 
            	 }else{
            		  res.put("status",500);
                      res.put("message","用户注册失败！");
                      return res; 
            	 }
 
            }
            
            if(num>1){
            	 res.put("status",500);
                 res.put("message","账户错误");
            }

            
        } catch (Exception e) {
    
            e.printStackTrace();
            res.put("status",210);
            res.put("message", e.getMessage());
            
        }
        return res;
                
    }
    
    private Map<String, Object> ClientGet(String url, String param) {

		CloseableHttpClient httpClient = HttpClients.createDefault();
		String urlNameString = url + "?" + param;

		String token = "";

		Map<String, Object> map=new HashMap<String, Object>();
		
		try {

			// 用get方法发送http请求
			HttpGet get = new HttpGet(urlNameString);
			System.out.println("执行get请求:...." + get.getURI());
			CloseableHttpResponse httpResponse = null;

			// 发送请求
			httpResponse = httpClient.execute(get);
			HttpEntity entity = httpResponse.getEntity();

			if (null != entity) {

				JSONObject obj = JSONObject.fromObject(EntityUtils.toString(entity));
				map = (Map) obj;

				token = (String) map.get("openid");
			
			}

			httpClient.close();

		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return  map;

	}
    
    

       
}
