package com.rev.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rev.bean.Challenge;
import com.rev.bean.Post;
import com.rev.util.HibernateUtil;

public class PostDaoImpl implements PostDao {

	@Override
	public Post getPostById(int postId) {
		Session session = null;
		Post post = null;
		try{
			session = HibernateUtil.getSession();
			post = (Post) session.get(Post.class, postId);
		}finally{
			if(session != null)
			{
				session.close();
			}
		}
		return post;
	}

	@Override
	public int createPost(Post post) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Integer postId = null;
		try{
			tx = session.beginTransaction();
			postId = (Integer) session.save(post);
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
		return postId;
	}

	@Override
	public void updatePost(Post post) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(post);
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
	public void deletePost(Post post) {
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.delete(post);
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
