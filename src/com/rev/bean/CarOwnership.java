package com.rev.bean;

public class CarOwnership 
{
	private String userId;
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
