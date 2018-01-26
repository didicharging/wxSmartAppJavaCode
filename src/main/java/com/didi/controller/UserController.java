package com.didi.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.didi.model.EUser;
import com.didi.service.UserService;
import com.didi.unti.EmojiDealUtil;
import com.didi.unti.TextUtils;

/**
 * Created by wangh09 on 2017/4/30.
 */
@Controller
@RequestMapping("/account-service/user")
public class UserController {

	@Resource
	UserService userService;


	@RequestMapping(value = "/register", method = RequestMethod.POST)
	   @ResponseBody
	public Map<String, Object> register(@RequestBody EUser user) {
		Map<String, Object> res = new HashMap<String, Object>();
		try {
			int status = userService.insert(user);
			
			if (status == 1) {
				res.put("status", 200);
				res.put("message", "添加成功!");
				Map<String, Object> result = new HashMap<String, Object>();
				result.put("data", user);
				res.put("result", result);
			} else {
				res.put("status", 210);
				res.put("msg", "添加失败!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message",
					TextUtils.underline2Camel(e.getCause().getMessage()));
		}
		return res;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	   @ResponseBody
	public Map<String, Object> list(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int perPage,
			@RequestParam(required = false) String wechatId,
			@RequestParam(required = false) String profileImage
			) {
		Map<String, Object> res = new HashMap<String, Object>();
		try {
			EUser user = new EUser();
			
			if (wechatId != null) {
			
				user.setWechatId(wechatId);
			}
						
			res.put("status", 200);
			res.put("message", "查找成功!");
			res.put("result", userService.list(user, page, perPage));
		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "查找失败!");
		}
		return res;
	}

	@RequestMapping(value = "/getUserInfoById", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getUserInfoById(
			@RequestParam(required = true) String id) {
		Map<String, Object> res = new HashMap<String, Object>();
		try {
			Map<String, Object> userInfo = userService.getUserInfoById(id);
			if (userInfo == null) {
				res.put("status", 210);
				res.put("message", "查无此人!");
			} else {
				res.put("user", userInfo);
				res.put("test", "test");
				res.put("status", 200);
				res.put("message", "查找成功!");
			}

			return res;
		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "查找失败!错误原因：" + e.getMessage());
			return res;
		}
	}
	
	@RequestMapping(value = "/getRankingList", method = RequestMethod.GET)
	   @ResponseBody
	public Map<String, Object> getRankingList(
			@RequestParam(required = true) String userId){
		Map<String, Object> res = new HashMap<String, Object>();
		try {
            res=userService.getRankingList(userId);

			return res;
		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "查找失败!错误原因：" + e.getMessage());
			return res;
		}

	}
	
		
	@RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
	   @ResponseBody
	public Map<String, Object> updateUserInfo(
			@RequestBody Map<String, Object> param) {
		Map<String, Object> res = new HashMap<String, Object>();
		try {
		
			EUser user = userService.get(param.get("userId").toString());
			if (user == null) {
				res.put("status", 210);
				res.put("message", "用户不存在");
				return res;
			}
			
		    user.setNickName(EmojiDealUtil.getNonEmojiString(param.get("nickName").toString()));			
			user.setName(EmojiDealUtil.getNonEmojiString(param.get("name").toString()));
			user.setSex(Integer.valueOf(param.get("sex").toString()));
			user.setPhone(param.get("mobile").toString());
		    user.setAge(Integer.valueOf(param.get("age").toString()));
			user.setIdCard(param.get("idCard").toString());
			user.setProfileImage(param.get("profileImage").toString());
			userService.edit(user);
			
			res.put("status", 200);
			res.put("message", "更新成功!");
			
			return res;
			
		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "更新失败!错误原因：" + e.getMessage());
			return res;
		}
	}
	
	
}
