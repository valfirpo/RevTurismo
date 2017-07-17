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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter;
import com.rev.bean.Login;
import com.rev.bean.Password;
import com.rev.bean.User;
import com.rev.service.UserService;

@Controller
@RequestMapping(value="/createAccount")
public class RegistrationController  {
	
@Autowired
  public UserService userService;
  @RequestMapping(method = RequestMethod.GET)
  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("createAccount");
    mav.addObject("user", new User());
    return mav;
  }
  
  @Autowired
  public Password passwordValidator;
  
  @RequestMapping(method = RequestMethod.POST)
  public ModelAndView onSubmit(@ModelAttribute("user") User user,HttpSession session,
		  				BindingResult bindingResult){
	  //Object password = user.getPassword();
	  //String confirmPassword = user.getConfirmPassword();
	  
	  passwordValidator.validate(user, bindingResult);
	  if(bindingResult.hasErrors()){
		  return new ModelAndView("createAccount");
	  }
	  
	  userService.register(user);
	  session.setAttribute("currentUser", user);
	  session.setAttribute("user", user);
	  session.setAttribute("password", user.getPassword());
	  session.setAttribute("confirmPassword", user.getConfirmPassword());
	  session.invalidate();
	  return new ModelAndView("redirect:index");
  }
//  public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response,
//  @ModelAttribute("user") User user,Object command,
//   HttpSession session) {
//  userService.register(user);
//  
//  user = (User) command;
//  session.setAttribute("currentUser", user);
//  session.setAttribute("user", user);
//  session.setAttribute("password", user.getPassword());
//  session.setAttribute("confirmPassword", user.getConfirmPassword());
//
//  return new ModelAndView("index", "user", user);
//  
//  }
  
}
