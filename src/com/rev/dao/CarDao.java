package com.rev.dao;

import java.util.List;

import com.rev.bean.Car;

public interface CarDao {
	public Car getCarById(int carId);
	public int createCar(Car car);
	public void updateCar(Car car);
	public void deleteCar(Car car);
	public List<Car> getCars();
}
