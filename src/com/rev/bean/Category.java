package com.rev.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "RT_CATEGORIES")
public class Category 
{
	@Id
	@Column(name = "CA_ID")
	@SequenceGenerator(name = "CATEGORIES_ID_SEQ", sequenceName = "CATEGORIES_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORIES_ID_SEQ")
	private int id;
	@Column(name = "CA_NAME")
	private String name;
	@Column(name = "UR_ID")
	private int urId;
	@Column(name = "CA_LOCKED")
	private int locked;
	@Column(name = "CA_ACTIVE")
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
