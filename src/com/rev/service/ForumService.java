package com.rev.service;

import java.util.List;

import com.rev.bean.Category;
import com.rev.bean.Post;
import com.rev.bean.Thread;
import com.rev.dao.CategoryDaoImpl;
import com.rev.dao.ThreadDaoImpl;

public class ForumService {
	
	public List<Category> getCategories()
	{
		return new CategoryDaoImpl().getCategories();
	}
	public List<Thread> getThreads(int catId)
	{
		return new CategoryDaoImpl().getCategoryById(catId).getThreads();
	}
	public List<Post> getPosts(int tId)
	{
		return new ThreadDaoImpl().getThreadById(tId).getPosts();
		
	}
}
