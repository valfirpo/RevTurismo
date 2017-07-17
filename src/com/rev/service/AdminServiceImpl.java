package com.rev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rev.bean.AdminNotify;
import com.rev.dao.AdminNotifyDao;

public class AdminServiceImpl implements AdminService {

	@Autowired
	public AdminNotifyDao adminDao;
	
	@Override
	public String createNotification(AdminNotify admin) {
		return adminDao.createAdminNotify(admin);	
	}

	@Override
	public List<AdminNotify> getAllNotifications() {
		return adminDao.getAdminNotifies();
	}

}
