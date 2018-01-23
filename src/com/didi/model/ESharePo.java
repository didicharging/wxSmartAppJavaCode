package com.didi.model;

import java.util.Date;
import java.util.Map;

public class ESharePo {

	private String id;

	private String userId;

	private String deviceId;

	private String content;

	private Integer imageHeight;

	private String imgUrl;

	private Date shareDate;

	private Integer isDelete;

	private String address;

	private Double longitude;

	private Double latitude;

	private Integer imageWidth;
	
	private String timeInfo;
	
	private EDevice device;

	private Map<String, Object> user;

	private int  readCount;
	

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public EDevice getDevice() {
		return device;
	}

	public void setDevice(EDevice device) {
		this.device = device;
	}

	public Map<String, Object> getUser() {
		return user;
	}

	public void setUser(Map<String, Object> user) {
		this.user = user;
	}

	public String getTimeInfo() {
		return timeInfo;
	}

	public void setTimeInfo(String timeInfo) {
		this.timeInfo = timeInfo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getImageHeight() {
		return imageHeight;
	}

	public void setImageHeight(Integer imageHeight) {
		this.imageHeight = imageHeight;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Date getShareDate() {
		return shareDate;
	}

	public void setShareDate(Date shareDate) {
		this.shareDate = shareDate;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Integer getImageWidth() {
		return imageWidth;
	}

	public void setImageWidth(Integer imageWidth) {
		this.imageWidth = imageWidth;
	}

	public ESharePo(EShare share) {
		this.id = share.getId();
		this.userId = share.getUserId();
		this.deviceId = share.getDeviceId();
		this.content = share.getContent();
		this.imgUrl = share.getImgUrl();
		this.shareDate = share.getShareDate();
		this.isDelete = share.getIsDelete();
		this.address = share.getAddress();
		this.longitude = share.getLongitude();
		this.latitude = share.getLatitude();
		this.imageHeight = share.getImageHeight();
		this.imageWidth = share.getImageWidth();
	    this.user=share.getUser();
	    this.device=share.getDevice();
	}

}