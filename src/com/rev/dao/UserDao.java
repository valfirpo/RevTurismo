package com.rev.dao;

import java.util.List;

import com.rev.bean.Login;
import com.rev.bean.User;

public interface UserDao 
{
	 public User getUserById(int roleId);
	 public void createUser(User user);
	 public User validateUser(Login login);
	 public void updateUser(User user);
	 public List<User> getAllUsers();
	 public List<User> getAllSubAdmin();
	 public void updatePassword(User currentUser);
	 public User checkUser(User user);
} 