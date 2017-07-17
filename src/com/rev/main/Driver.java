package com.rev.main;


import java.util.List;

import com.rev.bean.AdminNotify;
import com.rev.bean.User;
import com.rev.dao.AdminNotifyDaoImpl;
import com.rev.dao.UserDaoImpl;

public class Driver 
{
	public static void main(String [] args) 
	{
		UserDaoImpl dao = new UserDaoImpl();
		AdminNotifyDaoImpl dao1= new AdminNotifyDaoImpl();
		List<User> users;
		
		users = dao.getAllUsers();
		
		List<AdminNotify> notes;
		notes = dao1.getAdminNotifies();
		
		
		for(User f : users)
		{
			System.out.println(f);
		}
		
		System.out.println("DOne");
		
		
		
		for(AdminNotify l : notes)
		{
			System.out.println(l);
		}
		
		System.out.println("DOne");
	}
		
}
