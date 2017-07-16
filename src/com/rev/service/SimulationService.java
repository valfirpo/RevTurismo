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
		double latAcc = car.getHandling();
		double topSpeed = car.getTopSpeed();
		Double maxV = 0.0;
		if(radius != 0)
		{	
			maxV = Math.sqrt(latAcc* radius);
			topSpeed = maxV;
		}
		double currentDistance = 0.0;
		double runningTime = 0.0;
		boolean done = false;
		double stepSize = STEP_SIZE;
		logger.info("StepSize: " + stepSize);
		logger.info("Top Speed: " + topSpeed);
		
		
		do{
			if(stepSize + currentDistance > distance)
			{
				done = true;
				stepSize = distance - currentDistance;
			}
			double acc = car.getAcceleration() * (1 - (currentSpeed/topSpeed));
			double time1 = (-currentSpeed + Math.sqrt(Math.pow(currentSpeed, 2) - 2*acc*(-stepSize)));
			double time2 = (-currentSpeed - Math.sqrt(Math.pow(currentSpeed, 2) - 2*acc*(-stepSize)));
			//Figure out which time to use.
			double time = 0.0;
			if(currentSpeed < topSpeed)
			{
				time = Math.max(time1, time2);
			}else
			{
				time = Math.min(time1, time2);
			}
			currentSpeed += acc * time;
			runningTime += time;
			currentDistance += currentSpeed * time;
			logger.info("Acceleration: " + acc);
			logger.info("Current Speed: " + currentSpeed);
			logger.info("Current Time: " + runningTime);
			logger.info("Current Distance: " + currentDistance);
			
			
		}while(!done);
		return runningTime;
	}

}
