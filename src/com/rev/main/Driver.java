package com.rev.main;


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
		RoleDaoImp dao2 = new RoleDaoImp();
		Role testRole = dao2.getRole(3);
		
		//User testUser = new User("ADMIN", "PASSWORD", "BOBBERT", "BOBSON", "BOBBERT.BOBSON@REVATURE.COM", 1000000, 1);
		
		Login login = new Login();
		login.setUsername("ADMIN");
		login.setPassword("PASSWORD");
		
		User testUser = dao.validateUser(login);
		
		System.out.println(testUser);
		
		System.out.println("DOne");
	}
}
