package com.rev.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "RT_TRACK_SECTIONS")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "myAwesomeCache")
public class TrackSection 
{
	@Id
	@Column(name = "TS_ID")
	@SequenceGenerator(name = "TRACK_SECTIONS_TS_ID", sequenceName = "TRACK_SECTIONS_TS_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRACK_SECTIONS_TS_ID")
	private int id;
	@Column(name = "CH_ID")
	private int challengeId;
	@Column(name = "TS_CURVE_RATING")
	private int curveRating;
	@Column(name = "TS_DISTANCE")
	private int distance;
	
	public TrackSection(){}

	public TrackSection(int id, int challengeId, int curveRating, int distance) {
		this.id = id;
		this.challengeId = challengeId;
		this.curveRating = curveRating;
		this.distance = distance;
	}
	
	public TrackSection(int challengeId, int curveRating, int distance) {
		this.challengeId = challengeId;
		this.curveRating = curveRating;
		this.distance = distance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getChallengeId() {
		return challengeId;
	}

	public void setChallengeId(int challengeId) {
		this.challengeId = challengeId;
	}

	public int getCurveRating() {
		return curveRating;
	}

	public void setCurveRating(int curveRating) {
		this.curveRating = curveRating;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "TrackSection [id=" + id + ", challengeId=" + challengeId + ", curveRating=" + curveRating
				+ ", distance=" + distance + "]";
	}
	
}