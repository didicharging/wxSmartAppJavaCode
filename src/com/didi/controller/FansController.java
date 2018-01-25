package com.didi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.didi.model.EFans;
import com.didi.service.FansService;

@RestController
@RequestMapping("/resource-service/fans")
public class FansController {

	@Resource
	FansService fansService;

	// 获取我的粉丝列表
	@RequestMapping(value = "/getFansList", method = RequestMethod.GET)
	public Map<String, Object> getFansList(
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int perPage,
			@RequestParam(required = true) String userId) {
		Map<String, Object> res = new HashMap<String, Object>();
		try {
			EFans fans = new EFans();
			fans.setStarUserId(userId);
			res.put("result", fansService.list(fans, page, perPage));
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

	// 获取我的关注列表
	@RequestMapping(value = "/getFollowList", method = RequestMethod.GET)
	public Map<String, Object> getFollowList(
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int perPage,
			@RequestParam(required = true) String userId) {
		Map<String, Object> res = new HashMap<String, Object>();
		try {
			EFans fans = new EFans();
			fans.setFansUserId(userId);
			res.put("result", fansService.list(fans, page, perPage));
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

	// 删除粉丝
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/delFans", method = RequestMethod.GET)
	public Map<String, Object> delFans(
			@RequestParam(required = true) String userId,
			@RequestParam(required = true) String fansUserId) {
		Map<String, Object> res = new HashMap<String, Object>();
		try {
			EFans fans = new EFans();
			fans.setStarUserId(userId);
			fans.setFansUserId(fansUserId);
			List<EFans> fansList = (List<EFans>) fansService.list(fans, 1, 10)
					.get("data");
			if (fansList != null && fansList.size() == 0) {
				res.put("status", 210);
				res.put("message", "粉丝不存在!");
			} else {
				for (EFans f : fansList) {
					fansService.delete(f.getId());
				}
				res.put("status", 200);
				res.put("message", "删除成功!");
			}
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "删除失败!错误原因：" + e.getMessage());
			return res;
		}
	}

	// 取消关注
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/delFollow", method = RequestMethod.GET)
	public Map<String, Object> delFollow(
			@RequestParam(required = true) String userId,
			@RequestParam(required = true) String followUserId) {
		Map<String, Object> res = new HashMap<String, Object>();
		try {
			EFans fans = new EFans();
			fans.setStarUserId(followUserId);
			fans.setFansUserId(userId);
			List<EFans> fansList = (List<EFans>) fansService.list(fans, 1, 10)
					.get("data");
			if (fansList != null && fansList.size() == 0) {
				res.put("status", 210);
				res.put("message", "关注不存在!");
			} else {
				for (EFans f : fansList) {
					fansService.delete(f.getId());
				}
				res.put("status", 200);
				res.put("message", "取消关注成功!");
			}
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "取消失败!错误原因：" + e.getMessage());
			return res;
		}
	}

	// 关注他人
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/follow", method = RequestMethod.GET)
	public Map<String, Object> follow(
			@RequestParam(required = true) String userId,
			@RequestParam(required = true) String followUserId) {
		Map<String, Object> res = new HashMap<String, Object>();
		try {
			EFans fans = new EFans();
			
			if (null == followUserId || followUserId.equals("") || null==userId || userId.equals("")) {
				res.put("status", 210);
				res.put("message", "参数输入不能为空!");
				return res;
			}
			
			if(userId.equals(followUserId)){
				res.put("status", 211);
				res.put("message", "不能关注自己");
				return res;
			}
			
			fans.setStarUserId(followUserId);
			fans.setFansUserId(userId);
			List<EFans> fansList = (List<EFans>) fansService.list(fans, 1, 10)
					.get("data");
			if (fansList != null && fansList.size() == 0) {
				fansService.insert(fans);
				res.put("status", 200);
				res.put("message", "关注成功!");
			} else {
				res.put("status", 210);
				res.put("message", "已经关注，请不要重复关注!");
			}
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "关注失败!错误原因：" + e.getMessage());
			return res;
		}
	}

}
