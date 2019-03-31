package com.assignment05.spring.core.javabscnfg;

import java.time.LocalDate;
import java.util.List;

public class Employee {

	int id;
	String name;
	LocalDate dob;
	String designation;
	double salary;
	List<String> skills;
	boolean fullTime;
	Address address;
	
	public Employee() {
		
	}
	
	public Employee(int id, String name, Address address, LocalDate dob) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.dob = dob;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public boolean isFullTime() {
		return fullTime;
	}

	public void setFullTime(boolean fullTime) {
		this.fullTime = fullTime;
	}
	
	public void printDetails() {
		System.out.println("Employee Details");
		System.out.println("Name: "+ this.name);
		System.out.println("DOB: "+ this.dob);
		System.out.println("Designation: "+ this.getDesignation());
		System.out.println("Salary: "+ this.salary);
		System.out.println("Skills: ");
		for(String skill : this.getSkills())
			System.out.println(skill);
		System.out.println("Address: "+ this.address.city+","+this.address.pin+","+this.address.country);
		System.out.println("Fulltime Employee: "+this.isFullTime());
		
	}
}
