package com.didi.model;

import java.util.Date;
import java.util.Map;

public class EShareAct {
    private String id;

    private String userId;

    private String shareId;

    private Integer actType;

    private String actContent;

    private Date actDate;
    
    private Integer isRead;
    
    private EUser ActUser;
	
	public EUser getActUser() {
		return ActUser;
	}

	public void setActUser(EUser actUser) {
		ActUser = actUser;
	}

	public Integer getIsRead() {
		return isRead;
	}

	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
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

    public String getShareId() {
        return shareId;
    }

    public void setShareId(String shareId) {
        this.shareId = shareId == null ? null : shareId.trim();
    }

    public Integer getActType() {
        return actType;
    }

    public void setActType(Integer actType) {
        this.actType = actType;
    }

    public String getActContent() {
        return actContent;
    }

    public void setActContent(String actContent) {
        this.actContent = actContent == null ? null : actContent.trim();
    }

    public Date getActDate() {
        return actDate;
    }

    public void setActDate(Date actDate) {
        this.actDate = actDate;
    }
}