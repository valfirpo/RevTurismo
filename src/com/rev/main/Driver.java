package com.rev.main;

import com.rev.bean.JenkinsTest;

public class Driver {
	public static void main(String [] args) {
		JenkinsTest jenks = new JenkinsTest();
		jenks.setOld("balddd");
		jenks.setAge(90000);
		jenks.setButler("Jeffery!");
		
		System.out.println("Jenkins is extremely " + jenks.getOld() + "!" + " Jenkins is " + jenks.getAge()+ " years old!" + " Jenkins is also a " + jenks.getButler());
	}
}
