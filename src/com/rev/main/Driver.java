package com.rev.main;

import com.rev.bean.Role;
import com.rev.dao.RoleDaoImp;

public class Driver {
	public static void main(String [] args) 
	{
		RoleDaoImp dao = new RoleDaoImp();
		Role testRole = dao.getRole(3);
		System.out.println(testRole);
		
		System.out.println("DOne");
	}
}
