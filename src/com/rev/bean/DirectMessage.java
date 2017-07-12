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
@Table(name = "RT_DM")
public class DirectMessage 
{
	@Id
	@Column(name = "DM_ID")
	@SequenceGenerator(name = "DM_ID_SEQ", sequenceName = "DM_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DM_ID_SEQ")
	private int id;
	@Column(name = "U_ID_AUTHOR")	
	private int idAuthor;
	@ManyToOne
	@JoinColumn(name="U_ID_AUTHOR")
	private User author;
	@Column(name = "U_ID_RECEIVER")
	private int idReceiver;
	@ManyToOne
	@JoinColumn(name="U_ID_RECEIVER")
	private User receiver;
	@Column(name = "DM_CONTENT")
	private String content;
	@Column(name = "DM_ACTIVE")
	private int active;
	
	public DirectMessage(){}
	
	public DirectMessage(int id, int idAuthor, int idReceiver, String content, int active) 
	{
		this.id = id;
		this.idAuthor = idAuthor;
		this.idReceiver = idReceiver;
		this.content = content;
		this.active = active;
	}
	
	public DirectMessage(int idAuthor, int idReceiver, String content, int active) 
	{
		this.idAuthor = idAuthor;
		this.idReceiver = idReceiver;
		this.content = content;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdAuthor() {
		return idAuthor;
	}

	public void setIdAuthor(int idAuthor) {
		this.idAuthor = idAuthor;
	}

	public int getIdReceiver() {
		return idReceiver;
	}

	public void setIdReceiver(int idReceiver) {
		this.idReceiver = idReceiver;
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

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	@Override
	public String toString() {
		return "DirectMessage [id=" + id + ", idAuthor=" + idAuthor + ", idReceiver=" + idReceiver + ", content="
				+ content + ", active=" + active + "]";
	}
}
