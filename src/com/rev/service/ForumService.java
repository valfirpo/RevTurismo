package com.rev.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rev.bean.Category;
import com.rev.bean.Post;
import com.rev.bean.Thread;
import com.rev.dao.CategoryDaoImpl;
import com.rev.dao.ThreadDaoImpl;

@Component
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
		int i = 0;
		return new ThreadDaoImpl().getThreadById(tId).getPosts();
	}
}
