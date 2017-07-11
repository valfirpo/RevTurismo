package com.rev.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "RT_POSTS")
public class Post 
{
	@Id
	@Column(name = "P_ID")
	@SequenceGenerator(name = "POSTS_P_ID_SEQ", sequenceName = "POSTS_P_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POSTS_P_ID_SEQ")
	private int postId;
	
	@Column(name = "T_ID")
	private int threadId;
	
	@Column(name = "U_ID")
	private int userId;
	
	@Column(name = "P_CONTENT")
	private String content;
	
	@Column(name = "P_ACTIVE")
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
