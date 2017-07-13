package com.rev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rev.bean.Login;
import com.rev.bean.User;
import com.rev.dao.UserDao;

@Component
public class UserServiceImpl implements UserService {

	  @Autowired
	  public UserDao userDao;

	  public void register(User user) 
	  {
	    System.out.println(userDao.createUser(user));
	  }

	  public User validateUser(Login login) 
	  {
	    return userDao.validateUser(login);
	  }
	  
	  public List<User> getAllUsers()
	  {
		 return userDao.getAllUsers();
	  }

	@Override
	public List<User> getAllSubAdmin() 
	{
		return userDao.getAllSubAdmin();
	}

	@Override
	public void updateUser(User user) 
	{
		userDao.updateUser(user);
	}

	}