package com.rev.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rev.bean.Login;
import com.rev.bean.Password;
import com.rev.bean.User;
import com.rev.service.UserService;


@Controller
@RequestMapping(value="/forgotPass")
public class ForgotPasswordController {
		
	  @Autowired
	  public UserService userService;

	  @Autowired
	  public Password passwordValidator;
	  
	  @RequestMapping(method = RequestMethod.GET)
	  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("index");
	    mav.addObject("user", new Login());
	    return mav;
	  }
	  
	  @RequestMapping(method=RequestMethod.POST)
	  public String forgotPassword(@Valid User user,HttpSession session,BindingResult bindingResult,
			  					   ModelMap modelMap){
		  Login login= new Login();
		  System.out.println("This was a forgot password request");
		  
		  if(bindingResult.hasErrors()){
			  System.out.println("Binding Result error!");
			  return "/forgotPass";
		  }
		 
		  
		  modelMap.addAttribute("errorMessage");
		  modelMap.addAttribute("currentUser",login);
		 System.out.println("user before" + user.getUsername());
		  modelMap.addAttribute("user",login);
		  modelMap.addAttribute("username",login.getUsername());
		  modelMap.addAttribute("password",user);
		  modelMap.addAttribute("confirmPassword",user);
		  userService.checkUser(user);
		  
		  session.setAttribute("currentUser", login);
		  session.setAttribute("user", login);
		  session.setAttribute("errorMessage", user);
		  session.setAttribute("username", user);
		  session.setAttribute("password", user);
		  session.setAttribute("confirmPassword", login);

		  System.out.println("user:" + user.getUsername());
		  System.out.println("password: " + user.getPassword());
		  System.out.println("confirmPassword: " + user.getConfirmPassword());
		 
		  
		  
		 
		  System.out.println("About to check user");
		  
		  if(!(user.getPassword().equals(user.getConfirmPassword()) || 
				  user.getUsername().equals(null))){

			  System.out.println("password: " + user.getPassword().toString());
			  System.out.println("confirmPassword: " + user.getConfirmPassword().toString());
		 // session.invalidate();
		  session.removeAttribute("user");
		  session.removeAttribute("currentUser");
		  System.out.println("Passwords do NOT match!!");
		  return "redirect:index";
		  }
		  
		  user.setNewPassword(user.getPassword());
		  System.out.println("New Password: " + user.getNewPassword());
		  System.out.println("Getting Ready to update Password!");
		  userService.updatePassword(user);
		  System.out.println("Password has been reset!");
		  session.removeAttribute("errorMessage");
		  session.invalidate();
		return "redirect:passwordReset";
		  
	  }
	  
}



