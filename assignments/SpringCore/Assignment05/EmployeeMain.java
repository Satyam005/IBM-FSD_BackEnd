package com.assignment05.spring.core.javabscnfg;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class EmployeeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfiguration.class);

		Employee emp = (Employee) context.getBean("employee");

		emp.setDesignation("Project Manager");
		emp.setFullTime(true);
		emp.setSalary(87900);

		List<String> skills = new ArrayList<>();
		
		skills.add("JAVA");
		skills.add("Machine Learning");
		emp.setSkills(skills);
		
		emp.printDetails();

		context.registerShutdownHook();
	}

}
