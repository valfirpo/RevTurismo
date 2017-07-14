package com.rev.service;

import java.util.Date;
import java.util.List;
import java.util.TreeSet;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.rev.bean.Category;
import com.rev.bean.Post;
import com.rev.bean.Thread;
import com.rev.bean.User;
import com.rev.dao.CategoryDao;
import com.rev.dao.CategoryDaoImpl;
import com.rev.dao.ThreadDaoImpl;

@Component
public class ForumService {
	private Logger logger = Logger.getLogger(ForumService.class);
	
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
		Thread t = new ThreadDaoImpl().getThreadById(tId);
		logger.trace("Thread retrieved with " + t.getPosts().size() + " posts");
		
		return t;
	}
	public void addPost(Post post, User author)
	{
		int tid = post.getTid();
		Thread thread = getThread(tid);
		post.setAuthor(author);
		post.setActive(1);
		post.setTime(new Date());
		
		thread.getPosts().add(post);
		new ThreadDaoImpl().updateThread(thread);
	}
	public void addThread(String tname, int catId, String content, User author ){
		CategoryDao dao = new CategoryDaoImpl();
		Category cat = dao.getCategoryById(catId);
		
		Thread thread = new Thread();
		thread.setActive(1);
		thread.setLocked(0);
		thread.setName(tname);
		thread.setPosts(new TreeSet<Post>());
		Post post = new Post();
		post.setActive(1);
		post.setAuthor(author);
		post.setContent(content);
		post.setTime(new Date());
		//new PostDaoImpl().createPost(post);
		thread.getPosts().add(post);
		//new ThreadDaoImpl().createThread(thread);
		
		cat.getThreads().add(thread);
		dao.updateCategory(cat);
		
		
	}
}
