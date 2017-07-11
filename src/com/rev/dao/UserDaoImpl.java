package com.rev.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rev.bean.Login;
import com.rev.bean.User;
import com.rev.util.HibernateUtil;

public class UserDaoImpl implements UserDao 
{

	@Override
	public User getUserById(int userId) 
	{
		Session session = HibernateUtil.getSession();
		
		User s = (User) session.get(User.class, userId);
		
		session.close();
		
		return s;
	}

	@Override
	public int createUser(User user) 
	{
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Integer userId = null;
		
		try
		{
			tx = session.beginTransaction();
			userId = (Integer) session.save(user);
			tx.commit();
		}
		catch(HibernateException e)
		{
			if(tx != null)
			{
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return userId;
	}

	@Override
	public User validateUser(Login logIn) {
		// TODO Auto-generated method stub
		return null;
	}
  
}