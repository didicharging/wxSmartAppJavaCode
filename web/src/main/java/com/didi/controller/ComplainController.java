package com.didi.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.didi.model.EComplain;
import com.didi.model.EComplainExample;
import com.didi.service.ComplainService;
import com.didi.unti.TextUtils;

@Controller
@RequestMapping("/resource-service/complain")
public class ComplainController {

	@Resource
	ComplainService complainService;

	@RequestMapping(value = "/addComplain", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> postChat(@RequestParam(required = true) String userId,
			@RequestParam(defaultValue = "") String deviceId, @RequestParam(defaultValue = "") String content,
			@RequestParam(defaultValue = "") String imgUrl, @RequestParam(defaultValue = "") String address,
			@RequestParam(required = true) int type) {
		Map<String, Object> res = new HashMap<String, Object>();

		try {
			EComplain complain = new EComplain();
			complain.setId(TextUtils.getIdByUUID());
			complain.setContent(content);
			complain.setDeviceid(deviceId);
			complain.setImgUrl(imgUrl);
			complain.setCreateTime(new Date());
			complain.setType(type);
			complain.setAddress(address);

			complainService.insert(complain);

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

	@RequestMapping(value = "/getMyComplain", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getMyComplain(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int perPage, @RequestParam(required = true) String userId) {
		Map<String, Object> res = new HashMap<String, Object>();

		try {
			EComplainExample example = new EComplainExample();
			EComplainExample.Criteria criteria = example.createCriteria();
			criteria.andUseridEqualTo(userId);
			List<EComplain> list = (List<EComplain>) complainService.list(example, page, perPage).get("data");
			res.put("list", list);
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
