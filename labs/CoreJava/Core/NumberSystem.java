//package com.assignments.core.java;
import java.util.Scanner;

public class NumberSystem {

public static void main(String args[])
{
	int p;
	
   Scanner c = new Scanner(System.in);
   
   System.out.println("Enter 1 for finding whether a number is Even or Odd ");
   System.out.println("Enter 2 to check whether a number is Prime or Not");
   System.out.println("Enter 3 to Swap two numbers");
   p= c.nextInt();
   
   switch(p){
	
	case 1:
	
	System.out.println("Enter the number");
		
	int a;
	Scanner op = new Scanner(System.in);
	a = op.nextInt();
	
	if(a%2==0)
	{
		System.out.println( a+ " is an even number");
	}
	else
	{
		System.out.println( a+ " is an odd number");
	}
       break;
		
	case 2:
		
		System.out.println("Press 1 if you want to  check whether a particular number is Prime or not");
		System.out.println("Press 2 if you want to print the Prime numbers in a particular range");
		int f;
		Scanner oi = new Scanner(System.in);
		f = oi.nextInt();
		
		switch(f)
		{
		
		case 1:
		 
	    System.out.println("Enter the number");
		
		int b,flag=0,v;
		Scanner of = new Scanner(System.in);
		b = of.nextInt();
		
		v=b/2;
	  if(b==1||b==0)
		{
		  System.out.println( b+ "  " + "is neither prime nor composite");
		}
	  	
	 else
	 {
	 for(int i=2; i<=v; i++)
	 {  
		if(b%i==0)
			{
			System.out.println( b+"  " + "is NOT a Prime number");
			flag=1;
			break;
			}
	 }
		
	 if(flag==0)
	 {
			System.out.println( b+" " + "is a Prime number");
			break;
     }
	 }
	    break;
	
		case 2:
			
		int s,start,end,j,h,count=0;
		
		Scanner scan = new Scanner(System.in);
	    System.out.print("Enter the Range :\n");	
	    
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
	//	Scanner re = new Scanner(System.in);
	//	s = re.nextInt();
		
	/*	if(start==1||start==0&&end==1||end==0)
		{
			System.out.println("There are no Prime Numbers");
			break;
		}
		if(start==2&&end==2)
		{
			System.out.println("Prime numbers till this number is " +start+ " only");
			break;
		}
	*/
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
        }
		break;	
	
	case 3:
	
		int m,n;
		
		Scanner on = new Scanner(System.in);
       
		System.out.println("Enter first number");
		m= on.nextInt();
		
		System.out.println("Enter second number");
		n= on.nextInt();
	
		System.out.println("Before swapping the numbers were "+m+" , "+n);
		
	    m = m+n;
        n = m-n;
        m = m-n;
   
   System.out.println("After swapping the numbers are " +m+" , " +n);
   
       break;
   
   default:
	   System.out.println("Wrong Choice, please enter right choice");
       break;
}
}
}