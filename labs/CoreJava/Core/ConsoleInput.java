//package com.example.core.java;

import java.util.Scanner;

public class ConsoleInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Name");
		String name = sc.nextLine();
		System.out.println("Enter Age");
		int age = sc.nextInt();

		System.out.println("Name: "+ name);
		System.out.println("Age: "+ age);
	}

}