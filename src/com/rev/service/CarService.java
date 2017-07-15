package com.rev.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.rev.bean.Car;

@Component
public interface CarService 
{
	public List<Car> getAllCars();
	public Car getCarById(int id);
	public void updateCar(Car car);
}
