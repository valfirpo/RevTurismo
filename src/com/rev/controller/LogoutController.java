package com.rev.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/logout")
public class LogoutController {

	
	 @RequestMapping(method = RequestMethod.GET)
	 public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, 
			 					   @RequestParam(value ="logout",required = false) String logout) {
		 ModelAndView model = new ModelAndView();
		 
		 if(logout != null){
			 model.addObject("message","Logged out successfully");
		 }
		 model.setViewName("index");
		 return model;
	 }
}
