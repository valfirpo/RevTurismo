package com.rev.dao;

import java.util.List;


import javax.sql.DataSource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.rev.bean.Login;
import com.rev.bean.Role;
import com.rev.bean.User;
import com.rev.util.HibernateUtil;

public class UserDaoImpl implements UserDao 
{
	
	  @Autowired
	  DataSource datasource;

	  @Autowired
	  JdbcTemplate jdbcTemplate;

	@Override
	public User getUserById(int userId) 
	{
		Session session = HibernateUtil.getSession();
		
		User s = (User) session.get(User.class, userId);
		
		session.close();
		
		return s;
	}

	@Override
	public void createUser(User user) 
	{
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		
		user.setCash(35000);
		user.setRole(3);
		
		
		User newUser = new User(user.getUsername(), user.getPassword(),
		user.getCash(), user.getRole());
		
			
		
		//session.save(newUser.getRole());
	    //session.save(user);
		session.save(newUser);
	    tx.commit();

		session.close();
		
		//return user;
	}
	
	@Override
	public void createAdmin(User user) 
	{
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		
		user.setCash(0);
		user.setRole(2);
		
		
		User newUser = new User(user.getUsername(), user.getPassword(),
		user.getCash(), user.getRole());
		
			
		
		//session.save(newUser.getRole());
	    //session.save(user);
		session.save(newUser);
	    tx.commit();

		session.close();
		
		//return user;
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
				if(!(login.getUsername().equals(null) && login.getPassword().equals(null))){
					user = users.get(0);
					System.out.println("Correct username and password");
				}else{
					System.out.println("Incorrect username and password");
				}
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
			//users = session.createCriteria(User.class).add(Restrictions.eq("role.urId", 3)).list();
			users = session.createCriteria(User.class).add(Restrictions.eq("role", 3)).list();

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
		System.out.println("in Dao");

		return users;
	}

	@Override
	public List<User> getAllSubAdmin() 
	{
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();;
		List<User> users = null;
		
		try
		{
			//users = session.createCriteria(User.class).add(Restrictions.eq("role.urId", 2)).list();
			users = session.createCriteria(User.class).add(Restrictions.eq("role", 2)).list();

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
		
		System.out.println("in Dao");
		return users;
	}

	@Override
	public void updatePassword(User user) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Query query;
		String hql;
		user.setNewPassword(user.getNewPassword());
		System.out.println("new password hql: " + user.getNewPassword());
		
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			
			hql = "UPDATE com.rev.bean.User SET password = :pass";
			query = session.createQuery(hql);
			query.setParameter("pass", user.getNewPassword());
			query.executeUpdate();

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
	public User checkUser(User user) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();;
		Query query;
		List<User> users = null;
		String hql;
		Login login = new Login();
		login.setUsername(user.getUsername());
		System.out.println("login user:" + login.getUsername());
		//user.setUsername(user.getUsername());
		
		try
		{
			hql = "FROM com.rev.bean.User WHERE username = :un ";
			query = session.createQuery(hql);
			
			query.setParameter("un", user.getUsername());
			
			users = query.list();
			if(users.size() > 0)
			{
				user = users.get(0);
				if(user.getUsername().equals(login.getUsername()) && 
						(!(user.getUsername().equals(null)))){
					user = users.get(0);
					System.out.println("Correct username" + user.getUsername());
					return user;
				}
			}else {
				System.out.println("No User Found");
				return null;
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
		System.out.println("nothing checked!" + user.getUsername());
		users.clear();
		return null;
	}
}