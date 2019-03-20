package com.assignments.core.java;

public class Employee {
	static int id;
	int empID;
	private String name;
	private int age;
	private String gender;
	private String department;
	private int salary;
	
	Employee(String name, int age, String gender, String department, int salary){
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.department = department;
		this.salary = salary;
		this.empID = ++id;
	}
	
	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}