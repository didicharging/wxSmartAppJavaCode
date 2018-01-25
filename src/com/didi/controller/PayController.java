package com.didi.controller;

import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.didi.model.EDdb;
import com.didi.model.EDevice;
import com.didi.model.EDeviceExample;
import com.didi.model.EDeviceLog;
import com.didi.model.EOrders;
import com.didi.model.EUser;
import com.didi.model.EWallet;
import com.didi.model.EWalletLog;
import com.didi.model.EWalletLogExample;
import com.didi.pay.model.PayInfo;
import com.didi.pay.model.PayReply;
import com.didi.pay.model.PrepayResultMsg;
import com.didi.pay.util.Constant;
import com.didi.pay.util.WeixinUtil;
import com.didi.service.DdbService;
import com.didi.service.DeviceService;
import com.didi.service.FansService;
import com.didi.service.OrdersService;
import com.didi.service.UserService;
import com.didi.service.WalletLogService;
import com.didi.service.WalletService;
import com.didi.unti.TextUtils;

@RestController
@RequestMapping("/resource-service/pay")
public class PayController {

	@Resource
	WalletLogService walletLogService;

	@Resource
	WalletService walletService;

	@Resource
	UserService userService;

	@Resource
	DeviceService deviceService;

	@Resource 
	DdbService ddbService;

	@Resource
	OrdersService orderService;

	// 接受钱包余额充值支付结果通知
//	@RequestMapping(value = "/getDebtReply")
//	@ResponseBody
//	public void getDebtReply(HttpServletRequest request, HttpServletResponse response) {
//
//		try {
//			PayReply reply = WeixinUtil.getPayReply(request);
//			String result_code = reply.getResult_code();
//			String return_code = reply.getReturn_code();
//
//			if (result_code != null && return_code != null && result_code.equalsIgnoreCase("SUCCESS")
//					&& return_code.equalsIgnoreCase("SUCCESS")) {
//
//				if (true) {
//
//					String walletLogId = reply.getOut_trade_no();
//					EWalletLog log = (EWalletLog) walletLogService.get(walletLogId);
//
//					if (log.getTransactionId() == null) {
//
//						log.setTransactionId(reply.getTransaction_id());
//						walletLogService.edit(log);
//
//					}
//					// 推送接收成功消息给微信
//					OutputStream out = response.getOutputStream();
//					String result = "<xml><return_code><![CDATA[SUCCESS]]></return_code>";
//					result += "<return_msg><![CDATA[OK]]></return_msg></xml>";
//
//					out.write(result.getBytes("utf-8"));
//					out.flush();
//					out.close();
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	@RequestMapping(value = "/getRechargeReply")
	@ResponseBody
	public void getRechargeReply(HttpServletRequest request, HttpServletResponse response) {

		try {
			PayReply reply = WeixinUtil.getPayReply(request);
			String result_code = reply.getResult_code();
			String return_code = reply.getReturn_code();

			if (result_code != null && return_code != null && result_code.equalsIgnoreCase("SUCCESS")
					&& return_code.equalsIgnoreCase("SUCCESS")) {

				if (true) {

					String walletLogId = reply.getOut_trade_no();
					EWalletLog log = (EWalletLog) walletLogService.get(walletLogId);

					if (log.getTransactionId() == null) {

						log.setTransactionId(reply.getTransaction_id());
						walletLogService.edit(log);

						EWallet wallet = walletService.getWalletByUser(log.getUserId());

						int addAmount = reply.getCash_fee();

						if (addAmount > 0)
							ddbService.insert(log.getUserId(), addAmount, EDdb.MONEY);

						if (addAmount >= 50000) {
							addAmount += 5000;

							ddbService.insert(log.getUserId(), 5000, EDdb.MONEY_GIVE);

						}

						else if (addAmount >= 100000) {

							addAmount += 20000;

							ddbService.insert(log.getUserId(), 20000, EDdb.MONEY_GIVE);

						}

						wallet.setAmount(wallet.getAmount() + addAmount);

						walletService.edit(wallet);

						// 记录ddb充值日志
						EDdb ddb = new EDdb();
						ddb.setId(TextUtils.getIdByUUID());
						ddb.setAmount(reply.getCash_fee());
						ddb.setCreateTime(new Date());
						ddb.setLogType(EDdb.MONEY);
						ddb.setUserId(log.getUserId());
						ddbService.insert(ddb);

					}
					// 推送接收成功消息给微信
					OutputStream out = response.getOutputStream();
					String result = "<xml><return_code><![CDATA[SUCCESS]]></return_code>";
					result += "<return_msg><![CDATA[OK]]></return_msg></xml>";

					out.write(result.getBytes("utf-8"));
					out.flush();
					out.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/buyDeviceReply")
	@ResponseBody
	public void buyDeviceReply(HttpServletRequest request, HttpServletResponse response) {

		try {
			PayReply reply = WeixinUtil.getPayReply(request);
			String result_code = reply.getResult_code();
			String return_code = reply.getReturn_code();

			if (result_code != null && return_code != null && result_code.equalsIgnoreCase("SUCCESS")
					&& return_code.equalsIgnoreCase("SUCCESS")) {

				String walletLogId = reply.getOut_trade_no();
				EWalletLog log = (EWalletLog) walletLogService.get(walletLogId);

				if (log.getTransactionId() == null) {

					log.setTransactionId(reply.getTransaction_id());
					walletLogService.edit(log);

					EDevice device = deviceService.get(log.getDeviceId());
					device.setOwner(log.getUserId());
					deviceService.edit(device);

					// 推送接收成功消息给微信
					OutputStream out = response.getOutputStream();
					String result = "<xml><return_code><![CDATA[SUCCESS]]></return_code>";
					result += "<return_msg><![CDATA[OK]]></return_msg></xml>";

					out.write(result.getBytes("utf-8"));
					out.flush();
					out.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/getShareReply")
	@ResponseBody
	public void getShareReply(HttpServletRequest request, HttpServletResponse response) {

		try {
			PayReply reply = WeixinUtil.getPayReply(request);
			String result_code = reply.getResult_code();
			String return_code = reply.getReturn_code();

			if (result_code != null && return_code != null && result_code.equalsIgnoreCase("SUCCESS")
					&& return_code.equalsIgnoreCase("SUCCESS")) {

				if (true) {

					String walletLogId = reply.getOut_trade_no();
					EWalletLog log = (EWalletLog) walletLogService.get(walletLogId);

					if (log.getTransactionId() == null) {

						// EWalletLog walletlog=log;

						// 这块写核心逻辑

						EDevice device = deviceService.get(log.getDeviceId());

						EWallet wallet = walletService.getWalletByUser(log.getUserId());

						// 第一步 得出交租金日志
						log.setMoney(device.getShareMoney());
						log.setTransactionId(reply.getTransaction_id());
						walletLogService.edit(log);

						List<EDevice> deviceList = new ArrayList<EDevice>();
						deviceList.add(device);

						EDeviceExample example = new EDeviceExample();
						EDeviceExample.Criteria criteria = example.createCriteria();
						criteria.andUserIdEqualTo(log.getUserId());

						deviceList.addAll((List<EDevice>) deviceService.list(example, 0, 0).get("data"));

						double totalShare = 0;

						for (EDevice eDevice : deviceList) {
							totalShare += eDevice.getShareMoney().doubleValue();
						}

						BigDecimal totalShareMoney = BigDecimal.valueOf(totalShare);

						// 计算用户充值
						int addAmount = reply.getCash_fee() - (totalShareMoney.subtract(wallet.getShareAmount()))
								.multiply(new BigDecimal(100)).intValue();

						// 第二步
						EWalletLog walletlog = log;
						walletlog.setId(TextUtils.getIdByUUID());
						walletlog.setMoney(BigDecimal.valueOf(addAmount / 100.0));
						walletlog.setLogType(EWalletLog.BILL_CHARGE_DDB);
						walletLogService.insert(walletlog);

						System.out.println("addAmount1: " + addAmount);

						if (addAmount > 0)
							ddbService.insert(log.getUserId(), addAmount, EDdb.MONEY);

						if (addAmount >= 100000) {
							addAmount += 20000;
							ddbService.insert(log.getUserId(), 20000, EDdb.MONEY_GIVE);
						} else if (addAmount >= 50000) {
							addAmount += 5000;
							ddbService.insert(log.getUserId(), 5000, EDdb.MONEY_GIVE);
						}

						System.out.println("addAmount2: " + addAmount);

						// 计算押金
						wallet.setShareAmount(totalShareMoney);
						wallet.setAmount(wallet.getAmount() + addAmount);

						walletService.edit(wallet);

					}

					// 推送接收成功消息给微信
					OutputStream out = response.getOutputStream();
					String result = "<xml><return_code><![CDATA[SUCCESS]]></return_code>";
					result += "<return_msg><![CDATA[OK]]></return_msg></xml>";

					out.write(result.getBytes("utf-8"));
					out.flush();
					out.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 充值余额
	@RequestMapping(value = "/recharge", method = RequestMethod.POST)
	public Map<String, Object> recharge(@RequestBody Map<String, Object> param) {
		Map<String, Object> res = new HashMap<String, Object>();
		try {
			Object userId = param.get("userId");

			// 输入的金额
			Object money = param.get("money");
			if (userId == null || userId.toString().equalsIgnoreCase("")) {
				res.put("status", 210);
				res.put("message", "充值人ID不能为空");
				return res;
			}
			if (money == null || money.toString().equalsIgnoreCase("") || Double.parseDouble(money.toString()) <= 0) {
				res.put("status", 210);
				res.put("message", "充值金额必须大于0");
				return res;
			}

			double rechargeMoney = Double.parseDouble(money.toString());

			EUser user = userService.get(userId.toString());

			if (user == null) {
				res.put("status", 210);
				res.put("message", "充值用户不存在");
				return res;
			}

			String openId = user.getWechatId();
			EWalletLog log = new EWalletLog();
			log.setId(TextUtils.getIdByUUID());

			PrepayResultMsg msg = WeixinUtil.getPrepayMsg((int) (rechargeMoney * 100), openId, "127.0.0.1",
					Constant.ROOT_PATH + "pay/getRechargeReply", log.getId());

			log.setLogDate(new Date());
			log.setLogType(0);

			log.setMoney(new BigDecimal(rechargeMoney));

			log.setPrepayId(msg.getPrepay_id());
			log.setUserId(userId.toString());

			if (msg.getPrepay_id() != null) {
				walletLogService.insert(log);

				PayInfo payInfo = new PayInfo();

				payInfo.setAppId(Constant.APPID);
				payInfo.setNonceStr(WeixinUtil.getRandomString(32)); //
				payInfo.setPayPackage("prepay_id=" + msg.getPrepay_id());
				payInfo.setSignType("MD5");
				payInfo.setTimeStamp(String.valueOf(new Date().getTime() / 1000));
				String sign = WeixinUtil.getPayInfoSign(payInfo);
				payInfo.setPaySign(sign);

				res.put("payInfo", payInfo);
			} else {
				res.put("prepayRetMsg", msg);
			}

			return res;
		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "充值失败!错误原因：" + e.getMessage());
			return res;
		}
	}

	// 支付押金
	@RequestMapping(value = "/payShare", method = RequestMethod.GET)
	public Map<String, Object> payShare(@RequestParam(required = true) String userId,
			@RequestParam(required = true) String deviceNo, @RequestParam(required = true) double money) {

		Map<String, Object> res = new HashMap<String, Object>();
		try {

			EUser user = userService.get(userId);

			EDevice device = deviceService.getByDeviceNo(deviceNo);

			if (null == user || null == device) {
				res.put("status", 210);
				res.put("message", "设备或用户错误");
				return res;
			}
			if (money <= 0) {
				res.put("status", 210);
				res.put("message", "金额不能小于0");
				return res;
			}

			String openId = user.getWechatId();
			EWalletLog log = new EWalletLog();

			log.setId(TextUtils.getIdByUUID());

			PrepayResultMsg msg = WeixinUtil.getPrepayMsg((int) (money * 100), openId, "127.0.0.1",
					Constant.ROOT_PATH + "pay/getShareReply", log.getId());

			log.setUserId(userId.toString());
			log.setMoney(BigDecimal.valueOf(money));
			log.setLogDate(new Date());
			log.setLogType(EWalletLog.BILL_CHARGE_SHARE);
			log.setDeviceId(device.getId());

			if (msg.getPrepay_id() != null) {
				log.setPrepayId(msg.getPrepay_id());
				walletLogService.insert(log);

				PayInfo payInfo = new PayInfo();

				payInfo.setAppId(Constant.APPID);
				payInfo.setNonceStr(WeixinUtil.getRandomString(32)); //
				payInfo.setPayPackage("prepay_id=" + msg.getPrepay_id());
				payInfo.setSignType("MD5");
				payInfo.setTimeStamp(String.valueOf(new Date().getTime() / 1000));
				String sign = WeixinUtil.getPayInfoSign(payInfo);
				payInfo.setPaySign(sign);

				res.put("payInfo", payInfo);
				res.put("status", 200);
				res.put("message", "请支付");
			} else {
				res.put("prepayRetMsg", msg);
				res.put("status", 210);
				res.put("message", "请求支付失败");
			}

			return res;
		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "充值失败!错误原因：" + e.getMessage());
			return res;
		}
	}

}
