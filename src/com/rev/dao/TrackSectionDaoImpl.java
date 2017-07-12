package com.rev.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rev.bean.TrackSection;
import com.rev.util.HibernateUtil;

public class TrackSectionDaoImpl implements TrackSectionDao {

	@Override
	public TrackSection getSectionById(int sectionId) {
		Session session = null;
		TrackSection section = null;
		try{
			session = HibernateUtil.getSession();
			section = (TrackSection) session.get(TrackSection.class, sectionId); 
		}finally{
			if(session != null)
			{
				session.close();
			}
		}
		return section;
	}

	@Override
	public int createTrackSection(TrackSection section) {
		Session session = null;
		Transaction tx = null;
		Integer sectionId = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			sectionId = (Integer) session.save(section);
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
		return sectionId;
	}

	@Override
	public void updateTrackSection(TrackSection section) {
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.update(section);
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
	public void deleteTrackSection(TrackSection section) {
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.delete(section);
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
