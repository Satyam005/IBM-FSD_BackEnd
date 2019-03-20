package com.example.java.reflection;

public class Calculator {

	private int first;
	private int second;
	
	public Calculator() {
		System.out.println("Default constructor");
	}
	public Calculator(Integer first, Integer second) {
		this.first = first;
		this.second = second;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}
	
	public int add()
	{
		return first + second;
	}
	public int sub()
	{
		return first - second;
	}
	public int mul()
	{
		return first * second;
	}
	public double div()
	{
		return first / second;
	}
}