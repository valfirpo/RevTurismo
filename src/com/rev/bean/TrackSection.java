package com.rev.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "CH_ID")
	private Challenge challenge;
	
	@Column(name = "TS_CURVE_RATING")
	private double curveRating;
	@Column(name = "TS_DISTANCE")
	private double distance;
	
	public TrackSection(){}

	public TrackSection(Challenge challenge, double curveRating, double distance) {
		super();
		this.challenge = challenge;
		this.curveRating = curveRating;
		this.distance = distance;
	}

	public TrackSection(int id, Challenge challenge, double curveRating, double distance) {
		super();
		this.id = id;
		this.challenge = challenge;
		this.curveRating = curveRating;
		this.distance = distance;
	}

	public Challenge getChallenge() {
		return challenge;
	}

	public void setChallenge(Challenge challenge) {
		this.challenge = challenge;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public double getCurveRating() {
		return curveRating;
	}

	public void setCurveRating(double curveRating) {
		this.curveRating = curveRating;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "TrackSection [id=" + id + ", challenge=" + challenge + ", curveRating=" + curveRating + ", distance="
				+ distance + "]";
	}

	
	
}