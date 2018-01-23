package com.didi.pay.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.didi.pay.model.ComRefundMsg;
import com.didi.pay.model.PayInfo;
import com.didi.pay.model.PayMsg;
import com.didi.pay.model.PayReply;
import com.didi.pay.model.PrepayResultMsg;
import com.didi.pay.model.RefundMsg;

public class WeixinUtil {

	// 获取统一支付接口的签名
	public static String getPaySign(PayMsg msg) {
		StringBuffer ret = new StringBuffer();
		if (msg == null) {
			return null;
		} else {
			ret.append("appid=" + msg.getAppid());
			ret.append("&body=" + msg.getBody());
			ret.append("&mch_id=" + msg.getMch_id());
			ret.append("&nonce_str=" + msg.getNonce_str());
			ret.append("&notify_url=" + msg.getNotify_url());
			ret.append("&openid=" + msg.getOpenid());
			ret.append("&out_trade_no=" + msg.getOut_trade_no());
			ret.append("&spbill_create_ip=" + msg.getSpbill_create_ip());
			ret.append("&total_fee=" + msg.getTotal_fee());
			ret.append("&trade_type=" + msg.getTrade_type());
			ret.append("&key=" + Constant.MCHKEY);
		}
		String s = ret.toString();
		s = CipherUtil.generatePassword(s);
		return s.toUpperCase();
	}

	public static String getPayReplySign(PayReply reply) {
		StringBuffer ret = new StringBuffer();
		if (reply == null) {
			return null;
		} else {
			ret.append("appid=" + reply.getAppid());
			ret.append("&bank_type=" + reply.getBank_type());
			ret.append("&cash_fee=" + reply.getCash_fee());
			ret.append("&fee_type=" + reply.getFee_type());
			ret.append("&is_subscribe=" + reply.getIs_subscribe());
			ret.append("&mch_id=" + reply.getMch_id());
			ret.append("&nonce_str=" + reply.getNonce_str());
			ret.append("&openid=" + reply.getOpenid());
			ret.append("&out_trade_no=" + reply.getOut_trade_no());
			ret.append("&result_code=" + reply.getResult_code());
			ret.append("&return_code=" + reply.getReturn_code());
			ret.append("&time_end=" + reply.getTime_end());
			ret.append("&total_fee=" + reply.getTotal_fee());
			ret.append("&trade_type=" + reply.getTrade_type());
			ret.append("&transaction_id=" + reply.getTransaction_id());
			ret.append("&key=" + Constant.MCHKEY);
		}
		String s = ret.toString();
		s = CipherUtil.generatePassword(s);
		return s.toUpperCase();
	}

	public static String getPayInfoSign(PayInfo payInfo) {
		StringBuffer ret = new StringBuffer();
		if (payInfo == null) {
			return null;
		} else {
			ret.append("appId=" + payInfo.getAppId());
			ret.append("&nonceStr=" + payInfo.getNonceStr());
			ret.append("&package=" + payInfo.getPayPackage());
			ret.append("&signType=" + payInfo.getSignType());
			ret.append("&timeStamp=" + payInfo.getTimeStamp());
			ret.append("&key=" + Constant.MCHKEY);
		}
		String s = ret.toString();
		s = CipherUtil.generatePassword(s);
		return s.toUpperCase();
	}

	public static PayReply getPayReply(HttpServletRequest request)
			throws IOException {
		PayReply reply = new PayReply();
		char[] readerBuffer = new char[request.getContentLength()];
		BufferedReader bufferedReader = request.getReader();
		int portion = bufferedReader.read(readerBuffer);
		int amount = portion;
		while (amount < readerBuffer.length) {
			portion = bufferedReader.read(readerBuffer, amount,
					readerBuffer.length - amount);
			amount = amount + portion;
		}
		StringBuffer stringBuffer = new StringBuffer(
				(int) (readerBuffer.length * 1.5));
		for (int index = 0; index < readerBuffer.length; index++) {
			char c = readerBuffer[index];
			stringBuffer.append(c);
		}
		
		String xml = stringBuffer.toString();
		
		Logger logg = Logger.getLogger("spring");
		System.out.println(xml);
		
		logg.info(xml);
		
		String appid = StringUtils.substringBetween(xml.trim(),
				"<appid><![CDATA[", "]]></appid>");
		if (appid == null) {
			appid = StringUtils.substringBetween(xml.trim(), "<appid>",
					"</appid>");
		}
		String bank_type = StringUtils.substringBetween(xml.trim(),
				"<bank_type><![CDATA[", "]]></bank_type>");
		if (bank_type == null) {
			bank_type = StringUtils.substringBetween(xml.trim(), "<bank_type>",
					"</bank_type>");
		}
		String cash_fee = StringUtils.substringBetween(xml.trim(),
				"<cash_fee><![CDATA[", "]]></cash_fee>");
		if (cash_fee == null) {
			cash_fee = StringUtils.substringBetween(xml.trim(), "<cash_fee>",
					"</cash_fee>");
		}
		String fee_type = StringUtils.substringBetween(xml.trim(),
				"<fee_type><![CDATA[", "]]></fee_type>");
		if (fee_type == null) {
			fee_type = StringUtils.substringBetween(xml.trim(), "<fee_type>",
					"</fee_type>");
		}
		String is_subscribe = StringUtils.substringBetween(xml.trim(),
				"<is_subscribe><![CDATA[", "]]></is_subscribe>");
		if (is_subscribe == null) {
			is_subscribe = StringUtils.substringBetween(xml.trim(),
					"<is_subscribe>", "</is_subscribe>");
		}
		String mch_id = StringUtils.substringBetween(xml.trim(),
				"<mch_id><![CDATA[", "]]></mch_id>");
		if (mch_id == null) {
			mch_id = StringUtils.substringBetween(xml.trim(), "<mch_id>",
					"</mch_id>");
		}
		String nonce_str = StringUtils.substringBetween(xml.trim(),
				"<nonce_str><![CDATA[", "]]></nonce_str>");
		if (nonce_str == null) {
			nonce_str = StringUtils.substringBetween(xml.trim(), "<nonce_str>",
					"</nonce_str>");
		}
		String openid = StringUtils.substringBetween(xml.trim(),
				"<openid><![CDATA[", "]]></openid>");
		if (openid == null) {
			openid = StringUtils.substringBetween(xml.trim(), "<openid>",
					"</openid>");
		}
		String out_trade_no = StringUtils.substringBetween(xml.trim(),
				"<out_trade_no><![CDATA[", "]]></out_trade_no>");
		if (out_trade_no == null) {
			out_trade_no = StringUtils.substringBetween(xml.trim(),
					"<out_trade_no>", "</out_trade_no>");
		}
		String result_code = StringUtils.substringBetween(xml.trim(),
				"<result_code><![CDATA[", "]]></result_code>");
		if (result_code == null) {
			result_code = StringUtils.substringBetween(xml.trim(),
					"<result_code>", "</result_code>");
		}
		String return_code = StringUtils.substringBetween(xml.trim(),
				"<return_code><![CDATA[", "]]></return_code>");
		if (return_code == null) {
			return_code = StringUtils.substringBetween(xml.trim(),
					"<return_code>", "</return_code>");
		}
		String sign = StringUtils.substringBetween(xml.trim(),
				"<sign><![CDATA[", "]]></sign>");
		if (sign == null) {
			sign = StringUtils
					.substringBetween(xml.trim(), "<sign>", "</sign>");
		}
		String time_end = StringUtils.substringBetween(xml.trim(),
				"<time_end><![CDATA[", "]]></time_end>");
		if (time_end == null) {
			time_end = StringUtils.substringBetween(xml.trim(), "<time_end>",
					"</time_end>");
		}
		String total_fee = StringUtils.substringBetween(xml.trim(),
				"<total_fee><![CDATA[", "]]></total_fee>");
		if (total_fee == null) {
			total_fee = StringUtils.substringBetween(xml.trim(), "<total_fee>",
					"</total_fee>");
		}
		String trade_type = StringUtils.substringBetween(xml.trim(),
				"<trade_type><![CDATA[", "]]></trade_type>");
		if (trade_type == null) {
			trade_type = StringUtils.substringBetween(xml.trim(),
					"<trade_type>", "</trade_type>");
		}
		String transaction_id = StringUtils.substringBetween(xml.trim(),
				"<transaction_id><![CDATA[", "]]></transaction_id>");
		if (transaction_id == null) {
			transaction_id = StringUtils.substringBetween(xml.trim(),
					"<transaction_id>", "</transaction_id>");
		}
		reply.setAppid(appid);
		reply.setBank_type(bank_type);
		reply.setFee_type(fee_type);
		reply.setIs_subscribe(is_subscribe);
		reply.setMch_id(mch_id);
		reply.setNonce_str(nonce_str);
		reply.setOpenid(openid);
		reply.setOut_trade_no(out_trade_no);
		reply.setResult_code(result_code);
		reply.setReturn_code(return_code);
		reply.setSign(sign);
		reply.setTime_end(time_end);
		if (cash_fee != null) {
			reply.setCash_fee(Integer.parseInt(cash_fee));
		}
		if (total_fee != null) {
			reply.setTotal_fee(Integer.parseInt(total_fee));
		}
		reply.setTrade_type(trade_type);
		reply.setTransaction_id(transaction_id);
		return reply;
	}

	public static String getRefundSign(RefundMsg msg) {
		StringBuffer ret = new StringBuffer();
		if (msg == null) {
			return null;
		} else {
			ret.append("appid=" + msg.getAppid());
			ret.append("&mch_id=" + msg.getMch_id());
			ret.append("&nonce_str=" + msg.getNonce_str());
			ret.append("&op_user_id=" + msg.getOp_user_id());
			ret.append("&out_refund_no=" + msg.getOut_refund_no());
			ret.append("&refund_fee=" + msg.getRefund_fee());
			ret.append("&refund_fee_type=" + msg.getRefund_fee_type());
			ret.append("&total_fee=" + msg.getTotal_fee());
			ret.append("&transaction_id=" + msg.getTransaction_id());
			ret.append("&key=" + Constant.MCHKEY);
		}
		String s = ret.toString();
		s = CipherUtil.generatePassword(s);
		return s.toUpperCase();
	}
		
	public static String getComRefundSign(ComRefundMsg msg) {
		StringBuffer ret = new StringBuffer();
		if (msg == null) {
			return null;
		} else {
			ret.append("amount="+msg.getAmount());
			ret.append("&check_name=" + msg.getCheck_name());
			ret.append("&desc=" + msg.getDesc());
			
			ret.append("&mch_appid=" + msg.getMch_appid());
			ret.append("&mchid=" + msg.getMchid());
			ret.append("&nonce_str=" + msg.getNonce_str());
			ret.append("&openid=" + msg.getOpenid());
			ret.append("&partner_trade_no=" + msg.getPartner_trade_no());
	
			ret.append("&spbill_create_ip=" + "172.16.1.145");
			
			ret.append("&key=" + Constant.MCHKEY);
		}
		String s = ret.toString();
		System.out.println(s);
		s = CipherUtil.generatePassword(s);
	    return s;	
	}
	
	// 随机生成字符串
	public static String getRandomString(int length) { // length表示生成字符串的长度
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString().toUpperCase();
	}

	public static PrepayResultMsg getPrepayMsg(int cost, String openId,
			String ip, String notify_url, String wallet_log_id) {
		PrepayResultMsg ret = new PrepayResultMsg();
		try {
			PayMsg pay = new PayMsg();
			pay.setAppid(Constant.APPID);
			pay.setBody("付款" + (double) (cost / 100) + "元到嘀嘀充电");
			pay.setMch_id(Constant.MCHID);
			pay.setNonce_str(WeixinUtil.getRandomString(32));
			pay.setNotify_url(notify_url);
			pay.setOpenid(openId);
			pay.setOut_trade_no(wallet_log_id);
			pay.setSpbill_create_ip(ip);
			pay.setTotal_fee(cost);
			pay.setTrade_type("JSAPI");
			String sign = WeixinUtil.getPaySign(pay);
			pay.setSign(sign);
			String payRet = HttpclientUtil.postWithXML(
					Constant.UNIFIED_ORDER_PAY_URL, pay.getXml());
			String return_code = "";
			String return_msg = "";
			String result_code = "";
			String err_code_des = "";
			String prepay_id = "";
			if (payRet != null) {
				return_code = StringUtils.substringBetween(payRet.trim(),
						"<return_code><![CDATA[", "]]></return_code>");
				return_msg = StringUtils.substringBetween(payRet.trim(),
						"<return_msg><![CDATA[", "]]></return_msg>");
				result_code = StringUtils.substringBetween(payRet.trim(),
						"<result_code><![CDATA[", "]]></result_code>");
				err_code_des = StringUtils.substringBetween(payRet.trim(),
						"<err_code_des><![CDATA[", "]]></err_code_des>");
				prepay_id = StringUtils.substringBetween(payRet.trim(),
						"<prepay_id><![CDATA[", "]]></prepay_id>");
				ret.setErr_code_des(err_code_des);
				ret.setPrepay_id(prepay_id);
				ret.setResult_code(result_code);
				ret.setReturn_code(return_code);
				ret.setReturn_msg(return_msg);
				ret.setOut_trade_no(pay.getOut_trade_no());
			}
		} catch (Exception e) {
			e.printStackTrace();
			ret.setErr_code_des(e.toString());
		}
		return ret;
	}
}
