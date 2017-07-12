package com.rev.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rev.service.ForumService;

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
			request.setAttribute("threads", service.getThreads(categoryId));
		}else
		{
			request.setAttribute("message", "Error: Category not selected");
		}
		
		return "categoryView";
	}
	@RequestMapping(value="thread")
	public String viewThread(HttpServletRequest request, HttpServletResponse response)
	{
		String tid = request.getParameter("threadId");
		if(tid != null)
		{
			int threadId = Integer.parseInt(request.getParameter("threadId"));
			request.setAttribute("posts", service.getPosts(threadId));
		}else
		{
			request.setAttribute("message", "Error: Thread not selected");
		}
		
		return "threadView";
	}
	
}
