//package com.assignments.core.java;

import java.util.function.BiFunction;

public class LambdaCalc {

		   public static void main(String args[]) {
		   LambdaCalc lamExp = new LambdaCalc();

		   	   BiFunction<Integer, Integer, Integer> addition = (Integer a, Integer b) -> a + b;
			   BiFunction<Integer, Integer, Integer> subtraction = (Integer a, Integer b) -> a - b;
			   BiFunction<Integer, Integer, Integer> multiplication = (Integer a, Integer b) -> a * b;
			   BiFunction<Integer, Integer, Integer> division = (Integer a, Integer b) -> a / b;			   
			   
			   System.out.println("10 + 5 = " + lamExp.operate(10, 5, addition));
			   System.out.println("10 - 5 = " + lamExp.operate(10, 5, subtraction));
			   System.out.println("10 x 5 = " + lamExp.operate(10, 5, multiplication));
			   System.out.println("10 / 5 = " + lamExp.operate(10, 5, division));
			   
			   
			   
			   
			   //with type declaration
		//      MathOperation addition = (int a, int b) -> a + b;
				
		      //with out type declaration
		//      MathOperation subtraction = (a, b) -> a - b;
				
		      //with return statement along with curly braces
		//      MathOperation multiplication = (int a, int b) -> { return a * b; };
				
		      //without return statement and without curly braces
		 //     MathOperation division = (int a, int b) -> a / b;
				
		 //     System.out.println("10 + 5 = " + lamExp.operate(10, 5, addition));
		 //     System.out.println("10 - 5 = " + lamExp.operate(10, 5, subtraction));
		  //    System.out.println("10 x 5 = " + lamExp.operate(10, 5, multiplication));
		   //   System.out.println("10 / 5 = " + lamExp.operate(10, 5, division));
		      
	
			   }	
		   
		   private int operate(int a, int b, BiFunction<Integer, Integer, Integer>function) {
		      return function.apply(a, b);
		   }

		}