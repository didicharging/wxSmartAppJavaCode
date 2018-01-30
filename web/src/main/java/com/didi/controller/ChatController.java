package com.didi.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.didi.model.EChat;
import com.didi.service.ChatService;
import com.didi.unti.EmojiDealUtil;

@Controller
@RequestMapping("/resource-service/chat")
public class ChatController {

	@Resource
	ChatService chatService;

	// 获取私信记录
	@RequestMapping(value = "/getChatList", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getChatList(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int perPage, @RequestParam(required = false) String fromUser,
			@RequestParam(required = false) String toUser) {
		Map<String, Object> res = new HashMap<String, Object>();
		try {
			EChat chat = new EChat();
			if (toUser == null && fromUser == null) {
				res.put("status", 300);
				res.put("message", "请至少选择接收方!");
			} else {
				chat.setToUser(toUser);
				chat.setFromUser(fromUser);
				chat.setIsDelete(0);
				
				res.put("result", chatService.list(chat, page, perPage));
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

	// 拉取发给我的私信
	@RequestMapping(value = "/getToMeChat", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getToMeChat(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int perPage, @RequestParam(required = false) String toUser) {
		Map<String, Object> res = new HashMap<String, Object>();
		try {
			EChat chat = new EChat();
			if (toUser == null) {
				res.put("status", 300);
				res.put("message", "请至少选择一个发送方或者接收方!");
			} else {
				chat.setToUser(toUser);

				res.put("result", chatService.GetToMeList(chat, page, perPage));
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

	// 发送私信
	@RequestMapping(value = "/postChat", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> postChat(@RequestBody Map<String, Object> param) {
		Map<String, Object> res = new HashMap<String, Object>();
		try {
			Object content = param.get("content");
			Object fromUser = param.get("fromUser");
			Object toUser = param.get("toUser");
			if (content == null || content.toString().equalsIgnoreCase("")) {
				res.put("status", 210);
				res.put("message", "私信内容不能为空!");
			} else if (fromUser == null || fromUser.toString().equalsIgnoreCase("")) {
				res.put("status", 210);
				res.put("message", "发送方ID不能为空!");
			} else if (toUser == null || toUser.toString().equalsIgnoreCase("")) {
				res.put("status", 210);
				res.put("message", "接收方ID不能为空!");
			} else {
				EChat chat = new EChat();
				chat.setChatDate(new Date());

				chat.setContent(EmojiDealUtil.getNonEmojiString(content.toString()));
				chat.setFromUser(fromUser.toString());
				chat.setToUser(toUser.toString());
				chatService.insert(chat);

				res.put("status", 200);
				res.put("message", "发送私信成功!");
			}
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "发送私信失败!错误原因：" + e.getMessage());
			return res;
		}
	}

	// 读私信
	@RequestMapping(value = "/readChat", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> readChat(@RequestParam String id) {

		Map<String, Object> res = new HashMap<String, Object>();

		try {

			if (null == id || id.equals("")) {
				res.put("status", 210);
				res.put("message", "参数输入不能为空!");
				return res;
			}

			EChat chat = chatService.get(id);
			if (null == chat) {
				res.put("status", 210);
				res.put("message", "参数输入错误");
				return res;
			}

			chat.setIsRead(1);

			int num = chatService.edit(chat);

			if (num > 0) {
				res.put("status", 200);
				res.put("message", "已读!");
				return res;
			} else {
				res.put("status", 200);
				res.put("message", "程序出错!");
				return res;
			}

		} catch (Exception e) {
			res.put("status", 210);
			res.put("message", "操作失败!错误原因：" + e.getMessage());
			return res;
		}

	}
}
