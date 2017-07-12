package com.rev.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	@ManyToOne
	@JoinColumn(name="UR_ID")
	private Role role;
	@Column(name = "CA_LOCKED")
	private int locked;
	@Column(name = "CA_ACTIVE")
	private int active;
	@OneToMany(mappedBy = "CA_ID")
	private List<Thread> threads;

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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Thread> getThreads() {
		return threads;
	}

	public void setThreads(List<Thread> threads) {
		this.threads = threads;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", urId=" + urId + ", locked=" + locked + ", active=" + active
				+ "]";
	}
}
