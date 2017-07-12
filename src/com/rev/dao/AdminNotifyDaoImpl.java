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
	public int createAdminNotify(AdminNotify note) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Integer noteId = null;
		try{
			tx = session.beginTransaction();
			noteId = (Integer) session.save(note);
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
		return noteId;
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
