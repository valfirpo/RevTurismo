package com.rev.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rev.bean.Challenge;
import com.rev.service.ChallengeService;

@Controller
@RequestMapping(value = "/")
public class ChallengeController 
{
	@Autowired
	ChallengeService challengeService;
	
	@RequestMapping(value = "viewChallenges")
	public String buyCar(HttpServletRequest request, HttpServletResponse response, 
			ModelMap modelMap,
			HttpSession session)
	{
		List<Challenge> l = challengeService.getAllChallenges();
		
		modelMap.addAttribute("allChallenges", l);
				
		return "viewChallenges";
	}
	
	@RequestMapping(value = "startChallenge")
	public String enterChallenge(HttpServletRequest request, HttpServletResponse response, 
			ModelMap modelMap,
			HttpSession session)
	{
		List<Challenge> l = challengeService.getAllChallenges();
		
		modelMap.addAttribute("allChallenges", l);
		
		return "viewChallenges";
	}
}
