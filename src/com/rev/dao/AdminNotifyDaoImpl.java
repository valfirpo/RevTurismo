package com.rev.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rev.bean.AdminNotify;
import com.rev.bean.Challenge;
import com.rev.util.HibernateUtil;

public class AdminNotifyDaoImpl implements AdminNotifyDao {

	@Override
	public AdminNotify getAdminNotifyById(int id) {
		Session session = null;
		AdminNotify note = null;
		try{
			session = HibernateUtil.getSession();
			note = (AdminNotify) session.get(AdminNotify.class, id);
		}finally{
			if(session != null)
			{
				session.close();
			}
		}
		return note;
	}

	@Override
	public String createAdminNotify(AdminNotify admin) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		String note = null;
		admin.setContent(admin.getContent());
		admin.setActive(1);
		note = admin.getContent();
		
		try{
			if(note == null){
				System.out.println("NO VALUE ADDED");
				return null;
			}
			if(note == ""){
				System.out.println("NO VALUE ADDED");
				return null;
			}
			if(note == "null"){
				System.out.println("NO VALUE ADDED");
				return null;
			}
			tx = session.beginTransaction();
			session.save(admin);
			tx.commit();
		}catch(HibernateException e)
		{
			e.printStackTrace();
		}finally
		{
			if(tx != null && !tx.wasCommitted())
			{
				tx.rollback();
			}
			if(session != null)
			{
				session.close();
			}
			
		}
		System.out.println("String from admin: " + admin.getContent());
		System.out.println("String note from admin: " + note);
		return note ;
	}

	@Override
	public void udpateAdminNotify(AdminNotify note) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.update(note);
			tx.commit();
		}finally{
			if(session != null)
			{
				session.close();
			}
			if(tx != null && !tx.wasCommitted())
			{
				tx.rollback();
			}
		}

	}

	@Override
	public void deleteAdminNotify(AdminNotify note) {
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.delete(note);
			tx.commit();
		}finally{
			if(tx != null && !tx.wasCommitted())
			{
				tx.rollback();
			}
			if(session != null)
			{
				session.close();
			}
		}

	}

	@Override
	public List<AdminNotify> getAdminNotifies() {
		Session session = HibernateUtil.getSession();
		List<AdminNotify> notes = session.createCriteria(AdminNotify.class).list();
		return notes;
	}

}
