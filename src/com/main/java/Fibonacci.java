package com.main.java;

import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args) {
		int limit = new Scanner(System.in).nextInt();
		for(int i=1; i <= limit; i++){
			//System.out.println(fibonacci(i));
			System.out.println(forLopppFib(i));
		}
		
	}
	
	public static int fibonacci(int i){
		if(i == 1 || i == 2){
			return 1;
		}
		
		return fibonacci(i-1) + fibonacci(i-2);
	}
	
	public static int forLopppFib(int index){
		
		int a=1, b = 1, c=1;
		for(int i=3; i <=index; i++){
			c = a + b;
			a =b;
			b = c;
			
		}
		return c;
	}
	
	
	
}
