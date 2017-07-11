package com.rev.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "RT_ADMIN_NOTIFY")
public class AdminNotify 
{
	@Id
	@Column(name = "AN_ID")
	@SequenceGenerator(name = "ADMIN_NOTIFY_AN_ID_SEQ", sequenceName = "ADMIN_NOTIFY_AN_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADMIN_NOTIFY_AN_ID_SEQ")
	private int id;
	@Column(name = "AN_CONTENT")
	private String content;
	@Column(name = "AN_ACTIVE")
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
