package com.examples.core.java;

public class EmployeeExample {

	 public static void main(String[] args)
	 {
		    System.out.println("----------EMPLOYEE DETAILS------------");
			System.out.println();
			System.out.println("ID\tNAME\tAGE\tDEPARTMENT\tSALARY");
			System.out.println("----------------------------------------------");
		 
			Employee goku = new Employee("GOKU",21,"Finance\t",81000);
				 goku.getEmployeeDetails();
				 
	        Employee vegeta = new Employee("VEGETA",21,"Marketing",75000);
				 vegeta.getEmployeeDetails();
	 }

	
}
