package com.rev.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rev.bean.Login;
import com.rev.bean.User;
import com.rev.service.UserService;

@Controller
@RequestMapping(value="/index")
public class LoginController {
  @Autowired
  UserService userService;
  
  
  @RequestMapping(method = RequestMethod.GET)
  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
	 // System.out.println("hello");
    ModelAndView mav = new ModelAndView("index");
    mav.addObject("login", new Login());
    return mav;
  }

//  @RequestMapping(value="/home",method = RequestMethod.POST)
//  @ResponseBody
//  public String home(){
//	  return "home";
//  }
//  @RequestMapping(value="/index",method = RequestMethod.POST)
//  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
//  @ModelAttribute("login") Login login) {
//	 System.out.println("some info");
//    ModelAndView mav = null;
//    User user = userService.validateUser(login);
//    if (null != user) {
//    mav = new ModelAndView("home");
//    mav.addObject("firstname", user.getFirstname());
//    } else {
//    mav = new ModelAndView("index");
//    mav.addObject("message", "Username or Password is wrong!!");
//    }
//    return mav;
//  }
  
  @RequestMapping(method = RequestMethod.POST)
	public String doLogin(@Valid Login login, BindingResult bindingResult, ModelMap modelMap, HttpSession session){
		
		System.out.println("This was a post request");
		if (bindingResult.hasErrors()){
			
			return "index";
			
		}
		User authUser = userService.validateUser(login);
		if (authUser != null) {
			
			System.out.println(login.getUsername());
			modelMap.addAttribute("user", login);
			session.setAttribute("alsoUser", login);
			return "index";
			
		}
		else{
			modelMap.addAttribute("errorMessage", "Username/password incorrect");
			return "index";
		}
	}
  
}
