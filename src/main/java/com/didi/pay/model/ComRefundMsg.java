package com.didi.pay.model;

public class ComRefundMsg {
	private String mch_appid;
	private String mchid;
	private String nonce_str;
	private String sign;
	
	private String partner_trade_no;  //商户订单号
	private String openid;
	private String check_name; //是否检查用户名
	private String re_user_name;	
	private int amount;
	private String desc;
	private String spbill_create_ip;

	public String getMch_appid() {
		return mch_appid;
	}

	public void setMch_appid(String mch_appid) {
		this.mch_appid = mch_appid;
	}

	public String getMchid() {
		return mchid;
	}

	public void setMchid(String mchid) {
		this.mchid = mchid;
	}

	public String getPartner_trade_no() {
		return partner_trade_no;
	}

	public void setPartner_trade_no(String partner_trade_no) {
		this.partner_trade_no = partner_trade_no;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
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

	public String getCheck_name() {
		return check_name;
	}

	public void setCheck_name(String check_name) {
		this.check_name = check_name;
	}

	public String getRe_user_name() {
		return re_user_name;
	}

	public void setRe_user_name(String re_user_name) {
		this.re_user_name = re_user_name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}

	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}



	public String getXml() {
		StringBuffer result = new StringBuffer();
		result.append("<xml>");
		
		result.append("<mch_appid>" + mch_appid + "</mch_appid>");
		result.append("<mchid>" + mchid + "</mchid>");
		result.append("<nonce_str>" + nonce_str + "</nonce_str>");
		
		result.append("<partner_trade_no>" + partner_trade_no + "</partner_trade_no>");
		result.append("<openid>" + openid + "</openid>");
		result.append("<check_name>" + check_name + "</check_name>");
	
		/*result.append("<re_user_name>" + re_user_name + "</re_user_name>");*/
		result.append("<amount>" + amount + "</amount>");
		result.append("<desc>" + desc + "</desc>");
		
		result.append("<spbill_create_ip>"+spbill_create_ip+"</spbill_create_ip>");
		
		result.append("<sign>"+sign+"</sign>");
		
		result.append("</xml>");
		
		return result.toString();
	}

}
