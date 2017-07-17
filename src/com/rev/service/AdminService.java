package com.rev.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rev.bean.AdminNotify;


@Component
public interface AdminService {
	
	
	public List<AdminNotify> getAllNotifications();
	public String createNotification(AdminNotify admin);
}
