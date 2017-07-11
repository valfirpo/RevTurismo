package com.rev.bean;

public class Challenge 
{
	private int id;
	private String name;
	private int reward;
	private int level;

	public Challenge(){}
	
	public Challenge(int id, String name, int reward, int level) {
		this.id = id;
		this.name = name;
		this.reward = reward;
		this.level = level;
	}
	
	public Challenge(String name, int reward, int level) {
		this.id = id;
		this.name = name;
		this.reward = reward;
		this.level = level;
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

	public int getReward() {
		return reward;
	}

	public void setReward(int reward) {
		this.reward = reward;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Challenge [id=" + id + ", name=" + name + ", reward=" + reward + ", level=" + level + "]";
	}
}
