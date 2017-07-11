package com.rev.dao;

import com.rev.bean.Login;
import com.rev.bean.User;

public interface UserDao 
{
	 public User getUserById(int roleId);
	 public void createUser();
	 public void register(User user);
	 public User validateUser(Login logIn);
} 