package com.rev.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rev.bean.Car;
import com.rev.bean.Challenge;
import com.rev.bean.User;
import com.rev.service.CarService;
import com.rev.service.ChallengeService;

@Controller
@RequestMapping(value = "/")
public class ChallengeController 
{
	@Autowired
	ChallengeService challengeService;
	
	@Autowired
	CarService carService;
	
	@RequestMapping(value = "viewChallenges")
	public String buyCar(HttpServletRequest request, HttpServletResponse response, 
			ModelMap modelMap,
			HttpSession session)
	{
		List<Challenge> l = challengeService.getAllChallenges();
		
		modelMap.addAttribute("allChallenges", l);
				
		return "viewChallenges";
	}
	
	@RequestMapping(value = "enterChallenge")
	public String enterChallenge(HttpServletRequest request, HttpServletResponse response, 
			ModelMap modelMap,
			HttpSession session)
	{
		String id = request.getParameter("challengeId");
		User tempUser = (User) session.getAttribute("currentUser");
		Double tempCash;
		Challenge tempChall = challengeService.getChallengesById(Integer.parseInt(id));
		
		tempCash = tempUser.getCash();
		tempCash -= (tempChall.getReward() / 2);
		tempUser.setCash(tempCash);
	
		session.setAttribute("currentUser", tempUser);
	    modelMap.addAttribute("currentChallenge", tempChall);
		
		return "selectCar";
	}
	
	@RequestMapping(value = "startChallenge")
	public String startChallenge(HttpServletRequest request, HttpServletResponse response, 
			ModelMap modelMap,
			HttpSession session)
	{	
		String challId = request.getParameter("challengeId");
		String carId = request.getParameter("carId");
		
		System.out.println("chall: " + challId);

		System.out.println("car: " + carId);
		
		User tempUser = (User) session.getAttribute("currentUser");
		Double tempCash;
		Challenge tempChall = challengeService.getChallengesById(Integer.parseInt(challId));
		Car tempCar = carService.getCarById(Integer.parseInt(carId));
		
		System.out.println(tempCar.toString());

		System.out.println(tempChall.toString());
		
		tempCash = tempUser.getCash();
		tempCash += tempChall.getReward();
		tempUser.setCash(tempCash);
		
		session.setAttribute("currentUser", tempUser);
		
		return "viewChallenges";
	}
}
