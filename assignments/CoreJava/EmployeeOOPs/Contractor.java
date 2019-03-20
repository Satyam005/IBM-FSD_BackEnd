package com.examples.oops.java;

public class Contractor extends Person {
	static int id;
	private int duration;
	
	Contractor(String name, int age, String gender, int duration){
		super(name,age,gender);
		this.duration = duration;
	}
	
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void getDetails() {
		System.out.println(++id+"\t"+this.getName()+"\t"+this.getAge()+"\t"+this.getGender()+"\t"+this.getDuration());
	}
}