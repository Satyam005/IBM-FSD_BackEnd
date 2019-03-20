package com.example.java.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Field;


public class ReflectionEx {

	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName("com.example.java.reflection.Calculator");
			System.out.println("Class Name: "+c.getName());
			
			System.out.println("\nConstructors: ");
			for(Constructor<?> ctr : c.getConstructors())
				System.out.println(ctr);
			
			System.out.println("\nFields: ");
			for(Field f : c.getDeclaredFields())
				System.out.println(f);
			
			System.out.println("\nMethods");
			for(Method m : c.getDeclaredMethods())
				System.out.println(m);
			
			Constructor<?> cons = c.getConstructor(Integer.class, Integer.class);
			
			Object obj = cons.newInstance(5,10);
			
			Method addMethod = c.getMethod("add");
			Integer res = (Integer) addMethod.invoke(obj);
			System.out.println("\nAddition Result: "+res);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
