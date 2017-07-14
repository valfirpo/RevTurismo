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
	@RequestMapping(value = "viewChallenges")
	public String viewChallenges(HttpServletRequest request, HttpServletResponse response) {
		
		return "viewChallenges";
	}*/
}
