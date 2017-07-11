package com.rev.bean;

public class AdminNotify 
{
	private int id;
	private String content;
	private int active;
	
	public AdminNotify(){}
	
	public AdminNotify(int id, String content, int active) {
		this.id = id;
		this.content = content;
		this.active = active;
	}
	
	public AdminNotify(String content, int active) {
		this.content = content;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "AdminNotify [id=" + id + ", content=" + content + ", active=" + active + "]";
	}
}
