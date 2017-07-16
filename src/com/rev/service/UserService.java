package com.rev.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import com.rev.bean.Login;
import com.rev.bean.User;

@Component
public interface UserService {

	  void register(User user);
	  
	  public void registerAdmin(User user);

	  User validateUser(Login login);

	  public List<User> getAllUsers();
	  
	  public List<User> getAllSubAdmin();
	  
	  public void updateUser(User user);

	User validateUser(Login login, BindingResult bindingResult);
	}
