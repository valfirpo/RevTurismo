package com.rev.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.rev.bean.Login;
import com.rev.bean.Role;
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
	public User validateUser(Login login) 
	{
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();;
		Query query;
		List<User> users = null;
		String hql;
		User user = null;
		
		try
		{
			hql = "FROM com.rev.bean.User WHERE username = :un AND password = :pass";
			query = session.createQuery(hql);
			query.setParameter("un", login.getUsername());
			query.setParameter("pass", login.getPassword());
			
			users = query.list();
			if(users.size() > 0)
			{
				user = users.get(0);
			}
			
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally
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
		users.clear();
		return user;
	}
	
	@Override
	public void updateUser(User user)
	{
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.update(user);
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
	public List<User> getAllUsers() 
	{
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();;
		List<User> users = null;
		
		try
		{
			users = session.createCriteria(User.class).add(Restrictions.eq("role.urId", 3)).list();
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally
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
		
		return users;
	}
}