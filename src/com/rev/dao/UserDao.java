package com.rev.dao;

import com.rev.bean.Login;
import com.rev.bean.User;

public interface UserDao {
	
	  void register(User user);
	  User validateUser(Login login);
	} 