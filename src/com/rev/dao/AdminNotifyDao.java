package com.rev.dao;

import java.util.List;

import com.rev.bean.AdminNotify;

public interface AdminNotifyDao {
	public AdminNotify getAdminNotifyById(int id);
	public String createAdminNotify(AdminNotify note);
	public void udpateAdminNotify(AdminNotify note);
	public void deleteAdminNotify(AdminNotify note);
	public List<AdminNotify> getAdminNotifies();
}
