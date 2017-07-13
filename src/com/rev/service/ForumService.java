package com.rev.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rev.bean.Category;
import com.rev.bean.Post;
import com.rev.bean.Thread;
import com.rev.bean.User;
import com.rev.dao.CategoryDaoImpl;
import com.rev.dao.ThreadDaoImpl;

@Component
public class ForumService {
	
	public List<Category> getCategories()
	{
		return new CategoryDaoImpl().getCategories();
	}
	public Category getCategory(int catId)
	{
		return new CategoryDaoImpl().getCategoryById(catId);
	}
	public Thread getThread(int tId)
	{
		return new ThreadDaoImpl().getThreadById(tId);
	}
	public void addPost(Post post, User author)
	{
		int tid = post.getTid();
		Thread thread = getThread(tid);
		post.setAuthor(author);
		post.setActive(1);
		post.setThread(thread);
		thread.getPosts().add(post);
	}
}
