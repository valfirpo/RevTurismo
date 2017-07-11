package com.rev.bean;

public class Thread 
{
	private int id;
	private String name;
	private int categoryId;
	private int locked;
	private int active;
	
	public Thread(){}
	
	public Thread(int id, String name, int categoryId, int locked, int active) {
		this.id = id;
		this.name = name;
		this.categoryId = categoryId;
		this.locked = locked;
		this.active = active;
	}
	
	public Thread(String name, int categoryId, int locked, int active) {
		this.name = name;
		this.categoryId = categoryId;
		this.locked = locked;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getLocked() {
		return locked;
	}

	public void setLocked(int locked) {
		this.locked = locked;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Thread [id=" + id + ", name=" + name + ", categoryId=" + categoryId + ", locked=" + locked + ", active="
				+ active + "]";
	}
}
