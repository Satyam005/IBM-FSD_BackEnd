//package com.example.java.datetime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
public class DateTimeEx {

	public static void main(String[] args) {
		
		LocalDateTime today = LocalDateTime.now();
		
		System.out.println(today);
		
		Instant todayIns = Instant.now();
		
		System.out.println(todayIns);
	}

}