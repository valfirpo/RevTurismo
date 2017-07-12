package com.rev.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;

import com.rev.bean.User;
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
	UserService userService;

	@RequestMapping(value = "controlPanel")
	public String controlPaneln(HttpServletRequest request, HttpServletResponse response) {
		return "controlPanel";
	}

	@RequestMapping(value = "viewCars")
	public String viewCars(HttpServletRequest request, HttpServletResponse response) {
		CarDao dao = new CarDaoImpl();
		request.setAttribute("cars", dao.getCars());
		return "viewCars";
	}

	@RequestMapping(value = "viewChallenges")
	public String viewChallenges(HttpServletRequest request, HttpServletResponse response) {
		ChallengeDao dao = new ChallengeDaoImpl();
		request.setAttribute("challenges", dao.getChallenges());
		return "viewChallenges";
	}
	
	/*
	@RequestMapping(value = "viewUsers")
	public String viewUsers(ModelMap modelMap , BindingResult bindingResult, HttpSession session) 
	{
		if(bindingResult.hasErrors()){
			return "controlPanel";
		}
	
		List<User> l = userService.getAllUsers();
		
		modelMap.addAttribute("allUsers",l);
		session.setAttribute("allUsers", l);
		return "viewUsers";
	}
	*/
	
	@RequestMapping(value = "forum")
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

}
