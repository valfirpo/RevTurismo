package com.rev.bean;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "RT_POSTS")
public class Post implements Comparable
{
	@Column(name = "P_CONTENT")
	private String content;
	@Id
	@Column(name = "P_ID")
	@SequenceGenerator(name = "POSTS_P_ID_SEQ", sequenceName = "POSTS_P_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POSTS_P_ID_SEQ")
	private int postId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="U_ID")
	private User author;
	
	@Column(name="P_TIMESTAMP")
	private Date time;
	
	
	
	@Column(name = "P_ACTIVE")
	private int active;
	
	//non hibernate field
	private int tid;
	
	public Post(){}
	
	public Post( User author, String content, int active) {
		super();
		this.author = author;
		this.content = content;
		this.active = active;
	}

	public Post(int postId, User author, String content, int active) {
		super();
		this.postId = postId;
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

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId +  ", author=" + author + ", content=" + content
				+ ", active=" + active + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + active;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + postId;
		result = prime * result + tid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (active != other.active)
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (postId != other.postId)
			return false;
		if (tid != other.tid)
			return false;
		return true;
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		Post other = (Post) arg0;
		return time.compareTo(other.time);
	}
}
