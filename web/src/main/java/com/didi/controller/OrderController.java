package com.didi.controller;

import java.util.Calendar;
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

import com.didi.model.EDevice;
import com.didi.model.EOrders;
import com.didi.model.EOrdersExample;
import com.didi.model.EUser;
import com.didi.model.EWallet;
import com.didi.pay.model.PayInfo;
import com.didi.service.DeviceService;
import com.didi.service.OrdersService;
import com.didi.service.UserService;
import com.didi.service.WalletService;

@Controller
@RequestMapping("/resource-service/pay")
public class OrderController {

	@Resource
	OrdersService orderService;

	@Resource
	DeviceService deviceService;

	@Resource
	WalletService walletService;

	@Resource
	UserService userService;

	/**
	 * 支付欠款用嘀嘀币支付， 三种返回状态
	 * 
	 * 200正常返回 210状态异常 211余额不足跳支付页面
	 * 
	 */
	@RequestMapping(value = "/payDebt", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> payDebt(@RequestParam(required = true) String orderId) {
		Map<String, Object> res = new HashMap<String, Object>();
		PayInfo payInfo = null;
		try {

			EOrders order = orderService.get(orderId);
			// 第一步 参数校验

			// 正常结束 和没到期订单不存在欠费
			if (order.getEndDate().getTime() > new Date().getTime() || order.getState() == EOrders.END) {
				res.put("message", "此订单不存在欠费");
				res.put("status", 210);
			}

			// 已过期但是没归还的设备不允许交罚金
			if (order.getEndDate().getTime() > new Date().getTime() && order.getState() != EOrders.PASS) {
				res.put("message", "请先归还设备或续租");
				res.put("status", 210);
			}

			// 第二步 计算金额

			long nd = 1000 * 24 * 60 * 60;
			long nh = 1000 * 60 * 60;
			long nm = 1000 * 60;

			// 计算超期时间
			long diff = order.getLastBackTime().getTime() - order.getEndDate().getTime();
			long hour = diff % nh > 0 ? (diff / nh) + 1 : (diff % nh); // 计算小时数、
			long day = (diff % nd) > 0 ? (diff / nd) + 1 : (diff / nd); // 计算天数

			double month = 0;
			if (day % 30 == 0)
				month = day / 30;
			if (day % 30 > 0 && day % 30 <= 15)
				month = day / 30 + 0.5;
			if (day % 30 > 15)
				month = day / 30 + 1;

			int coast = 0;

			if (order.getRentalType() == order.RENTAL_BY_HOUR)
				coast = (int) (order.getRental() * hour);
			if (order.getRentalType() == order.RENTAL_BY_DAY)
				coast = (int) (order.getRental() * day);
			if (order.getRentalType() == EDevice.RENTAL_BY_MONTH)
				coast = (int) (order.getRental() * month);

			EWallet wallet = walletService.getWalletByUser(order.getUserId());

			if (wallet.getAmount() >= coast) {
				// 余额足够直接扣款
				wallet.setAmount(wallet.getAmount() - coast);
				walletService.edit(wallet);
				res.put("message", "支付完成");
				res.put("status", 200);
				return res;
			} else {

				res.put("message", "余额不足请充值后重试");
				res.put("status", 210);
				return res;
			}

		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "领取失败!原因：" + e.getMessage());
			return res;
		}

	}

	/**
	 * 续租订单
	 */
	@RequestMapping(value = "/continueOrder", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> continueOrder(String orderId, int length) {

		Map<String, Object> res = new HashMap<String, Object>();

		try {
			EOrders order = orderService.get(orderId);

			if (order.getState() == EOrders.END) {
				res.put("message", "订单已过期");
				res.put("status", 210);
				return res;
			}

			int coast = 0;

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(order.getEndDate());
			Date endTime = null;

			if (order.getRentalType() == order.RENTAL_BY_HOUR) {

				coast = (int) (order.getRental() * length);
				calendar.add(Calendar.HOUR, length);
				endTime = calendar.getTime();

			}

			if (order.getRentalType() == order.RENTAL_BY_DAY) {

				coast = (int) (order.getRental() * length);
				calendar.add(Calendar.DATE, length);
				endTime = calendar.getTime();

			}

			if (order.getRentalType() == EDevice.RENTAL_BY_MONTH) {

				coast = (int) (order.getRental() * length);
				calendar.add(Calendar.MONTH, length);
				endTime = calendar.getTime();
			}

			EWallet wallet = walletService.getWalletByUser(order.getUserId());

			if (wallet.getAmount() >= coast) {
				// 余额足够直接扣款
				wallet.setAmount(wallet.getAmount() - coast);
				walletService.edit(wallet);

				order.setEndDate(endTime);
				if (endTime.getTime() > new Date().getTime()) {
					order.setState(EOrders.NORMAL);
				}
				orderService.edit(order);

				res.put("message", "续租成功");
				res.put("status", 200);
				return res;
			} else {

				res.put("message", "余额不足请充值后重试");
				res.put("status", 211);
				return res;
			}

		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "领取失败!原因：" + e.getMessage());
			return res;
		}

	}

	@RequestMapping(value = "/getMyOrders", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getMyOrders(String userId) {

		Map<String, Object> res = new HashMap<String, Object>();
		
		try {
			
			EOrdersExample example=new EOrdersExample();
			EOrdersExample.Criteria criteria=example.createCriteria();
			criteria.andUserIdEqualTo(userId);
			example.setOrderByClause("end_date DESC;");
			List<EOrders> list=(List<EOrders>) orderService.list(example, 0, 0).get("data");
			
			res.put("list", list);
			res.put("status", 200);
			res.put("message", "查找成功了");
			return res;

		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "领取失败!原因：" + e.getMessage());
			return res;

		}

	}
	
	
	
	
	// 获取
	@RequestMapping(value = "/getDayOrder", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getDayOrder() {

		Map<String, Object> res = new HashMap<String, Object>();

		try {
			List<Map<String, Object>> list = orderService.getDayOrder();

			res.put("list", list);
			res.put("status", 200);
			res.put("message", "查找成功了");
			return res;

		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "领取失败!原因：" + e.getMessage());
			return res;

		}

	}

	@RequestMapping(value = "/getWeekOrder", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getWeekOrder() {

		Map<String, Object> res = new HashMap<String, Object>();

		try {
			List<Map<String, Object>> list = orderService.getWeekOrder();

			res.put("list", list);
			res.put("status", 200);
			res.put("message", "查找成功了");
			return res;

		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "领取失败!原因：" + e.getMessage());
			return res;

		}

	}

	@RequestMapping(value = "/getMonthOrder", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getMonthOrder() {

		Map<String, Object> res = new HashMap<String, Object>();
		try {
			List<Map<String, Object>> list = orderService.getMonthOrder();

			res.put("list", list);
			res.put("status", 200);
			res.put("message", "查找成功了");
			return res;

		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "领取失败!原因：" + e.getMessage());
			return res;

		}
	}

	@RequestMapping(value = "/buyDevice", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> buyDevice(@RequestParam(required = true) String orderId) {

		Map<String, Object> res = new HashMap<String, Object>();
		EOrders order = orderService.get(orderId);
		EUser user = userService.get(order.getUserId());
		EWallet wallet = walletService.get(user.getWalletId());

		if (order.getDeviceId() == null || order.getDeviceId().equals("") || order.getState() == EOrders.END) {
			res.put("message", "参数错误");
			res.put("status", 210);
			return res;
		}

		EDevice device = deviceService.get(order.getDeviceId());

		// 第一步 扣款
		wallet.setShareAmount(wallet.getShareAmount().subtract(order.getShareAmount()));
		walletService.edit(wallet);

		// 第二步 设备归你了
		device.setOwner(order.getDeviceId());
		deviceService.edit(device);

		// 第三步 结束订单
		order.setState(EOrders.END);
		orderService.edit(order);
		return res;
	}

}
