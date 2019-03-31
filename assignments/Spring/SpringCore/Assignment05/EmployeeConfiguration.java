package com.assignment05.spring.core.javabscnfg;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfiguration {
	
	@Bean
	public Employee employee() {
		return new Employee(1, "Goku", address(),dob());
	}
	
	@Bean
	public Address address() {
		return new Address("Meerut",250001,"India");
	}
	
	@Bean
	public LocalDate dob() {
		LocalDate date = LocalDate.parse("1994-02-12");
		return date;
	}
}
