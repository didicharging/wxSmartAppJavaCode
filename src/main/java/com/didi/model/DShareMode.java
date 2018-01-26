package com.didi.model;

public class DShareMode {
	private Integer id;
	private String title;
	private String content;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		content = content;
	}

	public DShareMode(Integer id, String title, String content) {
	
		this.id = id;
		this.title = title;
		this.content = content;
	}


}
