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
import org.springframework.web.servlet.ModelAndView;

import com.rev.bean.Login;
import com.rev.bean.User;
import com.rev.service.UserService;

@Controller
@RequestMapping(value = "/index")
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

	@RequestMapping(method = RequestMethod.POST)
	public String loginProcess(@Valid Login login, BindingResult bindingResult, ModelMap modelMap,
			HttpSession session) {
		ModelAndView mav = null;
		User user = userService.validateUser(login);
		if (null != user) {
			modelMap.addAttribute("user", user);
			return "index";
		} else {
			mav = new ModelAndView("index");
			mav.addObject("message", "Username or Password is wrong!!");
			modelMap.addAttribute("message", "Username or Password is wrong!!");
			return "index";
		}
	}
}
