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
import com.rev.bean.User;
import com.rev.service.UserService;

@Controller
@RequestMapping(value="/")
public class LogoutController {
	
	 @Autowired
	  UserService userService;

	 @RequestMapping(value="logout")
		public String doLogout(@Valid Login login, BindingResult bindingResult, 
												ModelMap modelMap,
												HttpSession session)
												 {
		if(bindingResult.hasErrors()){
			session.invalidate();
			return "index";
		}else{
			session.invalidate();
			return "index";
		}
		
//		 User validUser = userService.validateUser(login);
//		 
//		 if(validUser == null){
//			 System.out.println(login.getUsername());
//			  modelMap.addAttribute("user",login);
//			  session.setAttribute("user", login);
//			  session.getAttribute("user");
//			  return "index";
//		 }
		
	}		 					   
}
