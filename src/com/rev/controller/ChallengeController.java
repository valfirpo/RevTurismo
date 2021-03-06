package com.rev.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rev.bean.Car;
import com.rev.bean.Challenge;
import com.rev.bean.User;
import com.rev.service.CarService;
import com.rev.service.ChallengeService;
import com.rev.service.SimulationService;
import com.rev.service.UserService;

@Controller
public class ChallengeController 
{
	@Autowired
	ChallengeService challengeService;
	
	@Autowired
	CarService carService;
	
	@Autowired
	SimulationService simService;
	
	@Autowired
	UserService userService;
	
	private Logger logger = Logger.getLogger(ChallengeController.class);
	@RequestMapping(value = "/viewChallenges")
	public String buyCar(HttpServletRequest request, HttpServletResponse response, 
			ModelMap modelMap,
			HttpSession session)
	{
		logger.info("/viewChallenges");
		List<Challenge> l = challengeService.getAllChallenges();
		
		modelMap.addAttribute("allChallenges", l);
				
		return "viewChallenges";
	}
	
	@RequestMapping(value = "/enterChallenge")
	public String enterChallenge(HttpServletRequest request, HttpServletResponse response, 
			ModelMap modelMap,
			HttpSession session)
	{
		logger.info("/enterChallenge");
		String id = request.getParameter("challengeId");
		User tempUser = (User) session.getAttribute("currentUser");
		Double tempCash;
		Challenge tempChall = challengeService.getChallengesById(Integer.parseInt(id));
		
		tempCash = tempUser.getCash();
		tempCash -= (tempChall.getEntryFee());
		tempUser.setCash(tempCash);
	
		session.setAttribute("currentUser", tempUser);
	    modelMap.addAttribute("currentChallenge", tempChall);
		
		return "selectCar";
	}
	
	@RequestMapping(value = "/startChallenge")
	public String startChallenge(HttpServletRequest request, HttpServletResponse response, 
			ModelMap modelMap,
			HttpSession session)
	{	
		logger.info("/startChallenge");
		String challId = request.getParameter("challengeId");
		String carId = request.getParameter("carId");
		
		User tempUser = (User) session.getAttribute("currentUser");
		Double tempCash;
		Challenge tempChall = challengeService.getChallengesById(Integer.parseInt(challId));
		Car tempCar = carService.getCarById(Integer.parseInt(carId));
		
		logger.info(tempCar.toString());

		logger.info(tempChall.toString());
		Double time = simService.simulateRace(tempChall, tempCar);
		if(time <= tempChall.getTime())
		{
			tempCash = tempUser.getCash();
			tempCash += tempChall.getReward();
			tempUser.setCash(tempCash);
			
			if(tempUser.getCash() > 100000)
			{
				tempUser.setRole(4);
			}
			if(tempUser.getCash() > 150000)
			{
				tempUser.setRole(5);
			}
			if(tempUser.getCash() > 200000)
			{
				tempUser.setRole(6);
			}
			if(tempUser.getCash() > 300000)
			{
				tempUser.setRole(7);
			}
			
			modelMap.addAttribute("message", "Challenge " + tempChall.getName() +" Completed Succesfully");
		}
		else
		{
			modelMap.addAttribute("message", "Challenge " + tempChall.getName() +" Not Completed Succesfully");
		}
		
		modelMap.addAttribute("finishTime", time);
		modelMap.addAttribute("raceTime", tempChall.getTime());
		
		userService.updateUser(tempUser);
		session.setAttribute("currentUser", tempUser);
		
		return "challengeResult";
	}
	
	@RequestMapping(value = "/editChallenge")
	public ModelAndView editChallenge(HttpServletRequest request, HttpServletResponse response)
	{
		logger.info("/editChallenge");
		String chId = request.getParameter("chId");
		ModelAndView mav = new ModelAndView("/editChallenge");
		
		if(chId !=  null)
		{
			int challengeId = Integer.parseInt(chId);
			Challenge challenge = challengeService.getChallengesById(challengeId);
			request.setAttribute("challenge", challenge );
			mav.addObject("challenge", challenge);
		}else
		{
			request.setAttribute("message", "Error: Challenge Not Selected");
			mav.addObject("challenge", new Challenge());
		}
		return mav;
	}
	
	@RequestMapping(value = "/updateChallenge", method= RequestMethod.POST)
	public String doUpdateChallenge(@Valid Challenge challenge,
			BindingResult bindingResult, ModelMap modelMap,
			HttpSession session){
		logger.info("challenge");
		Challenge uChallenge = challengeService.getChallengesById(challenge.getId());
		if(uChallenge != null)
		{
			uChallenge.setName(challenge.getName());
			uChallenge.setEntryFee(challenge.getEntryFee());
			uChallenge.setLevel(challenge.getLevel());
			uChallenge.setReward(challenge.getReward());
			uChallenge.setTime(challenge.getTime());
			challengeService.updateChallenge(uChallenge);
			logger.info("Creating Admin Notify");
			
		}
		
		return "redirect:viewChallenges";
	}
}
