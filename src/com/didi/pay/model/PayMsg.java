package com.didi.pay.model;

public class PayMsg {
	private String appid;
	private String mch_id;
	private String nonce_str;
	private String sign;
	private String body;
	private String out_trade_no;
	private int total_fee;
	private String spbill_create_ip;
	private String notify_url;
	private String trade_type;
	private String openid;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public int getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(int total_fee) {
		this.total_fee = total_fee;
	}

	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}

	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getXml() {
		StringBuffer result = new StringBuffer();
		result.append("<xml>");
		result.append("<appid><![CDATA[" + appid + "]]></appid>");
		result.append("<mch_id><![CDATA[" + mch_id + "]]></mch_id>");
		result.append("<nonce_str><![CDATA[" + nonce_str + "]]></nonce_str>");
		result.append("<sign><![CDATA[" + sign + "]]></sign>");
		result.append("<body><![CDATA[" + body + "]]></body>");
		result.append("<out_trade_no><![CDATA[" + out_trade_no
				+ "]]></out_trade_no>");
		result.append("<total_fee><![CDATA[" + total_fee + "]]></total_fee>");
		result.append("<spbill_create_ip><![CDATA[" + spbill_create_ip
				+ "]]></spbill_create_ip>");
		result.append("<notify_url><![CDATA[" + notify_url + "]]></notify_url>");
		result.append("<trade_type><![CDATA[" + trade_type + "]]></trade_type>");
		result.append("<openid><![CDATA[" + openid + "]]></openid>");
		result.append("</xml>");
		return result.toString();
	}

}
