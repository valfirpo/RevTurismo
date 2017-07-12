package com.rev.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rev.dao.CategoryDao;
import com.rev.dao.CategoryDaoImpl;
import com.rev.dao.ThreadDao;
import com.rev.dao.ThreadDaoImpl;
import com.rev.service.ForumService;

@Controller
@RequestMapping(value = "/")
public class ForumController {
	@Autowired
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
		int categoryId = Integer.parseInt(request.getParameter("catId"));
		request.setAttribute("threads", service.getThreads(categoryId));
		return "categoryView";
	}
	@RequestMapping(value="thread")
	public String viewThread(HttpServletRequest request, HttpServletResponse response)
	{
		int threadId = Integer.parseInt(request.getParameter("threadId"));
		request.setAttribute("posts", service.getPosts(threadId));
		return "threadView";
	}
	
}
