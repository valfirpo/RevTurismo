package com.rev.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rev.bean.Login;
import com.rev.bean.User;

@Component
public interface UserService {

	  void register(User user);

	  User validateUser(Login login);

	  public List<User> getAllUsers();
	  
	  public List<User> getAllSubAdmin();
	  
	  public void updateUser(User user);
	}
