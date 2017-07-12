package com.rev.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rev.dao.CarDao;
import com.rev.dao.CarDaoImpl;
import com.rev.dao.ChallengeDao;
import com.rev.dao.ChallengeDaoImpl;
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

}
