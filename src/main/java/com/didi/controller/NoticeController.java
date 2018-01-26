package com.didi.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.didi.model.ENotice;
import com.didi.service.NoticeService;

@Controller
@RequestMapping("/resource-service/notice")
public class NoticeController {

	@Resource
	NoticeService noticeService;

	// 获取我的设备列表
	@RequestMapping(value = "/getNoticeList", method = RequestMethod.GET)
	   @ResponseBody
	public Map<String, Object> getNoticeList(
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int perPage) {
		Map<String, Object> res = new HashMap<String, Object>();
		try {
			ENotice notice = new ENotice();
			notice.setIsDelete(0);
			res.put("result", noticeService.list(notice, page, perPage));
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
	
}
