package com.rev.main;


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
		Role testRole = dao2.getRole(1);
		
		User testUser = new User("testname", "test", "paul", "wess", "test@this.com", 100, 1, testRole);
		
		System.out.println(dao.createUser(testUser));
		
		
		
		System.out.println("DOne");
	}
}
