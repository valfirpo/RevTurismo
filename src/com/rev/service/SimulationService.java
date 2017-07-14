package com.rev.service;

import java.util.List;

import com.rev.bean.Car;
import com.rev.bean.Challenge;
import com.rev.bean.TrackSection;

public class SimulationService {
	private double currentSpeed;
	private final double STEP_SIZE = 0.1;
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
		double maxV = Math.sqrt(latAcc * radius);
		if(maxV < topSpeed)
		{
			topSpeed = maxV;
		}
		double currentDistance = 0.0;
		double runningTime = 0.0;
		boolean done = false;
		double stepSize = STEP_SIZE;
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
			if(currentSpeed < maxV)
			{
				
			}
			Math.max(time1, time2);
			double time = 0.0;
			currentSpeed += acc * time;
			runningTime += time;
			
			
		}while(!done);
		return runningTime;
	}

}
