package com.assignment04.spring.core.annotation;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class EmployeeMain {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans-annotation-config.xml");
		
		Employee emp = (Employee) context.getBean("employee");
		emp.printDetails();		
		context.close();
	}

}