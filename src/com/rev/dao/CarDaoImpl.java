package com.rev.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rev.bean.Car;
import com.rev.bean.Challenge;
import com.rev.util.HibernateUtil;

public class CarDaoImpl implements CarDao {

	@Override
	public Car getCarById(int carId) {
		Session session = null;
		Car car = null;
		try{
			session = HibernateUtil.getSession();
			car = (Car) session.get(Car.class, carId);
		}finally{
			if(session != null)
			{
				session.close();
			}
		}
		return car;
	}

	@Override
	public int createCar(Car car) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Integer carId = null;
		try{
			tx = session.beginTransaction();
			carId = (Integer) session.save(car);
			tx.commit();
		}catch(HibernateException e)
		{
			e.printStackTrace();
		}finally
		{
			if(tx != null && !tx.wasCommitted())
			{
				tx.rollback();
			}
			if(session != null)
			{
				session.close();
			}
			
		}
		return carId;
	}

	@Override
	public void udpateCar(Car car) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.update(car);
			tx.commit();
		}finally{
			if(session != null)
			{
				session.close();
			}
			if(tx != null && !tx.wasCommitted())
			{
				tx.rollback();
			}
		}

	}

	@Override
	public void deleteCar(Car car) {
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.delete(car);
			tx.commit();
		}finally{
			if(tx != null && !tx.wasCommitted())
			{
				tx.rollback();
			}
			if(session != null)
			{
				session.close();
			}
		}

	}

	@Override
	public List<Car> getCars() {
		Session session = HibernateUtil.getSession();
		List<Car> cars = session.createCriteria(Car.class).list();
		return cars;
	}

}
