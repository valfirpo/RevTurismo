package com.rev.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rev.bean.Category;
import com.rev.bean.Post;
import com.rev.bean.User;
import com.rev.service.ForumService;
import com.rev.bean.Thread;

@Controller
@RequestMapping(value = "/")
public class ForumController {
	@Autowired
	@Qualifier("forumService")
	ForumService service;
	
	@RequestMapping(value = "forum")
	public String viewForum(HttpServletRequest request, HttpServletResponse response)
	{
		request.setAttribute("categories", service.getCategories());
		return "forum";
	}
	@RequestMapping(value="category")
	public String viewCategory(HttpServletRequest request, HttpServletResponse response)
	{
		String catId = request.getParameter("catId");
		if(catId != null)
		{
			int categoryId = Integer.parseInt(catId);
			Category cat = service.getCategory(categoryId);
			List<Thread> threads = cat.getThreads();
			
			request.setAttribute("threads", threads);
			request.setAttribute("category", cat);
		}else
		{
			request.setAttribute("message", "Error: Category not selected");
		}
		
		return "categoryView";
	}
	@RequestMapping(value="thread")
	public ModelAndView viewThread(HttpServletRequest request, HttpServletResponse response)
	{
		String tid = request.getParameter("threadId");
		ModelAndView mav = new ModelAndView("threadView");
		mav.addObject("post", new Post());
		if(tid != null)
		{
			int threadId = Integer.parseInt(request.getParameter("threadId"));
			Thread thread = service.getThread(threadId);
			List<Post> posts = thread.getPosts();
			request.setAttribute("posts", posts);
			request.setAttribute("thread", thread);
		}else
		{
			request.setAttribute("message", "Error: Thread not selected");
		}
		
		return mav;
	}
	@RequestMapping(value="createPost", method = RequestMethod.POST)
	public String doCreatePost(@Valid Post post, BindingResult bindingResult,
			ModelMap modelMap, HttpSession session)
	{
		service.addPost(post, (User) session.getAttribute("currentUser"));
		
		return null;
	}
	
}
