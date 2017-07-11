package com.rev.bean;

public class Post 
{
	private int postId;
	private int threadId;
	private int userId;
	private String content;
	private int active;
	
	public Post(){}
	
	public Post(int postId, int threadId, int userId, String content, int active) {
		super();
		this.postId = postId;
		this.threadId = threadId;
		this.userId = userId;
		this.content = content;
		this.active = active;
	}
	
	public Post(int threadId, int userId, String content, int active) {
		this.threadId = threadId;
		this.userId = userId;
		this.content = content;
		this.active = active;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getThreadId() {
		return threadId;
	}

	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
		return "Post [postId=" + postId + ", threadId=" + threadId + ", userId=" + userId + ", content=" + content
				+ ", active=" + active + "]";
	}
}
