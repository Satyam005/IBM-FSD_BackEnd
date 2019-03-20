package com.examples.oops.java;

public class Employee extends Person implements Appraisable {
	private static int id;
	private String department;
	private int salary;
	
	 Employee(String name, int age, String gender ,String department, int salary){
		 super(name,age,gender);
		id++;
		this.department = department;
		this.salary = salary;
	}
	public void appraise() {
		System.out.println("\n"+this.getName()+" Appraised\n");
	}
	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Employee.id = id;
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

	public void getDetails() {
		System.out.println(id+"\t"+this.getName()+"\t"+this.getAge()+"\t"+this.getGender()+"\t"+department+"\t"+salary);
	}
}