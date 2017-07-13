package com.rev.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rev.bean.Car;
import com.rev.service.CarService;

@Controller
@RequestMapping(value = "/")
public class CarController 
{
	@Autowired
	CarService carService;
	
	@RequestMapping(value = "viewCars")
	public String viewCars(HttpServletRequest request, HttpServletResponse response, 
			ModelMap modelMap,
			HttpSession session)
	{
		List<Car> l = carService.getAllCars();
		
		modelMap.addAttribute("allCars", l);
		
		return "viewCars";
	}

}
