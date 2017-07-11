package com.rev.dao;

import org.hibernate.Session;

import com.rev.bean.Login;
import com.rev.bean.User;
import com.rev.util.HibernateUtil;

public class UserDaoImpl implements UserDao 
{

	@Override
	public User getUserById(int roleId) 
	{
		Session session = HibernateUtil.getSession();
		
		User s = (User) session.get(User.class, roleId);
		
		session.close();
		
		return s;
	}

	@Override
	public void createUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void register(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User validateUser(Login logIn) {
		// TODO Auto-generated method stub
		return null;
	}
  
}