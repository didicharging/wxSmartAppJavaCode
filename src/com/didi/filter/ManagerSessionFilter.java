package com.didi.filter;  
  
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.alibaba.fastjson.JSONObject;


  
public class ManagerSessionFilter extends OncePerRequestFilter {  
  
    @Override  
    protected void doFilterInternal(HttpServletRequest request,  
            HttpServletResponse response, FilterChain filterChain)  
            throws ServletException, IOException {  
  
        String[] notFilter = new String[] {"/admin/login.do",
        								  "/admin/logout.do",
        		
        								
        								};  
        
        String uri = request.getRequestURI();  
  
        boolean doFilter = true;  
        
        for (String s : notFilter) {  
            if (uri.indexOf(s) != -1) {  
                // 如果uri中包含不过滤的uri，则不进行过滤  
                doFilter = false;  
                break;  
            }  
        }
        
        if (doFilter) {  
            Object obj = request.getSession().getAttribute("admin");  
            if (obj == null) {
            	
            	JSONObject json = new JSONObject();//本质是map
        		json.put("status",220);
        		json.put("message", "未登录");
        	
        		
        	
        		//调用JSONObject对象的toString()方法将JSONObject对象中存储的映射关系转成json格式的字符串
        		String s = json.toString();
    		    response.setCharacterEncoding("UTF-8");  
    		    response.setContentType("application/json; charset=utf-8");  	
        		PrintWriter out = null;  
        		try{
        			out = response.getWriter();  
        			out.append(json.toString());
        		}catch(Exception e){
        			e.printStackTrace();
        		}finally{
        			if(out != null){
        				out.close();
        			}
        		}
            }else {  
                filterChain.doFilter(request, response);  
            }  
        } else {  
            filterChain.doFilter(request, response);  
        }  
    }  
}