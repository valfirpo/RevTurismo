package com.rev.bean;

public class Category 
{
	private int id;
	private String name;
	private int urId;
	private int locked;
	private int active;

	public Category(){}
	
	public Category(int id, String name, int urId, int locked, int active) {
		super();
		this.id = id;
		this.name = name;
		this.urId = urId;
		this.locked = locked;
		this.active = active;
	}
	
	public Category(String name, int urId, int locked, int active) {
		this.name = name;
		this.urId = urId;
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

	public int getUrId() {
		return urId;
	}

	public void setUrId(int urId) {
		this.urId = urId;
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
		return "Category [id=" + id + ", name=" + name + ", urId=" + urId + ", locked=" + locked + ", active=" + active
				+ "]";
	}
}
