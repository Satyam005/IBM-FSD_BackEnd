package com.assignment3.db.employee;

public class Employee<T extends Number>{

	private String name;
	private int age;
	private String gender;
	private String department;
	private T salary;
	private int empID;

	public Employee() {

	}

	public Employee(String name, int age, String gender, String department, T salary) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.department = department;
		this.salary = salary;
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

	public T getSalary() {
		return salary;
	}

	public void setSalary(T salary) {
		this.salary = salary;
	}
}