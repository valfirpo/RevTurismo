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
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "myAwesomeCache")
public class TrackSection 
{
	@Id
	@Column(name = "TS_ID")
	@SequenceGenerator(name = "TRACK_SECTIONS_TS_ID", sequenceName = "TRACK_SECTIONS_TS_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRACK_SECTIONS_TS_ID")
	private int id;
	@Column(name = "CH_ID")
	private int challeneId;
	@Column(name = "TS_CURVE_RATING")
	private int curveRating;
	@Column(name = "TS_DISTANCE")
	private int distance;
	
	public TrackSection(){}
	
	public TrackSection(int id, int challeneId, int curveRating, int distance) {
		this.id = id;
		this.challeneId = challeneId;
		this.curveRating = curveRating;
		this.distance = distance;
	}
	
	public TrackSection(int challeneId, int curveRating, int distance) {
		this.id = id;
		this.challeneId = challeneId;
		this.curveRating = curveRating;
		this.distance = distance;
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
		return "TrackSection [id=" + id + ", challeneId=" + challeneId + ", curveRating=" + curveRating + ", distance="
				+ distance + "]";
	}
}
