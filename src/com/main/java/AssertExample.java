package com.main.java;

public class AssertExample {
	public static void main(String[] args) {
		
		int value = 0;
		assert(value > 0);
		assert(value > 0) : "The value is less than 0";
		int data = 145/value;
		System.out.println(data);
		
	}
}
