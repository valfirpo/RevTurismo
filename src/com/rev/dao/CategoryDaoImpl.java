package com.rev.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rev.bean.Category;
import com.rev.util.HibernateUtil;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public Category getCategoryById(int categoryId) {
		Session session = null;
		Category category = null;
		try{
			session = HibernateUtil.getSession();
			category = (Category) session.get(Category.class, categoryId);
			
		}finally{
			if(session != null)
			{
				session.close();
			}
		}
		return category;
	}

	@Override
	public int createCategory(Category category) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Integer catId = null;
		try{
			tx = session.beginTransaction();
			catId = (Integer) session.save(category);
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
		return catId;
	}

	@Override
	public void updateCategory(Category category) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.update(category);
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
	public void deleteCategory(Category category) {
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.delete(category);
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
	public List<Category> getCategories() {
		Session session = HibernateUtil.getSession();
		List<Category> categories = session.createCriteria(Category.class).list();
		removeDuplicates(categories);
		System.out.println(categories);
		session.close();
		return categories;
	}
	
	private void removeDuplicates(List<Category> categories)
	{
		for(int i = 0; i < categories.size(); i++)
		{
			int a;
			if(( a = categories.indexOf(categories.get(i))) != i)
			{
				categories.remove(a);
			}
		}
	}
}
