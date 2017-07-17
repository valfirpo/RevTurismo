package com.rev.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.rev.bean.Car;
import com.rev.bean.Challenge;
import com.rev.bean.TrackSection;

public class SimulationService {
	private double currentSpeed;
	private final double STEP_SIZE = 0.1;
	private Logger logger = Logger.getLogger(SimulationService.class);
	public double simulateRace(Challenge track, Car car)
	{
		List<TrackSection> sections = track.getSections();
		double runningTime = 0.0;
		currentSpeed = 0.0;
		for(TrackSection section : sections)
		{
			runningTime += simulateSection(section.getCurveRating(), section.getDistance(),car);
			
		}
		return runningTime;
	}
	private double simulateSection(double radius, double distance, Car car){
		return distance/car.getTopSpeed();
	}

}
