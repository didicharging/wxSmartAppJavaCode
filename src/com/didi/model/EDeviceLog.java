package com.didi.model;

import java.util.Date;

public class EDeviceLog {
	
	public static Integer RECIVE_DEVICE=1;
	public static Integer CHARGE_DEVICE=2;
	public static Integer COMPLAIN_DEVICE=3;
	public static Integer LOSE_DEVICE=4;
	public static Integer BUY_DEVICE=5;
	public static Integer COMPENSATE_USER=5;
	
	public static Integer CHANGE_DEVICE=6;
	
	public static Integer DESTROY_DEVICE=7;
	

	
	
	public static  long nd = 1000 * 24 * 60 * 60; // 一天
	public static long nh = 1000 * 60 * 60; // 一小时
	public static long nm = 1000 * 60; // 一分钟
	public static long mm = nd  * 30; // 一个月
	
		
    private String id;

    private String userId;

    private String deviceId;

    private Date inDate;

    private Date outDate;

    private Integer totalFee;

    private Integer shareFee;

    private Integer walletFee;

    private String walletLogId;

    private Integer opration;

    private Integer ispay;
    
    private EDevice device;
    
    
    

    public EDevice getDevice() {
		return device;
	}

	public void setDevice(EDevice device) {
		this.device = device;
	}

	@Override
	public String toString() {
		return "EDeviceLog [id=" + id + ", userId=" + userId + ", deviceId=" + deviceId + ", inDate=" + inDate
				+ ", outDate=" + outDate + ", totalFee=" + totalFee + ", shareFee=" + shareFee + ", walletFee="
				+ walletFee + ", walletLogId=" + walletLogId + ", opration=" + opration + ", ispay=" + ispay + "]";
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public Integer getShareFee() {
        return shareFee;
    }

    public void setShareFee(Integer shareFee) {
        this.shareFee = shareFee;
    }

    public Integer getWalletFee() {
        return walletFee;
    }

    public void setWalletFee(Integer walletFee) {
        this.walletFee = walletFee;
    }

    public String getWalletLogId() {
        return walletLogId;
    }

    public void setWalletLogId(String walletLogId) {
        this.walletLogId = walletLogId == null ? null : walletLogId.trim();
    }

    public Integer getOpration() {
        return opration;
    }

    public void setOpration(Integer opration) {
        this.opration = opration;
    }

    public Integer getIspay() {
        return ispay;
    }

    public void setIspay(Integer ispay) {
        this.ispay = ispay;
    }
}