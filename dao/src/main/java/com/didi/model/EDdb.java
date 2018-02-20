package com.didi.model;

import java.util.Date;



public class EDdb {
	
	public static Integer MONEY=1; //
	
	public static Integer CHAREGE=2; //
	
	public static Integer MANAGER=3; //
	public static Integer OWNER=4; //
	public static Integer DD=5;  // 
	
	public static Integer SHARE=6; 
	
	public static Integer SHARE_ACT=7;
	
	public static Integer NEW_USER=8;
	
	public static Integer PAY_USE=9;  //
	
	public static Integer PAY_CHARGE=10; //
	public static Integer MONEY_GIVE=11; //	
		
	public static Integer BUY_DEVICE=12;
	
//	public static Integer START_SERVICE=13;
	
    private String id;

    private String userId;

    private Integer amount;

    private Integer logType;

    private Date createTime;

    private String content;

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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

	@Override
	public String toString() {
		return "EDdb [id=" + id + ", userId=" + userId + ", amount=" + amount + ", logType=" + logType + ", createTime="
				+ createTime + ", content=" + content + "]";
	}
    
}