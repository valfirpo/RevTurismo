package com.rev.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne
	@JoinColumn(name="T_ID")
	private Thread thread;

	
	@ManyToOne
	@JoinColumn(name="U_ID")
	private User author;
	
	@Column(name = "P_CONTENT")
	private String content;
	
	@Column(name = "P_ACTIVE")
	private int active;
	
	public Post(){}
	
	public Post(Thread thread, User author, String content, int active) {
		super();
		this.thread = thread;
		this.author = author;
		this.content = content;
		this.active = active;
	}

	public Post(int postId, Thread thread, User author, String content, int active) {
		super();
		this.postId = postId;
		this.thread = thread;
		this.author = author;
		this.content = content;
		this.active = active;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
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

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", thread=" + thread + ", author=" + author + ", content=" + content
				+ ", active=" + active + "]";
	}
}
