package com.assignments.core.java;

public class EmployeeManager {

	static int index;
		public static void main(String[] args) {
		// Declaring employee array
		Employee empList[] = new Employee[10];
		
		//Adding employees to employee array
		empList[0] = new Employee("Jiren",37,"Male","CEO",99935000);
		empList[1] = new Employee("Goku",37,"Male","MD",99934499);
		empList[2] = new Employee("Vegeta",38,"Male","Sales",83337000);
		empList[3] = new Employee("Gohan",22,"Male","Tester",81405000);
		
		//Printing employees
		System.out.println("ID\tNAME\tAGE\tGENDER\tDEPARTMENT\tSALARY");
		System.out.println("______________________________________________________\n");
		for(Employee emp : empList) {
			if(emp == null)
				continue;
			System.out.println(emp.getEmpID()+"\t"+emp.getName()+"\t"+emp.getAge()+"\t"+emp.getGender()+"\t"+emp.getDepartment()+"\t\t"+emp.getSalary());
		}
		
		//Deleting employee with EmpID = 2
		for(int i = 0; i<empList.length;i++) {
			if(empList[i] != null && empList[i].getEmpID() == 3)
				empList[i] = null;
		}
		
		//Printing updated List
		System.out.println("\nAFTER DELETING");
		System.out.println("_______________\n");
		for(Employee emp : empList) {
			if(emp == null)
				continue;
			System.out.println(emp.getEmpID()+"\t"+emp.getName()+"\t"+emp.getAge()+"\t"+emp.getGender()+"\t"+emp.getDepartment()+"\t\t"+emp.getSalary());
		}
		
		//Editing Employee detail
		for(int i = 0; i<empList.length;i++) {
			if(empList[i] != null && empList[i].getEmpID() == 1)
				empList[i].setSalary(81405000);;
		}
		
		//Printing updated List
				System.out.println("\nAFTER EDITING");
				System.out.println("_______________\n");
				for(Employee emp : empList) {
					if(emp == null)
						continue;
					System.out.println(emp.getEmpID()+"\t"+emp.getName()+"\t"+emp.getAge()+"\t"+emp.getGender()+"\t"+emp.getDepartment()+"\t\t"+emp.getSalary());
				}
	}
	

}
