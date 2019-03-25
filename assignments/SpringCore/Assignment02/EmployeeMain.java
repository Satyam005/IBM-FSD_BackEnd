package com.assignment02.spring.core.autowiring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

	public class EmployeeMain {

		public static void main(String[] args) {
			// TODO Auto-generated method stub

			AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans-emp-config.xml");
			
			Employee emp = (Employee) context.getBean("employee");
			emp.printDetails();		
			context.close();
		}
	
}
