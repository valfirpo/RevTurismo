package com.rev.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

import com.rev.bean.AdminNotify;
import com.rev.service.AdminService;

@Controller
@RequestMapping(value="createAdminNotifications")
public class AdminNotificationsController {

	@Autowired
	AdminService adminService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView createNotifcations(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView("/createAdminNotifications");
	    mav.addObject("admin", new AdminNotify());
	    
	    
	   // System.out.println("I found the page!");
	    return mav;
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView getAdminNotifications(@Valid AdminNotify admin,HttpSession sesison,
											  ModelMap modelMap,
											  BindingResult bindingResult,
											  HttpSession session){
		System.out.println("Waiting for content...");
		if(bindingResult.hasErrors()){
			System.out.println("Binding Result error!");
			return new ModelAndView("createNotifications");
		}
		
		
		modelMap.addAttribute("admin",admin);
		modelMap.addAttribute("content",admin);
		session.setAttribute("content", admin);
		session.setAttribute("admin", admin);
		System.out.println("admin: " + admin.getActive());
		System.out.println("content: " + admin.getContent());
		adminService.createNotification(admin);
		
		List<AdminNotify> notes = getNotifications();
	    modelMap.addAttribute("notes",notes);
		
		
	    return new ModelAndView("index");
		
		//return new ModelAndView("index");	
	}
	private	List<AdminNotify> getNotifications() {
		List<AdminNotify> notes = new ArrayList<>();
		notes = adminService.getAllNotifications();
		
//		Collections.sort(l);
//		AdminNotify note = new AdminNotify();
//		note.getContent().toString();
//		notes.add(note);
//		
		for(AdminNotify l : notes)
		{
			
			System.out.println(l.getContent());
		}
		return notes;	
	}
}
