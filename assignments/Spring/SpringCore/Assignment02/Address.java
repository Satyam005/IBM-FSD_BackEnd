package com.assignment02.spring.core.autowiring;

public class Address {

	String city;
	int pin;
	String country;
	
	Address(String city, int pin, String country){
		this.city = city;
		this.pin = pin;
		this.country= country;	
	}
	}
