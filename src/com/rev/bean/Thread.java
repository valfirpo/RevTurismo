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
	@ManyToOne
	@JoinColumn(name = "CA_ID")
	private Category category;
	@Column(name = "T_LOCKED")
	private int locked;
	@Column(name = "T_ACTIVE")
	private int active;
	@OneToMany(mappedBy="thread")
	private List<Post> posts;
	
	public Thread(){}
	
	
	public Thread(String name, Category category, int locked, int active, List<Post> posts) {
		super();
		this.name = name;
		this.category = category;
		this.locked = locked;
		this.active = active;
		this.posts = posts;
	}

	public Thread(int id, String name, Category category, int locked, int active, List<Post> posts) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}


	@Override
	public String toString() {
		return "Thread [id=" + id + ", name=" + name + ", category=" + category + ", locked=" + locked + ", active="
				+ active + ", posts=" + posts + "]";
	}
}
