package com.rev.bean;

public class JenkinsTest {
	private String old;
	private String butler;
	private int age;
	
	
	public JenkinsTest() {
		super();
	}
	public String getOld() {
		return old;
	}
	public void setOld(String old) {
		this.old = old;
	}
	public String getButler() {
		return butler;
	}
	public void setButler(String butler) {
		this.butler = butler;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "JenkinsTest [old=" + old + ", butler=" + butler + ", age=" + age + "]";
	}
	
	
}
