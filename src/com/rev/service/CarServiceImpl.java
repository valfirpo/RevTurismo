package com.rev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rev.bean.AdminNotify;
import com.rev.bean.Car;
import com.rev.bean.Challenge;
import com.rev.dao.AdminNotifyDao;
import com.rev.dao.AdminNotifyDaoImpl;
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

	@Override
	public void updateCar(Car car)
	{
		carDao.updateCar(car);
		AdminNotifyDao doa = new AdminNotifyDaoImpl();
		AdminNotify note = new AdminNotify();
		note.setActive(1);
		note.setContent(car.getCarName() + " Has been modified!");
		doa.createAdminNotify(note);
		
	}
}
