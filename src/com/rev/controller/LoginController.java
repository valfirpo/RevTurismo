package com.rev.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rev.bean.Login;
import com.rev.bean.Password;
import com.rev.bean.User;
import com.rev.service.UserService;

@Controller
@RequestMapping(value="/index")
public class LoginController {
  @Autowired
  UserService userService;
  
  
  @RequestMapping(method = RequestMethod.GET)
  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("index");
    mav.addObject("login", new Login());
    return mav;
  }
  
  
//  @Autowired
//  public Password passwordValidator;
  
  @RequestMapping(method = RequestMethod.POST)
	public ModelAndView doLogin(@Valid Login login, BindingResult bindingResult,
			@RequestParam(value="errorMessage",required=false)String errorMessage,
											ModelMap modelMap,
											HttpSession session){
	  
  
	//passwordValidator.validate(login, bindingResult);										 {
	  //session.getAttribute("user").equals(null);
	  User validUser = userService.validateUser(login,bindingResult);
	
	  if(validUser == null){
		  session.removeAttribute("user");
		  modelMap.addAttribute("invalidUser",login);
		  modelMap.addAttribute("errorMessage",login);
		  session.setAttribute("errorMessage", login);
		  //session.invalidate();
		  System.out.println("hello where are we");
		  //session.removeAttribute("errorMessage");
		return new ModelAndView("redirect:index");
	}
//	  if(errorMessage != null) {
//		  modelMap.addAttribute("user",login);
//		  session.setAttribute("user", login);
//	  }
	 
	 
		  System.out.println(login.getUsername());
		  modelMap.addAttribute("user",login);
		  session.setAttribute("user", login);
		  System.out.println("are you here??");
		  session.setAttribute("currentUser", validUser);
		 
	 
	 return new ModelAndView("redirect:index");
	 
	}
  }

  

