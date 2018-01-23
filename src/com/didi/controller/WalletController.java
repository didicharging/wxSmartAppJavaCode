package com.didi.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.didi.model.EDevice;
import com.didi.model.EUser;
import com.didi.model.EWallet;
import com.didi.model.EWalletLog;
import com.didi.model.EWalletLogExample;
import com.didi.pay.model.ComRefundMsg;
import com.didi.pay.util.Constant;
import com.didi.pay.util.HttpclientUtil;
import com.didi.pay.util.WeixinUtil;
import com.didi.service.DeviceService;
import com.didi.service.FansService;
import com.didi.service.OrdersService;
import com.didi.service.UserService;
import com.didi.service.WalletLogService;
import com.didi.service.WalletService;
import com.didi.unti.TextUtils;

@RestController
@RequestMapping("/resource-service/wallet")
public class WalletController {
	@Resource
	WalletService walletService;

	@Resource
	WalletLogService walletLogService;

	@Resource
	DeviceService deviceService;
		
	@Resource
	FansService fansService;

	@Resource
	UserService userService;
	
	@Resource
	OrdersService orderService;
	
	// 获取用户钱包信息
	// @SuppressWarnings("unchecked")
	@RequestMapping(value = "/getWalletInfoByUserId", method = RequestMethod.GET)
	public Map<String, Object> getWalletInfoByUserId(@RequestParam(required = true) String userId) {
		Map<String, Object> res = new HashMap<String, Object>();

		try {
			
			EUser user=userService.get(userId);
			if(null==user){
				res.put("status", 200);
				res.put("message", "参数错误");
				return res;
			}
						
			EWallet wallet =walletService.getWalletByUser(userId);
						
			if (wallet == null) {
				wallet = new EWallet();
				wallet.setAmount(500);
				wallet.setId(TextUtils.getIdByUUID());
				wallet.setShareAmount(new BigDecimal(0));
				wallet.setUserId(userId);
				wallet.setRole(EWallet.NORMAL);
				walletService.insert(wallet);
			}
			
			System.out.println("wallet: " + wallet);

			Map<String, Object> walletInfo = new HashMap<String, Object>();

			List<EDevice> myDeviceList = (List<EDevice>) deviceService.MydeviceList(userId, 0, 0).get("data");

			double totalShareMoney = 0;

			for (EDevice eDevice : myDeviceList) {
				totalShareMoney += eDevice.getShareMoney().doubleValue();
			}

			System.out.println("totalShareMoney: " + totalShareMoney);
			System.out.println("getShareAmount: " + wallet.getShareAmount().doubleValue());

			String stateName="";
			if(user.getRole()==1) stateName="普通用户";
			if(user.getRole()==98) stateName="集团用户";			
			if(user.getRole()==99) stateName="充电侠";
			if(user.getRole()==97) stateName="超级管理员";	
			if(user.getRole()==96) stateName="集团管理员";
					
			walletInfo.put("stateName", stateName);			
			walletInfo.put("walletId", wallet.getId());
			walletInfo.put("userId", wallet.getUserId());
			walletInfo.put("amount", wallet.getAmount());
			walletInfo.put("shareAmount", wallet.getShareAmount().doubleValue());
			walletInfo.put("canReturnShare",wallet.getShareAmount().doubleValue() - totalShareMoney );
			walletInfo.put("electric", user.getElectric());
            
			res.put("wallet", walletInfo);
		    res.put("deviceCount",null==myDeviceList?0:myDeviceList.size());			
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

	// 退共享金
	@RequestMapping(value = "/refundShareMoney", method = RequestMethod.GET)
	public Map<String, Object> RefundShareMoney(@RequestParam(required = true) String userId,
			@RequestParam(required=true) double amount) {

		Logger logg = Logger.getLogger("spring");

		Map<String, Object> res = new HashMap<String, Object>();
		try {
			// 检查参数合法性
			if (userId == null || userId.equals("")) {
				res.put("status", 210);
				res.put("message", "参数不能为空!");
				return res;
			}
	
			EWallet wallet=walletService.getWalletByUser(userId);
			
			if (null != wallet.getRole() && (wallet.getRole() == EUser.MANAGER)) {
				res.put("status", 210);
				res.put("message", "充电侠禁止退押金");
				return res;			
			}
			
			if (null != wallet.getRole() && (wallet.getRole() == EWallet.CORPORATE)) {
				res.put("status", 210);
				res.put("message", "集团用户禁止个人退押金");
				return res;			
			}			

			// 检查是否有未支付订单
			EWalletLogExample example=new EWalletLogExample();
			EWalletLogExample.Criteria criteria=example.createCriteria();
			criteria.andUserIdEqualTo(userId);
			criteria.andLogTypeEqualTo(EWalletLog.BILL_DEBT);
			criteria.andTransactionIdIsNull();
			            
			Map<String, Object> map=walletLogService.list(example, 0, 0);
			
			if((int)map.get("total")!=0){
				List<EWalletLog> list=(List<EWalletLog>) map.get("data");
				
				double total=0;
				for (EWalletLog eWalletLog : list) {
	
					total+=eWalletLog.getMoney().doubleValue();
			        
				}
				res.put("message","由于您上次未及时归还设备，欠费"+total+"元，请支付后重试");
				res.put("money", total);
				res.put("status", 211);
				return res;
				
			}
			
			
			//Map<String, Object> user = fansService.selectUserById(userId.toString());
			EUser user=userService.get(userId);
			
			if (user == null) {
				res.put("status", 210);
				res.put("message", "用户不存在");
				return res;
			}
	
			String openId = user.getWechatId();

			// 计算可退共享金
			List<EDevice> myDeviceList = (List<EDevice>) deviceService.MydeviceList(userId, 0, 0).get("data");

			// 总共享金
			double shareMoney = 0;
			for (EDevice eDevice : myDeviceList) {

				shareMoney += eDevice.getShareMoney().doubleValue();

			}

			System.out.println("不可退总额" + shareMoney);

			if (wallet.getShareAmount().compareTo(new BigDecimal(shareMoney)) == -1) {
				res.put("status", 210);
				res.put("message", "可退共享金余额不足，无法退款!");
				return res;
			}

			logg.info("余额充足可以退款: " + userId);

			// 可退余额
			BigDecimal money = new BigDecimal(wallet.getShareAmount().doubleValue() - shareMoney);

			System.out.println("可退： " + money);

			// 开始退款代码

			String Partner_trade_no = TextUtils.getIdByUUID();
			ComRefundMsg msg = new ComRefundMsg();

			msg.setMch_appid(Constant.APPID);

			msg.setMchid(Constant.MCHID);
			msg.setNonce_str(WeixinUtil.getRandomString(32).toLowerCase());
			msg.setOpenid(openId);
			msg.setPartner_trade_no(Partner_trade_no);

			msg.setAmount(money.multiply(new BigDecimal(100)).intValue());

			msg.setDesc("returnShareMoney");
			msg.setCheck_name("NO_CHECK");
			msg.setSpbill_create_ip("172.16.1.145");
			String sign = WeixinUtil.getComRefundSign(msg);
			msg.setSign(sign);

			String refundRet = HttpclientUtil.postWithXML(Constant.COM_REFUND_URL, msg.getXml());

			System.out.println(msg.getXml());

			String refundReturnCode = StringUtils.substringBetween(refundRet.trim(), "<return_code><![CDATA[",
					"]]></return_code>");
			String refundResultCode = StringUtils.substringBetween(refundRet.trim(), "<result_code><![CDATA[",
					"]]></result_code>");

			String err_code = StringUtils.substringBetween(refundRet.trim(), "<err_code><![CDATA[", "]]></err_code>");

			String return_msg = StringUtils.substringBetween(refundRet.trim(), "<return_msg><![CDATA[",
					"]]></return_msg>");

			logg.info("refundReturnCode: " + refundReturnCode);
			logg.info("refundResultCode: " + refundResultCode);
			logg.info("err_code: " + err_code);
			logg.info("return_msg: " + return_msg);

			EWalletLog  log = new EWalletLog();
			log.setId(Partner_trade_no);
			log.setLogDate(new Date());
			log.setLogType(2);
			log.setLogType(EWalletLog.BILL_REFUND_SHARE);
			
			log.setMoney(money);
			
			log.setUserId(userId.toString());

			walletLogService.insert(log);
			// 写日志
			if (refundResultCode != null && refundResultCode.equalsIgnoreCase("SUCCESS") && refundReturnCode != null
					&& refundReturnCode.equalsIgnoreCase("SUCCESS")) {

				wallet.setShareAmount(new BigDecimal(shareMoney));
				walletService.edit(wallet);
				log.setTransactionId("ok");
				walletLogService.edit(log);
				
               //结束所有未用订单				
				orderService.endOrders(userId);
				
				res.put("status", 200);
				res.put("message", "共享金退款成功!");
				return res;
			} else {
				res.put("status", 210);
				res.put("message", "退款操作异常！");
				res.put("refundReply", refundRet);
				return res;
			}

		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "共享金退款失败!错误原因：" + e.getMessage());
			return res;
		}
	}
	
	
	@RequestMapping(value = "/getWalletLogByUserId", method = RequestMethod.GET)
	public Map<String, Object> getWalletLogByUserId(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int perPage, @RequestParam(required = true) String userId) {

		Map<String, Object> res = new HashMap<String, Object>();

		try {
			EWalletLog log = new EWalletLog();
			log.setUserId(userId);

			EWalletLogExample example=new EWalletLogExample();
			EWalletLogExample.Criteria criteria=example.createCriteria();
			criteria.andUserIdEqualTo(userId);

			Map<String, Object> temp = walletLogService.list(example, page, perPage);

			List<EWalletLog> listt = (List<EWalletLog>) temp.get("data");

			List<EWalletLog> list = new ArrayList<EWalletLog>();
			for (EWalletLog eWalletLog : listt) {
				if (eWalletLog.getTransactionId() != null)
					list.add(eWalletLog);
			}
			temp.put("data", list);
			res.put("result", temp);
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

	@RequestMapping(value = "/transfer", method = RequestMethod.GET)
	public Map<String, Object> transfer(@RequestParam(required = true) String fromUserId,
			@RequestParam(required = true) String toUserId, @RequestParam(required = true) int amount) {
		Map<String, Object> res = new HashMap<String, Object>();

		try {

			walletService.transfer(fromUserId, toUserId, amount);

			res.put("status", 200);
			res.put("message", "打赏成功!");
			return res;
			
		} catch (Exception e) {
			e.printStackTrace();
			res.put("status", 210);
			res.put("message", "打赏失败!错误原因：" + e.getMessage());
			return res;
		}
	}
	
	
	
	
     
	
	

}
