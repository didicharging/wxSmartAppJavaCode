package com.didi.model;
import java.util.Date;
import java.util.Map;

public class EFans {
	private String id;

	private String fansUserId;

	private String starUserId;

	private Map<String, Object> fansUser;

	private Map<String, Object> starUser;

	private Date fansDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getFansUserId() {
		return fansUserId;
	}

	public void setFansUserId(String fansUserId) {
		this.fansUserId = fansUserId == null ? null : fansUserId.trim();
	}

	public String getStarUserId() {
		return starUserId;
	}

	public void setStarUserId(String starUserId) {
		this.starUserId = starUserId == null ? null : starUserId.trim();
	}

	public Date getFansDate() {
		return fansDate;
	}

	public void setFansDate(Date fansDate) {
		this.fansDate = fansDate;
	}

	public Map<String, Object> getFansUser() {
		return fansUser;
	}

	public void setFansUser(Map<String, Object> fansUser) {
		this.fansUser = fansUser;
	}

	public Map<String, Object> getStarUser() {
		return starUser;
	}

	public void setStarUser(Map<String, Object> starUser) {
		this.starUser = starUser;
	}

}