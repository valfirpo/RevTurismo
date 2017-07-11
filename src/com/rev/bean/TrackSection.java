package com.rev.bean;

public class TrackSection 
{
	private int id;
	private int challeneId;
	
	public TrackSection(){}
	
	public TrackSection(int id, int challeneId) {
		this.id = id;
		this.challeneId = challeneId;
	}

	public TrackSection(int challeneId) {
		this.challeneId = challeneId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getChalleneId() {
		return challeneId;
	}

	public void setChalleneId(int challeneId) {
		this.challeneId = challeneId;
	}

	@Override
	public String toString() {
		return "TrackSection [id=" + id + ", challeneId=" + challeneId + "]";
	}
}
