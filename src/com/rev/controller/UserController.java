package com.rev.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rev.bean.User;
import com.rev.service.UserService;

@Controller
@RequestMapping(value="/")
public class UserController 
{
	@Autowired
	 UserService userService;

	@RequestMapping(value="viewUsers")
	public String viewUsers(HttpServletRequest request, HttpServletResponse response, 
			ModelMap modelMap,
			HttpSession session)
	{
		
		List<User> l = userService.getAllUsers();
		
		modelMap.addAttribute("allUsers",l);
		
		return "viewUsers";
	}
	
	@RequestMapping(value="viewSubAdmin")
	public String viewSubAdmin(HttpServletRequest request, HttpServletResponse response, 
			ModelMap modelMap,
			HttpSession session)
	{
		List<User> l = userService.getAllSubAdmin();
		
		modelMap.addAttribute("allSubAdmin", l);
		
		return "viewSubAdmin";
	}
}
