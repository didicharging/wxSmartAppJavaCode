package com.didi.pay.model;

public class RefundMsg {
	private String appid;
	private String mch_id;
	private String nonce_str;
	private String sign;
	private String transaction_id;
	private String out_refund_no;
	private int total_fee;
	private int refund_fee;
	private String refund_fee_type;
	private String op_user_id;

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

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getOut_refund_no() {
		return out_refund_no;
	}

	public void setOut_refund_no(String out_refund_no) {
		this.out_refund_no = out_refund_no;
	}

	public int getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(int total_fee) {
		this.total_fee = total_fee;
	}

	public int getRefund_fee() {
		return refund_fee;
	}

	public void setRefund_fee(int refund_fee) {
		this.refund_fee = refund_fee;
	}

	public String getRefund_fee_type() {
		return refund_fee_type;
	}

	public void setRefund_fee_type(String refund_fee_type) {
		this.refund_fee_type = refund_fee_type;
	}

	public String getOp_user_id() {
		return op_user_id;
	}

	public void setOp_user_id(String op_user_id) {
		this.op_user_id = op_user_id;
	}

	public String getXml() {
		StringBuffer result = new StringBuffer();
		result.append("<xml>");
		result.append("<appid>" + appid + "</appid>");
		result.append("<mch_id>" + mch_id + "</mch_id>");
		result.append("<nonce_str>" + nonce_str + "</nonce_str>");
		result.append("<sign>" + sign + "</sign>");
		result.append("<transaction_id>" + transaction_id + "</transaction_id>");
		result.append("<out_refund_no>" + out_refund_no + "</out_refund_no>");
		result.append("<total_fee>" + total_fee + "</total_fee>");
		result.append("<refund_fee>" + refund_fee + "</refund_fee>");
		result.append("<refund_fee_type>" + refund_fee_type
				+ "</refund_fee_type>");
		result.append("<op_user_id>" + op_user_id + "</op_user_id>");
		result.append("</xml>");
		return result.toString();
	}

}
