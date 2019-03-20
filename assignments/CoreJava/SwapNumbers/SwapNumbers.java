//package com.assignments.core.java;
import java.util.Scanner;

public class SwapNumbers {

public static void main(String args[])
{

int m,n;
		
		Scanner on = new Scanner(System.in);
       
		System.out.println("Enter First Number");
		m= on.nextInt();
		
		System.out.println("Enter Second Number");
		n= on.nextInt();
	
		System.out.println("\nBefore Swapping the Numbers were \n"+m+" , "+n);
		
	    m = m+n;
        n = m-n;
        m = m-n;
   
   System.out.println("\nAfter Swapping the Numbers are \n" +m+" , " +n);
   on.close();
}
}