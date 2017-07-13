package com.rev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rev.bean.Car;
import com.rev.dao.CarDao;

public class CarServiceImpl implements CarService
{
	@Autowired
	public CarDao carDao;
	
	@Override
	public List<Car> getAllCars() 
	{
		return carDao.getCars();
	}

	@Override
	public Car getCarById(int id) 
	{	
		return carDao.getCarById(id);
	}

}
