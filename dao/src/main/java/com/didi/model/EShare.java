package com.didi.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class EShare {
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
	
	private Integer count;
	  
	  
	
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getImageWidth() {
		return imageWidth;
	}

	public void setImageWidth(Integer imageWidth) {
		this.imageWidth = imageWidth;
	}

	public Integer getImageHeight() {
		return imageHeight;
	}
   
	public void setImageHeight(Integer imageHeight) {
		this.imageHeight = imageHeight;
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

	private EDevice device;

	private Map<String, Object> user;

	public Map<String, Object> getUser() {
		return user;
	}

	public void setUser(Map<String, Object> user) {
		this.user = user;
	}

	public EDevice getDevice() {
		return device;
	}

	public void setDevice(EDevice device) {
		this.device = device;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl == null ? null : imgUrl.trim();
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
	
	
}