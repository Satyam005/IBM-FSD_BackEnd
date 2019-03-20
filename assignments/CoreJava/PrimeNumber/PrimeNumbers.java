package com.assignments.core.java;
import java.util.Scanner;

public class PrimeNumbers {

public static void main(String args[])
{

		System.out.println("Press 1 if you want to  check whether a particular number is Prime or not");
		System.out.println("Press 2 if you want to print the Prime Numbers in a particular range");
		int f;
		Scanner oi = new Scanner(System.in);
		f = oi.nextInt();
		
		switch(f)
		{
		
		case 1:
		 
	    System.out.println("Enter the Number --");
		
		int b,flag=0,v;
		Scanner of = new Scanner(System.in);
		b = of.nextInt();
		
		v=b/2;
	  if(b==1||b==0)
		{
		  System.out.println( b+ "  " + "is neither Prime nor Composite");
		}
	  	
	 else
	 {
	 for(int i=2; i<=v; i++)
	 {  
		if(b%i==0)
			{
			System.out.println( b+"  " + "is NOT a Prime Number");
			flag=1;
			break;
			}
	 }
		
	 if(flag==0)
	 {
			System.out.println( b+" " + "is a Prime Number");
			break;
     }
	 }
	    break;
	
		case 2:
			
		int start,end,j,h,count=0;
		
		Scanner scan = new Scanner(System.in);
	    System.out.print("Enter the Range --\n");	
	    
	    System.out.print("Enter Starting Number : ");
        start = scan.nextInt();
        System.out.print("Enter Ending Number : ");
        end = scan.nextInt();
			
        if(start>end)
        {
        	System.out.println("Invalid Range....Please Enter Correct Range");
        }
        else
        {
		System.out.println("The Prime numbers from " +start+ " till "+end+  " are--");
		for(j=start;j<=end;j++)
		{
		  count=0;
		  for(h=2;h<j;h++)
		  {
			  if(j%h==0)
			  {
				  count++;
				  break;
			  }
		  }
		  if(count==0)
		  {
		   System.out.println(j);
	      }
		}
		break;
		}
        oi.close();
        }
}
}