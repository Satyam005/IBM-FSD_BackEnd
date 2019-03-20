package com.examples.oops.java;

public class EmployeeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("--------------------Employee Details--------------------");
		System.out.println();
		System.out.println("ID\tName\tAge\tGender\tDepartment\tSalary");
		System.out.println("--------------------------------------------------------");
		Employee gohan = new Employee("Gohan",24,"Male","Finance\t",495000);
		gohan.setSalary(665000);
		gohan.getDetails();
		gohan.appraise();
		
		Employee vegeta = new Employee("Vegeta",27,"Male","Development",435000);
		vegeta.getDetails();
			
		System.out.println();
		System.out.println("--------------------Contractor Details--------------------");
		System.out.println();
		System.out.println("ID\tName\tAge\tGender\tDuration");
		System.out.println("----------------------------------------");
		Contractor goku = new Contractor("Goku",28,"Male",6);
		goku.getDetails();
	}
}