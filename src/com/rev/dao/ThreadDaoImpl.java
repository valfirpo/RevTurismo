package com.rev.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rev.bean.Thread;
import com.rev.util.HibernateUtil;

public class ThreadDaoImpl implements ThreadDao {

	@Override
	public Thread getThreadById(int threadId) {
		Session session = null;
		Thread thread = null;
		try{
			session = HibernateUtil.getSession();
			thread = (Thread) session.get(Thread.class, threadId);
		}finally{
			if(session != null)
			{
				session.close();
			}
		}
		return thread;
	}

	@Override
	public int createThread(Thread thread) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Integer threadId = null;
		try{
			tx = session.beginTransaction();
			threadId = (Integer) session.save(thread);
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
		return threadId;
	}

	@Override
	public void updateThread(Thread thread) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(thread);
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
	public void deleteThread(Thread thread) {
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.delete(thread);
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

}
