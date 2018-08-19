package com.main.java;

import static java.lang.System.out;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


class DemoReflection {
	private String test1 = "Hello";
	static{
		System.out.println("Static Block Called");
	}
	public String readData(){
		return test1;
	}
	private String readPrivateData(){
		return test1;
	}
}
public class ReflectionMain {

	public static void main(String... args1) {
		try {
			Class<?> c = Class.forName("com.main.reflection.DemoReflection");
			out.format("Class:%n  %s%n%n", c.getCanonicalName());
			Package p = c.getPackage();
			out.format("Package:%n  %s%n%n", (p != null ? p.getName() : "-- No Package --"));
			
			// Get nConstructors
			Constructor[] cons = c.getConstructors();
			out.format("%nConstructors:%n  %n");
			for(int i=0; i < cons.length; i++ ){
				out.println(cons[i].getName());
			}
			
			// Get Fields
			Field[] fields = c.getFields();
			out.format("%nFields:%n  %n");
			for(int i=0; i < fields.length; i++ ){
				out.println(fields[i].getName());
			}
			
			// Get methods
			Method[] methods = c.getMethods();
			out.format("%nMethods:%n  %n");
			for(int i=0; i < methods.length; i++ ){
				System.out.println(methods[i].getName());
			}
				
		} catch (ClassNotFoundException x) {
			x.printStackTrace();
		}
	}
}
