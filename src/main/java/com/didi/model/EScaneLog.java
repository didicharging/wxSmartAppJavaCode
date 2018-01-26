package com.didi.model;

import java.util.Date;

public class EScaneLog {
	
	public static Integer RECIVE_DEVICE=1;
	
	public static Integer CHARGE_DEVICE=2;
	public static Integer COMPLAIN_DEVICE=3;
	public static Integer LOSE_DEVICE=4;
	public static Integer BUY_DEVICE=5;
	public static Integer COMPENSATE_USER=5;	
	
	public static Integer CHANGE_DEVICE=6;
	
	public static Integer DESTROY_DEVICE=7;
    public static Integer REPAIR_DEVICE=8;
    public static Integer NORMAL_DEVICE=9;
    
    public static Integer CHARGING_FINISH=10;
	
    private String id;

    private String userId;

    private String deviceId;

    private Date startDate;

    private Date endDate;

    private Integer opration;

    private String manager;

    private String companion;

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

    public Integer getOpration() {
        return opration;
    }

    public void setOpration(Integer opration) {
        this.opration = opration;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public String getCompanion() {
        return companion;
    }

    public void setCompanion(String companion) {
        this.companion = companion == null ? null : companion.trim();
    }
}