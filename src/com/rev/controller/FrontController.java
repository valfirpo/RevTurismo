package com.rev.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rev.bean.AdminNotify;
import com.rev.bean.User;
import com.rev.service.AdminService;
import com.rev.service.UserService;

@Controller
@RequestMapping(value = "/")
public class FrontController {
	
	
	@Autowired
	AdminService adminService;

	@Autowired
	@Qualifier("userServiceImpl")
	UserService userService;

	@RequestMapping(value = "controlPanel")
	public String controlPaneln(HttpServletRequest request, HttpServletResponse response) {
		return "controlPanel";
	}

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public ModelAndView homePage(@Valid User user,HttpServletRequest request, HttpServletResponse respones){
		ModelAndView mav = new ModelAndView("/home");
		List<AdminNotify> notes = new ArrayList<>();
		notes = adminService.getAllNotifications();
		    mav.addObject("notes",notes);
		    mav.addObject("user", new User());
		
		   // System.out.println("I found the page!");
		    return mav;
			
		}

	
	
/*
	@RequestMapping(value = "viewChallenges")
	public String viewChallenges(HttpServletRequest request, HttpServletResponse response) {
		
		return "viewChallenges";
	}*/
}
