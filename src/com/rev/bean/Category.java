package com.rev.bean;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="UR_ID")
	private Role role;
	@Column(name = "CA_LOCKED")
	private int locked;
	@Column(name = "CA_ACTIVE")
	private int active;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "CA_ID")
	private Set<Thread> threads;

	public Category(){}
	

	public Category(String name, Role role, int locked, int active, Set<Thread> threads) {
		super();
		this.name = name;
		this.role = role;
		this.locked = locked;
		this.active = active;
		this.threads = threads;
	}

	public Category(int id, String name, Role role, int locked, int active, Set<Thread> threads) {
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

	public Set<Thread> getThreads() {
		return threads;
	}

	public void setThreads(Set<Thread> threads) {
		this.threads = threads;
	}


	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", role=" + role + ", locked=" + locked + ", active=" + active
				+ ", threads=" + threads + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + active;
		result = prime * result + id;
		result = prime * result + locked;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((threads == null) ? 0 : threads.hashCode());
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
		Category other = (Category) obj;
		if (active != other.active)
			return false;
		if (id != other.id)
			return false;
		if (locked != other.locked)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (threads == null) {
			if (other.threads != null)
				return false;
		} else if (!threads.equals(other.threads))
			return false;
		return true;
	}


	

}
