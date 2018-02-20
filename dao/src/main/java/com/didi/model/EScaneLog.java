
package com.didi.model;

import java.util.Date;

public class EScaneLog {
	
	/**
	 * 下面是用户所有的可能操作
	 * 锂电池是 租电 充电 领回设备 报修 续租 换电  充电侠充电
	 * 搭电宝 领回 报修 报废 搭电
	 * 充电宝 领回 报废  
	 * */
	
	//用户租用设备
	public static Integer RENT_DEVICE=1;
	
	//充电侠充电
	public static Integer CHARGE_DEVICE=2;
	
	//设备投诉
	public static Integer COMPLAIN_DEVICE=3;
	
	//设备丢失
	public static Integer LOSE_DEVICE=4;
	
	//购买设备
	public static Integer BUY_DEVICE=5;
	
	//赔偿设备
//	public static Integer COMPENSATE_USER=5;	
	//换电
	public static Integer CHANGE_DEVICE=6;
	//设备报废
	public static Integer DESTROY_DEVICE=7;
	//设备维修
    public static Integer REPAIR_DEVICE=8;
    //设备正常
    public static Integer NORMAL_DEVICE=9;
    //设备充电完成
    public static Integer CHARGING_FINISH=10;
    
    //充电侠扫码领回设备
	public static Integer RECIVE_DEVICE=11;
    
	//汽车搭电
	public static Integer START_SERVICE=12;
	
	//续租	
	public static Integer CONTINUE_RENT=13;
	
	//用户充电
	public static Integer USER_CHARGE=14;
	
	
	
	
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