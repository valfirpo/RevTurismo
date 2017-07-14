package com.rev.bean;

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
@Table(name = "RT_THREADS")
public class Thread 
{
	@Id
	@Column(name = "T_ID")
	@SequenceGenerator(name = "THREADS_ID_SEQ", sequenceName = "THREADS_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "THREADS_ID_SEQ")
	private int id;
	@Column(name = "T_NAME")	
	private String name;
	
	@Column(name = "T_LOCKED")
	private int locked;
	@Column(name = "T_ACTIVE")
	private int active;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="T_ID")
	private Set<Post> posts;
	
	public Thread(){}
	
	
	public Thread(String name, int locked, int active, Set<Post> posts) {
		super();
		this.name = name;
		this.locked = locked;
		this.active = active;
		this.posts = posts;
	}

	public Thread(int id, String name, int locked, int active, Set<Post> posts) {
		super();
		this.id = id;
		this.name = name;
		this.locked = locked;
		this.active = active;
		this.posts = posts;
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

	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + active;
		result = prime * result + id;
		result = prime * result + locked;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Thread other = (Thread) obj;
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
		if (posts == null) {
			if (other.posts != null)
				return false;
		} else if (!posts.equals(other.posts))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Thread [id=" + id + ", name=" + name + ", locked=" + locked + ", active=" + active + ", posts=" + posts
				+ "]";
	}


	
}
