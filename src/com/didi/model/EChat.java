package com.didi.model;

import java.util.Date;
import java.util.Map;

public class EChat {
	
    private String id;

    private String fromUser;

    private String toUser;

    private String content;

    private Date chatDate;

    private Integer isDelete;
    
    private Integer isRead;
    
    private int isSend;
    
    private Map<String, Object> formUserInfo;
    private Map<String, Object> toUserInfo;

    public Map<String, Object> getFormUserInfo() {
		return formUserInfo;
	}

	public void setFormUserInfo(Map<String, Object> formUserInfo) {
		this.formUserInfo = formUserInfo;
	}

	public Map<String, Object> getToUserInfo() {
		return toUserInfo;
	}

	public void setToUserInfo(Map<String, Object> toUserInfo) {
		this.toUserInfo = toUserInfo;
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

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser == null ? null : fromUser.trim();
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser == null ? null : toUser.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getChatDate() {
        return chatDate;
    }

    public void setChatDate(Date chatDate) {
        this.chatDate = chatDate;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}