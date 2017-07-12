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
	@ManyToOne
	@JoinColumn(name="UR_ID")
	private Role role;
	@Column(name = "CA_LOCKED")
	private int locked;
	@Column(name = "CA_ACTIVE")
	private int active;
	@OneToMany(mappedBy = "category")
	private List<Thread> threads;

	public Category(){}
	

	public Category(String name, Role role, int locked, int active, List<Thread> threads) {
		super();
		this.name = name;
		this.role = role;
		this.locked = locked;
		this.active = active;
		this.threads = threads;
	}

	public Category(int id, String name, Role role, int locked, int active, List<Thread> threads) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.locked = locked;
		this.active = active;
		this.threads = threads;
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
		return "Category [id=" + id + ", name=" + name + ", role=" + role + ", locked=" + locked + ", active=" + active
				+ ", threads=" + threads + "]";
	}

}
