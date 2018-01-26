package com.didi.model;

import java.math.BigDecimal;
import java.util.Date;

public class EWalletLog {
	

	//定单类型共有多少种 1、充值    2、付押金  3、退租金  4、交欠款  5、退余额
	
	public static final int BILL_CHARGE_DDB= 0;
	
	public static final int BILL_REFUND_SHARE= 2;
	public static final int BILL_CHARGE_SHARE= 4;
	public static final int BILL_REFUND_DDB= 3;
	public static final int BILL_DEBT= 8;

	public static final int	BUY_DEVICE=9;
	
    private String id;

    private String userId;

    private BigDecimal money;

    private Integer logType;

    private Date logDate;

    private String prepayId;

    private String transactionId;

    private String deviceId;

    private String manager;

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

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId == null ? null : prepayId.trim();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId == null ? null : transactionId.trim();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }
}