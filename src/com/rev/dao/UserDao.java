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
<<<<<<< HEAD
	 public void updatePassword(User currentUser);
	 public User checkUser(User user);
=======
	 public void createAdmin(User user);
>>>>>>> e13ea8851988b2b4343738d4ef74378519cf59e6
} 