package com.rev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import com.rev.bean.Login;
import com.rev.bean.User;
import com.rev.dao.UserDao;

@Component
public class UserServiceImpl implements UserService {

	  @Autowired
	  public UserDao userDao;
	  
	  
	  public void register(User user) 
	  {
	    userDao.createUser(user);
	  }

	  public User validateUser(Login login) 
	  {
	    return userDao.validateUser(login);
	  }
	  
	  public List<User> getAllUsers()
	  {
		  System.out.println("in service");
		 return userDao.getAllUsers();
	  }

	@Override
	public List<User> getAllSubAdmin() 
	{
		System.out.println("in service");
		return userDao.getAllSubAdmin();
	}

	@Override
	public void updateUser(User user) 
	{
		userDao.updateUser(user);
	}

	@Override
	public User validateUser(Login login, BindingResult bindingResult) {
		// TODO Auto-generated method stub
		return userDao.validateUser(login);
	}

	}