package com.rev.main;


import java.util.List;

import com.rev.bean.Login;
import com.rev.bean.Role;
import com.rev.bean.User;
import com.rev.dao.RoleDaoImp;
import com.rev.dao.UserDaoImpl;

public class Driver 
{
	public static void main(String [] args) 
	{
		UserDaoImpl dao = new UserDaoImpl();
		
		List<User> users;
		
		users = dao.getAllUsers();
		
		
		
		for(User f : users)
		{
			System.out.println(f);
		}
		
		System.out.println("DOne");
	}
}
