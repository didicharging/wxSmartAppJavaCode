package com.didi.model;

import java.math.BigDecimal;
import java.util.Date;

public class EOrders {
	
	public static final Integer NORMAL=1;
	public static final Integer END=2;
	public static final Integer PASS=3;
	
	
	public static Integer RENTAL_BY_HOUR=1;
	public static Integer RENTAL_BY_DAY=2;
	public static Integer RENTAL_BY_MONTH=3;
			
    private String id;

    private Date startDate;

    private Date endDate;

    private String userId;

    private String deviceName;

    private Date createTime;

    private String deviceId;

    private Integer state;

    private String manager;

    private BigDecimal shareAmount;

    private Date lastBackTime;

    private Integer rental;

    private Integer rentalType;

    private String owner;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public BigDecimal getShareAmount() {
        return shareAmount;
    }

    public void setShareAmount(BigDecimal shareAmount) {
        this.shareAmount = shareAmount;
    }

    public Date getLastBackTime() {
        return lastBackTime;
    }

    public void setLastBackTime(Date lastBackTime) {
        this.lastBackTime = lastBackTime;
    }

    public Integer getRental() {
        return rental;
    }

    public void setRental(Integer rental) {
        this.rental = rental;
    }

    public Integer getRentalType() {
        return rentalType;
    }

    public void setRentalType(Integer rentalType) {
        this.rentalType = rentalType;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }
}