package com.examples.core.java;

public class Employee{
	static int id;
	String name;
	int age;
	String department;
	double salary;

   Employee(String name,int age,String department,double salary)
   {        id++;
            this.name=name;
            this.age=age;
            this.department=department;
            this.salary=salary;
   }
public void getEmployeeDetails() {
	System.out.println(id+"\t"+name+"\t"+age+"\t"+department+"\t"+salary);
}
}