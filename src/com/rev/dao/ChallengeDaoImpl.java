package com.rev.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rev.bean.Challenge;
import com.rev.util.HibernateUtil;

public class ChallengeDaoImpl implements ChallengeDao {

	@Override
	public Challenge getChallengeById(int challengeId) {
		Session session = null;
		Challenge challenge = null;
		try{
			session = HibernateUtil.getSession();
			challenge = (Challenge) session.get(Challenge.class, challengeId);
		}finally{
			if(session != null)
			{
				session.close();
			}
		}
		return challenge;
	}

	@Override
	public int createChallenge(Challenge challenge) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Integer userId = null;
		try{
			tx = session.beginTransaction();
			userId = (Integer) session.save(challenge);
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
		return userId;
	}

	@Override
	public void updateChallenge(Challenge challenge) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.update(challenge);
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
	public void deleteChallenge(Challenge challenge)
	{
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.delete(challenge);
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
	public List<Challenge> getChallenges() {
		Session session = HibernateUtil.getSession();
		List<Challenge> challenges = session.createCriteria(Challenge.class).list();
		return challenges;
	}

}
