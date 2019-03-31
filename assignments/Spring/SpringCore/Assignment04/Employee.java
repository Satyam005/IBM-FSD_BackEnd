package com.assignment04.spring.core.annotation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	@Value(value="1")
	private int id;
	@Value(value="Goku")
	private String name;
	@Value(value="Project Manager")
	private String designation;
	@Value(value="78900")
	private double salary;
	private List<String> skills;
	
	@Autowired
	Address address;
	private boolean fulltime;
	
	Employee(){}

	public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public double getSalary() {
		return salary;
	}
	
	
	public void setSalary(double salary) {
		this.salary = salary;
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
		System.out.println("Designation: "+ this.getDesignation());
		System.out.println("Salary: "+ this.salary);
		System.out.println("Skills: ");
//		for(String skill : this.getSkills())
//			System.out.println(skill);
		System.out.println("Address: "+ this.address.getCity()+","+this.address.getPin()+","+this.address.getCountry());
		System.out.println("Fulltime Employee: "+this.isFulltime());
		
	}
	
}