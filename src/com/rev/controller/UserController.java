package com.rev.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

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

import com.rev.bean.Password;
import com.rev.bean.User;
import com.rev.service.UserService;

@Controller
public class UserController 
{
	@Autowired
	 UserService userService;
	
	@Autowired
	public Password passwordValidator;

	@RequestMapping(value="/viewUsers")
	public String viewUsers(HttpServletRequest request, HttpServletResponse response, 
			ModelMap modelMap,
			HttpSession session)
	{
		
		List<User> l = userService.getAllUsers();
		
		modelMap.addAttribute("allUsers",l);
		
		return "viewUsers";
	}
	
	@RequestMapping(value="/viewSubAdmin")
	public String viewSubAdmin(HttpServletRequest request, HttpServletResponse response, 
			ModelMap modelMap,
			HttpSession session)
	{
		List<User> l = userService.getAllSubAdmin();
		
		modelMap.addAttribute("allSubAdmin", l);
		
		return "viewSubAdmin";
	}
	
	@RequestMapping(value="/updateAccount")
	public String updateUser(@ModelAttribute("user") User user,
			BindingResult bindingResult,
			HttpServletRequest request,
			HttpServletResponse response, 
			ModelMap modelMap,
			HttpSession session)
	{
		if(bindingResult.hasErrors()){
			return "updateAccount";
		}
		return "updateAccount";
	}
	
	@RequestMapping(value="/updateAccount", method = RequestMethod.POST)
	public String updateUserFunctionality(@Valid User user,
			BindingResult bindingResult,
			ModelMap modelMap,
			HttpSession session)
	{
		
		if(user.getUsername()!=null){
		User currentUser = (User) session.getAttribute("currentUser");
		currentUser.setPassword(user.getPassword());
		currentUser.setFirstname(user.getFirstname());
		currentUser.setLastname(user.getLastname());
		currentUser.setEmail(user.getEmail());
		userService.updateUser(currentUser);
		modelMap.addAttribute("user", currentUser);
		session.setAttribute("currentUser", currentUser);
		session.setAttribute("user", currentUser);
		}
		return "redirect:controlPanel";
	}
	
	@RequestMapping(value="/createSubAdminAccount")
	public String createSubAdminAccount(@ModelAttribute("user") User user,
			BindingResult bindingResult,
			HttpServletRequest request,
			HttpServletResponse response, 
			ModelMap modelMap,
			HttpSession session)
	{
		if(bindingResult.hasErrors())
		{
			return "createSubAdminAccount";
		}
		return "createSubAdminAccount";
	}
	
	@RequestMapping(value="/createSubAdminAccount" , method = RequestMethod.POST)
	public ModelAndView registerSubAdminAccount(@ModelAttribute("user") User user,
			BindingResult bindingResult,
			HttpServletRequest request,
			HttpServletResponse response, 
			ModelMap modelMap,
			HttpSession session)
	{
		passwordValidator.validate(user, bindingResult);
		if(bindingResult.hasErrors())
		{
			System.out.println("binding result error");
			return new ModelAndView("createAccount");
		}
		
		System.out.println(user.toString());
		user.setRole(2);
		user.setUserRole("SUBADMIN");
		userService.register(user);
		
		return new ModelAndView("redirect:createSubAdminAccount");
	}
}
