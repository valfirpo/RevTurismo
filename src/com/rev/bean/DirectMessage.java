package com.rev.bean;

public class DirectMessage 
{
	private int id;
	private int idAuthor;
	private int idReceiver;
	private String content;
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
		this.id = id;
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

	@Override
	public String toString() {
		return "DirectMessage [id=" + id + ", idAuthor=" + idAuthor + ", idReceiver=" + idReceiver + ", content="
				+ content + ", active=" + active + "]";
	}
}
