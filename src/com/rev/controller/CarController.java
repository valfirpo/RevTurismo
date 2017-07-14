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
import com.rev.service.UserService;

@Controller
@RequestMapping(value = "/")
public class CarController 
{
	@Autowired
	CarService carService;
	
	@Autowired
	UserService userService;
	
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
		Double tempCash;
		Car tempCar = carService.getCarById(Integer.parseInt(id));
		
		tempCash = tempUser.getCash();
		tempCash -= tempCar.getPrice();
		tempUser.setCash(tempCash);
		tempUser.getCars().add(tempCar);
		
		userService.updateUser(tempUser);
		
		session.setAttribute("currentUser", tempUser);
		
		List<Car> l = carService.getAllCars();
		modelMap.addAttribute("allCars", l);
		
		return "viewCars";
	}
	
	@RequestMapping(value = "sellCar")
	public String sellCar(HttpServletRequest request, HttpServletResponse response, 
			ModelMap modelMap,
			HttpSession session)
	{
		String id = request.getParameter("carId");
		User tempUser = (User) session.getAttribute("currentUser");
		Double tempCash;
		Car tempCar = carService.getCarById(Integer.parseInt(id));
		
		tempCash = tempUser.getCash();
		tempCash += (tempCar.getPrice() * 0.75);
		tempUser.setCash(tempCash);
		//tempUser.getCars().add(tempCar);
		tempUser.getCars().remove(tempCar);
		
		userService.updateUser(tempUser);
		
		session.setAttribute("currentUser", tempUser);
		
		List<Car> l = carService.getAllCars();
		modelMap.addAttribute("allCars", l);
		
		return "viewCars";
	}

}
