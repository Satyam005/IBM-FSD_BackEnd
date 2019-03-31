package com.assignment02.spring.core.autowiring;

import java.time.LocalDate;
import java.util.List;

public class Employee {
	
	private int id;
	private String name;
	private LocalDate dob;
	private String designation;
	private double salary;
	private List<String> skills;
	private Address address;
	private boolean fulltime;
	
	Employee(int id, String name, Address address, double salary, LocalDate dob){
		this.id = id;
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.dob = dob;
		
	}

	

	public LocalDate getDob() {
		return dob;
	}



	public void setDob(LocalDate dob) {
		this.dob = dob;
	}



	public String getDesignation() {
		return designation;
	}



	public void setDesignation(String designation) {
		this.designation = designation;
	}



	public List<String> getSkills() {
		return skills;
	}



	public void setSkills(List<String> skills) {
		this.skills = skills;
	}



	public boolean isFulltime() {
		return fulltime;
	}



	public void setFulltime(boolean fulltime) {
		this.fulltime = fulltime;
	}



	public void printDetails() {
		System.out.println("Employee Details");
		System.out.println("Name: "+ this.name);
		System.out.println("DOB: "+ this.getDob());
		System.out.println("Designation: "+ this.getDesignation());
		System.out.println("Salary: "+ this.salary);
		System.out.println("Skills: ");
		for(String skill : this.getSkills())
			System.out.println(skill);
		System.out.println("Address: "+ this.address.city+","+this.address.pin+","+this.address.country);
		System.out.println("Fulltime Employee: "+this.isFulltime());
		
	}
	
}
