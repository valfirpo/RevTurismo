package com.rev.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rev.bean.Category;
import com.rev.bean.Post;
import com.rev.bean.Thread;
import com.rev.bean.User;
import com.rev.dao.CategoryDao;
import com.rev.dao.CategoryDaoImpl;
import com.rev.dao.PostDaoImpl;
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
		thread.getPosts().add(post);
		String s;
		new ThreadDaoImpl().updateThread(thread);
	}
	public void addThread(String tname, int catId, String content, User author ){
		CategoryDao dao = new CategoryDaoImpl();
		Category cat = dao.getCategoryById(catId);
		
		Thread thread = new Thread();
		thread.setActive(1);
		thread.setLocked(0);
		thread.setName(tname);
		thread.setPosts(new HashSet<Post>());
		Post post = new Post();
		post.setActive(1);
		post.setAuthor(author);
		post.setContent(content);
		new PostDaoImpl().createPost(post);
		thread.getPosts().add(post);
		new ThreadDaoImpl().createThread(thread);
		
		cat.getThreads().add(thread);
		dao.updateCategory(cat);
		
		
	}
}
