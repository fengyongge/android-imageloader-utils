package com.fengyongge.friendscircle.bean;

import java.io.Serializable;

public class Share_info implements Serializable {

	private String logo;
	private String title;
	private String content;
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
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
		this.content = content;
	}
}
