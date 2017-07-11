package com.rev.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "RT_CAR_OWNERSHIP")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "myAwesomeCache")
public class CarOwnership 
{
	@Column(name = "U_ID")
	private String userId;
	@Column(name = "C_ID")
	private String carId;

	public CarOwnership() {}
	
	public CarOwnership(String userId, String carId) {
		super();
		this.userId = userId;
		this.carId = carId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	@Override
	public String toString() {
		return "CarOwnership [userId=" + userId + ", carId=" + carId + "]";
	}
}
