//package com.assignments.core.java;
import java.util.Scanner;

public class OddEven {

public static void main(String args[])
{

	System.out.println("Enter the Number you want to check for Odd or Even\n");
		
	int a;
	Scanner op = new Scanner(System.in);
	a = op.nextInt();
	
	if(a%2==0)
	{
		System.out.println( a+ " is an Even Number");
	}
	else
	{
		System.out.println( a+ " is an Odd Number");
	}
	op.close();
}
}