package com.rev.dao;

import org.hibernate.Session;

import com.rev.bean.Role;
import com.rev.util.HibernateUtil;

public class RoleDaoImp implements RoleDao
{
	@Override
	public Role getRole(int roleId) 
	{
		Session session = HibernateUtil.getSession();
		
		Role r = (Role) session.get(Role.class, roleId);
		
		return r;
	}

}
