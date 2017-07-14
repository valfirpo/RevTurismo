package com.rev.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

@Controller
public class ChallengeController 
{
	@Autowired
	ChallengeService challengeService;
	
	@Autowired
	CarService carService;
	
	@RequestMapping(value = "/viewChallenges")
	public String buyCar(HttpServletRequest request, HttpServletResponse response, 
			ModelMap modelMap,
			HttpSession session)
	{
		List<Challenge> l = challengeService.getAllChallenges();
		
		modelMap.addAttribute("allChallenges", l);
				
		return "viewChallenges";
	}
	
	@RequestMapping(value = "/enterChallenge")
	public String enterChallenge(HttpServletRequest request, HttpServletResponse response, 
			ModelMap modelMap,
			HttpSession session)
	{
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
	@RequestMapping(value = "/editChallenge")
	public ModelAndView editChallenge(HttpServletRequest request, HttpServletResponse response)
	{
		String chId = request.getParameter("chId");
		ModelAndView mav = new ModelAndView("EditChallenge");
		
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
		Challenge uChallenge = challengeService.getChallengesById(challenge.getId());
		if(uChallenge != null)
		{
			uChallenge.setName(challenge.getName());
			uChallenge.setEntryFee(challenge.getEntryFee());
			uChallenge.setLevel(challenge.getLevel());
			uChallenge.setReward(challenge.getReward());
			uChallenge.setTime(challenge.getTime());
			challengeService.updateChallenge(uChallenge);
			
		}
		
		return "redirect:viewChallenges";
		
	}
}
