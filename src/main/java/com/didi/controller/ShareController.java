package com.didi.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.didi.model.DShareMode;
import com.didi.model.EFans;
import com.didi.model.EShare;
import com.didi.model.EShareAct;
import com.didi.model.EShareActExample;
import com.didi.model.ESharePo;
import com.didi.model.EUser;
import com.didi.service.DeviceService;
import com.didi.service.FansService;
import com.didi.service.NoticeService;
import com.didi.service.ShareService;
import com.didi.service.WalletLogService;
import com.didi.unti.EmojiDealUtil;
import com.didi.unti.TextUtils;

@Controller
@RequestMapping("/resource-service/share")
public class ShareController {

	@Resource
	ShareService shareService;
	
	@Resource
	DeviceService deviceService;
	
	@Resource
	WalletLogService walletLogService;

	@Resource
	NoticeService noticeService;

	@Resource
	FansService fansService;
//	
//	@Resource
//	PrizeService prizeService;
	
	private Logger log = Logger.getLogger(ShareController.class);
	

	// 和共享互动（点赞、评论）
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/actShare", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> actShare(@RequestBody Map<String, Object> param) {
		Map<String, Object> res = new HashMap<String, Object>();
		try {

			Object userId = param.get("userId");
			Object shareId = param.get("shareId");
			Object actType = param.get("actType");
			Object content = param.get("content");

			if (null == userId || null == shareId || null == actType) {
				res.put("status", 210);
				res.put("message", "参数输入不能为空!");
			} else if (actType.toString().equalsIgnoreCase("2") && null == content) {
				res.put("status", 210);
				res.put("message", "评论内容不能为空!");
			} else {
				EShareAct act = new EShareAct();
				act.setUserId(userId.toString());
				act.setShareId(shareId.toString());
				act.setActType(Integer.parseInt(actType.toString()));
				act.setIsRead(0);
				if (actType.toString().equalsIgnoreCase("1")) {

					List<EShareAct> list = (List<EShareAct>) shareService.listAct(act, 1, 999).get("data");

					if (null != list && list.size() > 0) {
						res.put("status", 210);
						res.put("message", "请不要重复点赞!");
					} else {
						
						shareService.insertAct(act);
						res.put("status", 200);
						res.put("message", "点赞成功!");
					}
				} else {

					act.setActContent(EmojiDealUtil.getNonEmojiString(content.toString()));
					shareService.insertAct(act);
					res.put("status", 200);
					res.put("message", "评论成功!");
				}
			}
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "操作失败!错误原因：" + e.getMessage());
			return res;
		}
	}

	@RequestMapping(value = "/getBanner", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getBanner(){
		Map<String, Object> res = new HashMap<String, Object>();
		
		List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
		
		Map<String, Object> banner1 = new HashMap<String, Object>();
		
		banner1.put("img_url","http://didicharging-v2.oss-cn-beijing.aliyuncs.com/banner1.jpg?a="+TextUtils.getIdByUUID());
		
		banner1.put("active_id","");
		
		banner1.put("titel", "");
			
		Map<String, Object> banner2 = new HashMap<String, Object>();
		banner2.put("img_url","http://didicharging-v2.oss-cn-beijing.aliyuncs.com/banner2.jpg?a="+TextUtils.getIdByUUID());
		banner2.put("active_id","");
		banner2.put("titel", "");
		
		Map<String, Object> banner3 = new HashMap<String, Object>();
		banner3.put("img_url","http://didicharging-v2.oss-cn-beijing.aliyuncs.com/banner3.jpg?a="+TextUtils.getIdByUUID());
		banner3.put("active_id","");
		banner3.put("titel", "");

		Map<String, Object> banner4 = new HashMap<String, Object>();
		banner4.put("img_url","http://didicharging-v2.oss-cn-beijing.aliyuncs.com/banner4.jpg?a="+TextUtils.getIdByUUID());
		banner4.put("active_id","");
		banner4.put("titel", "");
		
		Map<String, Object> banner5 = new HashMap<String, Object>();
		banner5.put("img_url","http://didicharging-v2.oss-cn-beijing.aliyuncs.com/banner5.jpg?a="+TextUtils.getIdByUUID());
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
	
	@RequestMapping(value = "/getActive", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getActive(String id){
		Map<String, Object> res = new HashMap<String, Object>();
	
		String url="http://didicharging-v2.oss-cn-beijing.aliyuncs.com/code/loading.jpg";
		
		List<String> urlList=new ArrayList<String>();
		urlList.add("http://didicharging-v2.oss-cn-beijing.aliyuncs.com/code/loding/loading1.jpg");
		urlList.add("http://didicharging-v2.oss-cn-beijing.aliyuncs.com/code/loding/loading2.jpg");
		urlList.add("http://didicharging-v2.oss-cn-beijing.aliyuncs.com/code/loding/loading3.jpg");
		urlList.add("http://didicharging-v2.oss-cn-beijing.aliyuncs.com/code/loding/loading4.jpg");
		urlList.add("http://didicharging-v2.oss-cn-beijing.aliyuncs.com/code/loding/loading5.jpg");
		
		Random romdom =new Random();
		res.put("url",urlList.get(romdom.nextInt(urlList.size()-1)));
		res.put("status", 200);
		res.put("message", "查找成功!");		
		return res;
	}
	

	// 删除共享互动（点赞、评论）
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/deleteActShare", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> deleteActShare(@RequestParam String userId, @RequestParam String shareId) {
		Map<String, Object> res = new HashMap<String, Object>();
		try {

			if (null == userId || userId.equals("") || null == shareId || shareId.equals("")) {
				res.put("status", 210);
				res.put("message", "参数输入不能为空!");
				return res;
			}

			EShareAct share = new EShareAct();

			share.setUserId(userId);
			share.setShareId(shareId);

			int num = shareService.deleteAct(share);

			if (num != 0) {

				res.put("status", 200);
				res.put("message", "删除成功!");
			} else {
				res.put("status", 200);
				res.put("message", "删除失败!");
			}

			return res;
		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "操作失败!错误原因：" + e.getMessage());
			return res;
		}
	}

	@RequestMapping(value = "/readShareAct", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> readShareAct(@RequestParam String id) {

		Map<String, Object> res = new HashMap<String, Object>();

		try {

			if (null == id || id.equals("")) {
				res.put("status", 210);
				res.put("message", "参数输入不能为空!");
				return res;
			}

			EShareAct shareAct = shareService.getShareActByid(id);
			if (null == shareAct) {
				res.put("status", 210);
				res.put("message", "参数输入错误");
				return res;
			}

			shareAct.setIsRead(1);

			int num = shareService.editAct(shareAct);

			if (num > 0) {
				res.put("status", 200);
				res.put("message", "已读!");
				return res;
			} else {
				res.put("status", 211);
				res.put("message", "程序出错!");
				return res;
			}
		} catch (Exception e) {
			res.put("status", 210);
			res.put("message", "操作失败!错误原因：" + e.getMessage());
			return res;
		}

	}

	// 放电（发布共享）
	@RequestMapping(value = "/addShare", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addShare(@RequestBody Map<String, Object> param) {
		Map<String, Object> res = new HashMap<String, Object>();
		System.out.println("进入发布分享函数");
		try {
			Object deviceId = param.get("deviceId");
			Object content = param.get("content");
			Object imageHeight = param.get("imageHeight");
			Object imageWidth = param.get("imageWidth");
			Object imgUrl = param.get("imgUrl");

			Object userId = param.get("userId");
			Object address = param.get("address");
			Object longitude = param.get("longitude");
			Object latitude = param.get("latitude");

			System.out.println("imgUrl"+imgUrl.toString());
	

			if (imgUrl == null || imgUrl.toString().equalsIgnoreCase("") || content == null
					|| content.toString().equalsIgnoreCase("")) {
				res.put("status", 210);
				res.put("message", "放电失败，图片和内容不能同时为空!");
			}
			
		
			else {
				EShare share = new EShare();

				share.setId(TextUtils.getIdByUUID());
				
				share.setContent(EmojiDealUtil.getNonEmojiString(content.toString()));

				share.setDeviceId(deviceId.toString());
				share.setImageHeight(Integer.parseInt(imageHeight.toString()));
				share.setImageWidth(Integer.parseInt(imageWidth.toString()));
				share.setImgUrl(imgUrl.toString());
				share.setIsDelete(0);

				if (null != latitude && !latitude.toString().equalsIgnoreCase(""))
					share.setLatitude(Double.parseDouble(latitude.toString()));

				if (null != longitude && !longitude.toString().equalsIgnoreCase(""))
					share.setLongitude(Double.parseDouble(longitude.toString()));

				if (null != address && !address.toString().equalsIgnoreCase(""))
					share.setAddress(address.toString());

				share.setUserId(userId.toString());
				
				shareService.insert(share);
				
				res.put("shareId", share.getId());
				res.put("status", 200);
				res.put("message", "放电成功!");
			}

			return res;
		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "放电失败!错误原因：" + e.getMessage());
			return res;
		}
	}

	// 获取附近分享列表
	@RequestMapping(value = "/getShareList", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getShareList(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int perPage, @RequestParam String userId,
			@RequestParam(defaultValue = "new") String status) {

		log.info("不是这样的");
		
		Map<String, Object> res = new HashMap<String, Object>();
		Map<String, Object> map =new HashMap<String, Object>();
			
		try {
			
			EShare share = new EShare();
			
			if(status.equalsIgnoreCase("hot")){
		
				share.setUserId(userId);
				map = shareService.listHot(share, 0, 0);	
			} 
			else
			{
				share.setIsDelete(0);
				map = shareService.list(share, page, perPage);
			}
						
			// 分享列表
			List<EShare> shareList = (List<EShare>) map.get("data");

			// 生成目标列表
			List<ESharePo> shareListPo = new ArrayList<ESharePo>();

			for (EShare eShare : shareList) { // 遍历分享列表,得到每条作者

				ESharePo sharePo = new ESharePo(eShare);
				sharePo.setTimeInfo(getTimeInfo(sharePo.getShareDate()));
				
				EShareActExample actExample=new EShareActExample();
				EShareActExample.Criteria criteria=actExample.createCriteria();
				criteria.andShareIdEqualTo(eShare.getId());
				
				sharePo.setReadCount(eShare.getCount());
				
				shareListPo.add(sharePo);
			}

			map.put("data", shareListPo);
			res.put("result", map);
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
	
	@RequestMapping(value = "/getMyShareList", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getMyShareList(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int perPage, @RequestParam String shareUserId,
			@RequestParam String userId) {

		Map<String, Object> res = new HashMap<String, Object>();
		try {
			EShare share = new EShare();
			share.setIsDelete(0);
			share.setUserId(shareUserId);
			Map<String, Object> map = shareService.getMyShareList(share, page, perPage);

			EFans fans = new EFans();
			fans.setFansUserId(userId);

			// 判断是否已关注作者
			List<EFans> fansList = (List<EFans>) fansService.list(fans, 1, 20).get("data");

			boolean flag = false;
			for (EFans eFans : fansList) {
				String Startid = eFans.getStarUserId();
				if (Startid.equals(shareUserId)) {
					flag = true;
					break;
				}
			}

			map.put("isNotice", flag);

			res.put("result", map);
			res.put("message", "查找成功!");
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "查找失败!错误原因：" + e.getMessage());
			return res;
		}
	}

	@RequestMapping(value = "/getShareModeList", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getShareModeList(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int perPage) {

		Map<String, Object> res = new HashMap<String, Object>();
		try {
			
			EShare share = new EShare();
			share.setIsDelete(0);

			List<DShareMode> list = new ArrayList<DShareMode>();

			list.add(new DShareMode(1, "一", "你好，世界"));
			list.add(new DShareMode(2, "二", "再忙，也得亲自活"));
			list.add(new DShareMode(3, "三", "所有不明真相的，都赶着投胎"));
			list.add(new DShareMode(4, "四", "幸福像是浑然不觉，常常在别人的眼里"));
			list.add(new DShareMode(5, "五", "一阵夜风吹过，感觉自己都在掉叶"));
			list.add(new DShareMode(6, "六", "天道不仇勤。只愁君不勤"));
			list.add(new DShareMode(7, "七", "人生，就是被时间逗着玩"));
			list.add(new DShareMode(8, "八", "不忘初心，方得始终"));
			list.add(new DShareMode(9, "九", "幸福像是浑然不觉，常常在别人的眼里"));
			list.add(new DShareMode(10, "十", "折腾，似乎是唯一的活法，每一个白天，我都失眠"));
			list.add(new DShareMode(11, "十一", "世界上最好的感觉就是知道有人在想你"));
			list.add(new DShareMode(12, "十二", "在最适合的年纪，穿上最美的婚纱，嫁给最稳妥的人"));
			list.add(new DShareMode(13, "十三", "被人惦念的滋味是如此让人受宠若惊"));
			list.add(new DShareMode(14, "十四", "有时候，你的一句话可以让我回味几天。有时候，你的一句话也可以让我失望几天。这就是在乎"));
			
			list.add(new DShareMode(15, "十五", "告诉自己，现在的你不能再混再疯再懒惰了，前途很重要"));
			list.add(new DShareMode(16, "十六", "一些受过伤的人会更加勇敢，因为他们知道，最痛不过如此"));
			list.add(new DShareMode(17, "十七", "一个人怎么看待自己，决定了此人的命运，指向了他的归宿"));
			list.add(new DShareMode(18, "十八", "只要你要、只要我有。倾我所能、尽我所有。"));
			
			list.add(new DShareMode(19, "十九", "越有浓度的陶醉，越有深处的累"));
			list.add(new DShareMode(20, "二十", "沦陷在你的怀抱里，逃脱不了命运的魔爪"));
			list.add(new DShareMode(21, "二十一", "如果允许，我可以牵着谁的手，走到末日尽头"));
			list.add(new DShareMode(22, "二十二", "你们怎么讲怎么想，都不关我的事，我的眼心中只有他"));
			
			list.add(new DShareMode(23, "二十三", "有心的人，再远也会记挂对方；无心的人，近在咫尺却远在天涯"));
			list.add(new DShareMode(24, "二十四", "别把你的女人不当回事，有一天，会有另外一个男人过来，感激你不懂得她的好"));
			list.add(new DShareMode(25, "二十五", "我多想有个人能对我说：你不用改变自己，我来习惯你就可以了"));
			
			list.add(new DShareMode(26, "二十六", "有些记忆就算是忘不掉，也要假装记不起，因为喜欢，所以情愿，没有那么多为什么"));
			list.add(new DShareMode(27, "二十七", "失去的就再也找不回来、可我还是在徘徊"));
			list.add(new DShareMode(28, "二十八", "亲爱的，你以为还有人比我更适合你么"));
			list.add(new DShareMode(29, "二十九", "有些事情要绝望到底、才能够看透"));
			list.add(new DShareMode(30, "三十一", "我永远都不会忘记你，心里的角落永远都有你的位置"));
			list.add(new DShareMode(31, "三十二", "我们像是表面上的针，不停的转动，一面转，一面看着时间匆匆离去，却无能为力"));
			list.add(new DShareMode(32, "三十三", "牵着我的手，闭着眼睛走你也不会迷路"));
			list.add(new DShareMode(33, "三十四", "喜欢和你在一起，哪怕一句话也不说，你的一个表情，也让我从心里欢喜"));
			list.add(new DShareMode(34, "三十五", "我哒哒的马蹄是个美丽的错误，我只是过客，不是归人"));
			list.add(new DShareMode(35, "三十六", "要理想不要幻想，要激情不要矫情。凡事知足常乐"));
			list.add(new DShareMode(36, "三十七", "很多时候，心里明明不是那样想的，却控制不了自己而说出相反的话"));
			list.add(new DShareMode(37, "三十八", "你对我的话，我一直深信不疑，即使我知道下一秒我会从天堂堕入地狱"));
			list.add(new DShareMode(38, "三十九", "爱将我们高高举起以后、再让心学会坠落"));
			list.add(new DShareMode(39, "四十",   "在轻触彼此的瞬间，心动，共鸣直至永恒"));
			list.add(new DShareMode(40, "四十一", "每天早上醒来，看见你和阳光都在，这就是，我想要的未来"));
			list.add(new DShareMode(41, "四十二", "我宁愿相信自己的眼泪，也不会相信你的解释"));
			
			list.add(new DShareMode(42, "四十三", "你说把爱放开，会渐渐走远。我说，玫瑰离开水会渐渐枯萎"));
			list.add(new DShareMode(43, "四十四", "简简单单的两个字，让人看不透，让人沉沦"));
			list.add(new DShareMode(44, "四十五", "享受的不是爱你，而是你给的温暖"));
			list.add(new DShareMode(45, "四十六", "站在街角，若我微笑，便是我想起了你"));
			list.add(new DShareMode(46, "四十七", "我希望有人告诉我，有时候想念我也会令他难受"));
			list.add(new DShareMode(47, "四十八", "如果可以，我想把你放在我心里最深处，我想保护你，不让你变坏"));
			list.add(new DShareMode(48, "四十九", "爱是一种体会，即使心碎也会觉得甜蜜"));
			list.add(new DShareMode(49, "五十", "酸酸旳味道，就是幸福旳预告"));
			list.add(new DShareMode(50, "五十一", "那一句我爱你，我会一直默默为你留在心里，只会对你说……"));
			
			list.add(new DShareMode(51, "五十二", "现在，我会慢慢让你将我从你的记忆中删除"));
			list.add(new DShareMode(52, "五十三", "真正爱你的人不会说许多爱你的话，但会做许多爱你的事"));
			list.add(new DShareMode(53, "五十四", "不是你不期待永恒的恋曲，你说最美的爱情叫做回忆"));
			list.add(new DShareMode(54, "五十五", "爱情和赌博一样，红了眼的都拿器官下注"));
			list.add(new DShareMode(55, "五十六", "我只想轻描淡写的写出那句我爱你罢了"));
						

			Random romdom =new Random();
			Set  set=new HashSet();
			
			while(set.size()<=10){
				set.add(list.get(romdom.nextInt(list.size()-1)));
			}
									
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("data", set);
			map.put("total", 10);

			res.put("result", map);
			res.put("message", "查找成功!");
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "查找失败!错误原因：" + e.getMessage());
			return res;
		}
	}

	@RequestMapping(value = "/addAmount", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> addAmount(@RequestParam String userId,
			@RequestParam(defaultValue = "500") Integer num) {

		Map<String, Object> res = new HashMap<String, Object>();
		try {

			if (null == userId || userId.equals("")) {
				res.put("status", 210);
				res.put("message", "参数输入不能为空!");
				return res;
			}

			EUser user = new EUser();
			user.setId(userId);
			user.setElectric(num);
			int count = shareService.addElectric(user);

			if (count == 1) {
				res.put("status", 200);
				res.put("message", "加触电值成功");
				return res;
			} else {
				res.put("status", 211);
				res.put("message", "加触电值失败,请检查参数是否正常");
				return res;
			}

		} catch (Exception e) {
			res.put("status", 210);
			res.put("message", "查找失败!错误原因：" + e.getMessage());
			return res;
		}

	}

	@RequestMapping(value = "/getShareDetail", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getShareDetail(@RequestParam String id, @RequestParam String userId) {

		Map<String, Object> res = new HashMap<String, Object>();

		try {

			if (null == id || id.equals("") || null == userId || userId.equals("")) {
				res.put("status", 210);
				res.put("message", "参数输入不能为空!");
				return res;
			}

			Map<String, Object> map = shareService.get(id);

			EFans fans = new EFans();
			fans.setFansUserId(userId);

			// 判断是否已关注作者
			List<EFans> fansList = (List<EFans>) fansService.list(fans, 1, 20).get("data");

			EShare share = (EShare) map.get("share");
			boolean flag = false;
			for (EFans eFans : fansList) {
				String Startid = eFans.getStarUserId();
				if (Startid.equals(share.getUserId())) {
					flag = true;
					break;
				}
			}

			map.put("isNotice", flag);

			boolean isAct = false;
			List<EShareAct> ActList = (List<EShareAct>) map.get("actList");
			for (EShareAct shareAct : ActList) {
				if (shareAct.getUserId().equalsIgnoreCase(userId)) {
					isAct = true;
					break;
				}
			}
			map.put("isAct", isAct);

			if (null == map) {
				res.put("status", 210);
				res.put("message", "参数错误!");
				return res;
			} else {
				res.put("status", 200);
				res.put("result", map);
				res.put("message", "查找成功!");
				return res;
			}

		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "查找失败!错误原因：" + e.getMessage());
			return res;
		}
	}

	// 拉取点赞的用户列表
	@RequestMapping(value = "/getActUser", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getActUser(@RequestParam String id) {

		Map<String, Object> res = new HashMap<String, Object>();

		try {

			if (null == id || id.equals("")) {
				res.put("status", 210);
				res.put("message", "参数输入不能为空!");
				return res;
			}

			Map<String, Object> map = shareService.getActUser(id);

			List<EShareAct> ActList = (List<EShareAct>) map.get("ActList");

			if (null == map) {
				res.put("status", 210);
				res.put("message", "参数错误!");
				return res;
			} else {
				res.put("status", 200);
				res.put("result", map);
				res.put("message", "查找成功!");
				return res;
			}

		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "查找失败!错误原因：" + e.getMessage());
			return res;
		}

	}
	

	@RequestMapping(value = "/getActMeList", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getActMeList(@RequestParam String userId) {

		Map<String, Object> res = new HashMap<String, Object>();

		try {

			if (null == userId || userId.equals("")) {
				res.put("status", 210);
				res.put("message", "参数输入不能为空!");
				return res;
			}

			List<EShareAct> actList = shareService.getActMeList(userId);

			if (null == actList) {
				res.put("status", 210);
				res.put("message", "参数错误!");
				return res;
			} else {
				res.put("status", 200);
				res.put("result", actList);
				res.put("message", "查找成功!");
				return res;
			}

		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "查找失败!错误原因：" + e.getMessage());
			return res;
		}
		
	}

	private String getTimeInfo(Date date) {

		DateFormat df = new SimpleDateFormat("MM月dd日");
		long d = 24 * 60 * 60; // 天
		long h = 60 * 60; // 小时
		long m = 60;// 分钟
		long diff = (new Date().getTime() - date.getTime()) / 1000; // 得到时间差
																	// 单位是秒

		if (diff < m)
			return "1分钟内";
		if (diff < h)
			return diff / m + "分钟以前";
		if (diff < d)
			return diff / h + "小时以前";

		return df.format(date);

	}

	
}
