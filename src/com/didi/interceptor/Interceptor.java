package com.didi.interceptor;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.didi.model.DApi;
import com.didi.service.APIService;
import com.didi.unti.JWTUtils;

import io.jsonwebtoken.Claims;
import net.sf.json.JSONObject;

public class Interceptor extends HandlerInterceptorAdapter {

	@Resource
	APIService apiService;
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// return false 拦截 return true 不拦截

		System.out.println("开始拦截测试");
		
		List<String> notFilter=new ArrayList<String>();
		
		notFilter.add("/image/");
		notFilter.add("/resource-service/share/getActive");
		notFilter.add("/resource-service/pay/getDeviceShareFeeReply");
											
		notFilter.add("/resource-service/pay/getDeviceUseFeeReply");
		notFilter.add("/resource-service/pay/getRechargeReply");
		
		notFilter.add("/resource-service/device/getDeviceState"); 
		
		notFilter.add("/gateway/onMiniProgramLogin");
		String uri = request.getRequestURI().substring(3);

		
		
		if(notFilter.contains(uri)){
			System.out.println("不在检查范围内");
			return true;
		}
		
		
		JSONObject json = new JSONObject();// 本质是map
		//检查资源合理性
		DApi api=new DApi();
		api.setApi(uri);				
		List<DApi> apiList=(List<DApi>) apiService.list(api, 1, 10).get("data");
		
		if(apiList.size()<1){
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");
			json.put("status", 401);
			json.put("message", "资源未找到");

			PrintWriter out = null;

			try {
				out = response.getWriter();
				out.append(json.toString());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (out != null) {
					out.close();
				}
			}
			return false;
		}
		
		String jwt = request.getHeader("Access-Token");
		
		
		// 检查未登录
		if (jwt == null) {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");
			json.put("status", 401);
			json.put("message", "用户未登录");

			PrintWriter out = null;

			try {
				out = response.getWriter();
				out.append(json.toString());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (out != null) {
					out.close();
				}
			}
			return false;
		}

		
		// 检查超时
		try {
			Claims claim = JWTUtils.parseJWT(jwt);
			// 读取claim, 增加权限控制
		} catch (Exception e) {
			// 有jwt,但是无法正常解析，
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");
			json.put("status", 401);
			json.put("message", "登陆异常或登陆状态已过期");

			PrintWriter out = null;

			try {
				out = response.getWriter();
				out.append(json.toString());
			} catch (Exception e2) {
				e2.printStackTrace();
			} finally {
				if (out != null) {
					out.close();
				}
			}
			return false;

		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		String userId=request.getParameter("userId");
		
		String uri = request.getRequestURI().substring(3);
		if(uri.equalsIgnoreCase("/resource-service/pay/getShareList")){
			System.out.println("拦截器获取到的userId: "+userId);
			String jwt =JWTUtils.createJWT(userId, "2", 1000*60*30);
			response.setHeader("Access-Token",jwt);
			
		}
		

		System.out.println("Access-Token 刷新");

	}

}
