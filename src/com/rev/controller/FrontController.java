package com.rev.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rev.bean.User;
import com.rev.service.UserService;


@Controller
@RequestMapping(value="/")
public class FrontController {

  @Autowired
  UserService userService;
	  
	  
  @RequestMapping(value="controlPanel")
  public String controlPaneln(HttpServletRequest request, HttpServletResponse response) {
    return "controlPanel";
  }
  
  @RequestMapping(value="viewCars")
  public String viewCars(HttpServletRequest request, HttpServletResponse response) {
    return "viewCars";
  }
  @RequestMapping(value="viewChallenges")
  public String viewChallenges(HttpServletRequest request, HttpServletResponse response) {
    return "viewChallenges";
  }
  
}
