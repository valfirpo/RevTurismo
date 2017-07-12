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
	@Column(name = "CA_ID")
	private int categoryId;
	@ManyToOne
	@JoinColumn(name = "CA_ID")
	private Category category;
	@Column(name = "T_LOCKED")
	private int locked;
	@Column(name = "T_ACTIVE")
	private int active;
	@OneToMany(mappedBy="T_ID")
	private List<Post> posts;
	
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
		return "Thread [id=" + id + ", name=" + name + ", categoryId=" + categoryId + ", locked=" + locked + ", active="
				+ active + "]";
	}
}
