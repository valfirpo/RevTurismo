package com.rev.service;

import org.springframework.stereotype.Component;

import com.rev.bean.Login;
import com.rev.bean.User;

@Component
public interface UserService {

	  void register(User user);

	  User validateUser(Login login);
	}
