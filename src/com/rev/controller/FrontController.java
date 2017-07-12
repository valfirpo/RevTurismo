package com.rev.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rev.bean.Login;


@Controller
@RequestMapping(value="/")
public class FrontController {

//  @Autowired
//  UserService userService;
	  
	  
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
  

 
  
//  @RequestMapping(value="logout",method=RequestMethod.GET)
//  public ModelAndView logout(HttpServletRequest request, HttpServletResponse response){
//	  ModelAndView view = new ModelAndView("index");
//	  view.addObject("login",new Login());
//	  return view;
//  }
  
}
