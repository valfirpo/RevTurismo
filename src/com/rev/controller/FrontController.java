package com.rev.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rev.dao.CarDao;
import com.rev.dao.CarDaoImpl;
import com.rev.dao.CategoryDao;
import com.rev.dao.CategoryDaoImpl;
import com.rev.dao.ChallengeDao;
import com.rev.dao.ChallengeDaoImpl;
import com.rev.dao.ThreadDao;
import com.rev.dao.ThreadDaoImpl;
import com.rev.service.UserService;

@Controller
@RequestMapping(value = "/")
public class FrontController {

	@Autowired
	@Qualifier("userServiceImpl")
	UserService userService;

	@RequestMapping(value = "controlPanel")
	public String controlPaneln(HttpServletRequest request, HttpServletResponse response) {
		return "controlPanel";
	}

	/*
	@RequestMapping(value = "viewCars")
	public String viewCars(HttpServletRequest request, HttpServletResponse response) {
		CarDao dao = new CarDaoImpl();
		request.setAttribute("cars", dao.getCars());
		return "viewCars";
	}
	 */
	@RequestMapping(value = "viewChallenges")
	public String viewChallenges(HttpServletRequest request, HttpServletResponse response) {
		ChallengeDao dao = new ChallengeDaoImpl();
		request.setAttribute("challenges", dao.getChallenges());
		return "viewChallenges";
	}

	
	/*@RequestMapping(value = "forum")
	public String viewForum(HttpServletRequest request, HttpServletResponse response)
	{
		CategoryDao dao = new CategoryDaoImpl();
		request.setAttribute("categories", dao.getCategories());
		return "forum";
	}
	@RequestMapping(value="category")
	public String viewCategory(HttpServletRequest request, HttpServletResponse response)
	{
		int categoryId = Integer.parseInt(request.getParameter("catId"));
		CategoryDao dao = new CategoryDaoImpl();
		request.setAttribute("threads", dao.getCategoryById(categoryId).getThreads());
		return "categoryView";
	}
	@RequestMapping(value="thread")
	public String viewThread(HttpServletRequest request, HttpServletResponse response)
	{
		int threadId = Integer.parseInt(request.getParameter("threadId"));
		ThreadDao dao = new ThreadDaoImpl();
		request.setAttribute("posts", dao.getThreadById(threadId));
		return "threadView";
	}
*/
}
