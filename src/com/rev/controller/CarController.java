package com.rev.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rev.bean.Car;
import com.rev.bean.User;
import com.rev.service.CarService;

@Controller
@RequestMapping(value = "/")
public class CarController 
{
	@Autowired
	CarService carService;
	
	@RequestMapping(value = {"viewCars", "boughtCar"})
	public String viewCars(HttpServletRequest request, HttpServletResponse response, 
			ModelMap modelMap,
			HttpSession session)
	{
		List<Car> l = carService.getAllCars();
		
		modelMap.addAttribute("allCars", l);
		
		return "viewCars";
	}
	
	@RequestMapping(value = "buyCar")
	public String buyCar(HttpServletRequest request, HttpServletResponse response, 
			ModelMap modelMap,
			HttpSession session)
	{
		String id = request.getParameter("carId");
		User tempUser = (User) session.getAttribute("currentUser");
		Car teampCar = carService.getCarById(Integer.parseInt(id));
		
		tempUser.getCars().add(teampCar);
		
		session.setAttribute("currentUser", tempUser);
		List<Car> l = carService.getAllCars();
		
		modelMap.addAttribute("allCars", l);
		
		return "viewCars";
	}

}
