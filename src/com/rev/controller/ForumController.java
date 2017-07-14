package com.rev.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rev.bean.Category;
import com.rev.bean.NewThread;
import com.rev.bean.Post;
import com.rev.bean.Thread;
import com.rev.bean.User;
import com.rev.service.ForumService;

@Controller
public class ForumController {
	@Autowired
	@Qualifier("forumService")
	ForumService service;
	
	private Logger logger = Logger.getLogger(ForumController.class);
	@RequestMapping(value = "/forum")
	public String viewForum(HttpServletRequest request, HttpServletResponse response)
	{
		
		List<Category> categories = service.getCategories();
		System.out.println(categories);
		request.setAttribute("categories", service.getCategories());
		logger.info("user accesses /forum");
		return "forum";
	}
	@RequestMapping(value="/category")
	public ModelAndView viewCategory(HttpServletRequest request, HttpServletResponse response)
	{
		
		String catId = request.getParameter("catId");
		logger.info("User acceses /category?" + catId);
		System.out.println(catId);
		ModelAndView mav = new ModelAndView("categoryView");
		mav.addObject("newThread", new NewThread());
		if(catId != null)
		{
			
			int categoryId = Integer.parseInt(catId);
			System.out.println(catId);
			
			Category cat = service.getCategory(categoryId);
			Set<Thread> threads = cat.getThreads();
			
			request.setAttribute("threads", threads);
			request.setAttribute("category", cat);
		}else
		{
			logger.warn("catId parameter is null");
			request.setAttribute("message", "Error: Category not selected");
			System.out.println(catId);
		}
		
		return mav;
	}
	@RequestMapping(value="/thread")
	public ModelAndView viewThread(HttpServletRequest request, HttpServletResponse response)
	{
		String tid = request.getParameter("threadId");
		logger.info("user accesses /thread?" + tid);
		ModelAndView mav = new ModelAndView("threadView");
		mav.addObject("post", new Post());
		if(tid != null)
		{
			int threadId = Integer.parseInt(request.getParameter("threadId"));
			Thread thread = service.getThread(threadId);
			Set<Post> posts = thread.getPosts();
			request.setAttribute("posts", posts);
			request.setAttribute("thread", thread);
		}else
		{
			logger.warn("threadId is null");
			request.setAttribute("message", "Error: Thread not selected");
		}
		
		return mav;
	}
	@RequestMapping(value="/createPost", method = RequestMethod.POST)
	public String doCreatePost(@Valid Post post, BindingResult bindingResult,
			ModelMap modelMap, HttpSession session)
	{
		logger.debug("create Post");
		service.addPost(post, (User) session.getAttribute("currentUser"));
		System.out.println("What is going on?");
		return "redirect:thread?threadId=" + post.getTid();
	}
	@RequestMapping(value="/createThread", method = RequestMethod.POST)
	public String doCreateThread(@Valid NewThread nThread,
			BindingResult bindingResult, ModelMap modelMap, HttpSession session)
	{
		if(!bindingResult.hasErrors()){
			logger.info("user creating thread");
			User author = (User)session.getAttribute("currentUser");
			String threadName = nThread.getTname();
			int catId = nThread.getCatId();
			String content = nThread.getContent();
			service.addThread(threadName, catId, content, author);
			return "redirect:category?catId=" + catId;
		}else
		{
			logger.warn(bindingResult.getAllErrors());
		}
		
		return "forum";
	}
	
}
