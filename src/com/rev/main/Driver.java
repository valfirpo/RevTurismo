package com.rev.main;

import com.rev.bean.JenkinsTest;

public class Driver {
	public static void main(String [] args) {
		JenkinsTest jenks = new JenkinsTest();
		jenks.setOld("old");
		jenks.setAge(90000);
		jenks.setButler("pimp!");
		
		System.out.println("Jenkins is extremely " + jenks.getOld() + "!" + " Jenkins is " + jenks.getAge()+ " years old!" + " Jenkins is also a " + jenks.getButler());
	}
}
