package com.rev.controller;

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

import com.rev.bean.Car;
import com.rev.bean.Challenge;
import com.rev.bean.User;
import com.rev.service.CarService;
import com.rev.service.UserService;

import org.apache.log4j.Logger;

@Controller
public class CarController 
{
	@Autowired
	CarService carService;
	
	@Autowired
	UserService userService;
	
	private Logger logger = Logger.getLogger(CarController.class);
	
	
	
	@RequestMapping(value = {"/viewCars", "/boughtCar"})
	public String viewCars(HttpServletRequest request, HttpServletResponse response, 
			ModelMap modelMap,
			HttpSession session)
	{
		List<Car> l = carService.getAllCars();
		
		modelMap.addAttribute("allCars", l);
		
		return "viewCars";
	}
	
	@RequestMapping(value = "/buyCar")
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
	
	@RequestMapping(value = "/sellCar")
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
		tempUser.getCars().remove(tempCar);
		
		userService.updateUser(tempUser);
		
		session.setAttribute("currentUser", tempUser);
		
		List<Car> l = carService.getAllCars();
		modelMap.addAttribute("allCars", l);
		
		return "viewCars";
	}
	
	@RequestMapping(value = "/editCar")
	public ModelAndView editChallenge(HttpServletRequest request, HttpServletResponse response)
	{
		logger.info("/editCar");
		String cId = request.getParameter("cId");
		ModelAndView mav = new ModelAndView("/editCar");
		
		if(cId !=  null)
		{
			int carId = Integer.parseInt(cId);
			Car car = carService.getCarById(carId);
			request.setAttribute("car", car );
			mav.addObject("car", car);
		}else
		{
			request.setAttribute("message", "Error: Car Not Selected");
			mav.addObject("car", new Car());
		}
		return mav;
	}
	
	@RequestMapping(value = "/updateCar", method= RequestMethod.POST)
	public String doUpdateChallenge(@Valid Car car,
			BindingResult bindingResult, ModelMap modelMap,
			HttpSession session){
		logger.info("car");
		Car editCar = carService.getCarById(car.getId());
		if(editCar != null)
		{
			editCar.setCarName(car.getCarName());
			editCar.setAcceleration(car.getAcceleration());
			editCar.setHandling(car.getHandling());
			editCar.setMinLevel(car.getMinLevel());
			editCar.setPrice(car.getPrice());
			editCar.setTopSpeed(car.getTopSpeed());
			carService.updateCar(editCar);
			logger.info("Creating Admin Notify");
			
		}
		
		return "redirect:viewCars";
	}
	

}
