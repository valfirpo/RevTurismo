package com.rev.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rev.bean.Challenge;
import com.rev.bean.DirectMessage;
import com.rev.util.HibernateUtil;

public class DirectMessageDaoImpl implements DirectMessageDao {

	@Override
	public DirectMessage getDmById(int dmId) {
		Session session = null;
		DirectMessage dm = null;
		try{
			session = HibernateUtil.getSession();
			dm = (DirectMessage) session.get(DirectMessage.class, dmId);
		}finally{
			if(session != null)
			{
				session.close();
			}
		}
		return dm;
	}

	@Override
	public int createDm(DirectMessage dm) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Integer dmId = null;
		try{
			tx = session.beginTransaction();
			dmId = (Integer) session.save(dm);
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
		return dmId;
	}

	@Override
	public void updateDm(DirectMessage dm) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.update(dm);
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
	public void deleteDm(DirectMessage dm) {
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.delete(dm);
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
