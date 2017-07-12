package com.rev.bean;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "RT_CHALLENGES")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "myAwesomeCache")
public class Challenge 
{
	@Id
	@Column(name = "CH_ID")
	@SequenceGenerator(name = "CHALLENGES_CH_ID_SEQ", sequenceName = "CHALLENGES_CH_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CHALLENGES_CH_ID_SEQ")
	private int id;
	@Column(name = "CH_NAME")
	private String name;
	@Column(name = "CH_REWARD")
	private int reward;
	@Column(name = "CH_MIN_LEVEL")
	private int level;
	@OneToMany(mappedBy = "challenge")
	private List<TrackSection> sections;
	public Challenge(){}
	
	public Challenge(int id, String name, int reward, int level) {
		this.id = id;
		this.name = name;
		this.reward = reward;
		this.level = level;
	}
	
	

	public Challenge(String name, int reward, int level) {
		this.name = name;
		this.reward = reward;
		this.level = level;
	}
	public List<TrackSection> getSections() {
		return sections;
	}

	public void setSections(List<TrackSection> sections) {
		this.sections = sections;
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
