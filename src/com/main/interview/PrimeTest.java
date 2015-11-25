package com.main.interview;

import java.util.Scanner;

public class PrimeTest {
	public static void main(String[] args) {
		int number = new Scanner(System.in).nextInt(); 
		System.out.println(isPrime(number));

		System.out.println(isPrimeOrNot(number));
	}

	public static boolean isPrime(int number) { 
		int sqrt = (int) Math.sqrt(number) + 1;
		System.out.println(sqrt);
		for (int i = 2; i < sqrt; i++) { 
			if (number % i == 0) { 
				// number is perfectly divisible - no prime 
				return false; 
			} 
		} 
		return true; 
	}

	//  if you square ANY prime number bigger then 3, then subtract 1, the answer always divides by 24!
	// all prime numbers can be written as (6n+1) or (6n-1).
	
	
	public static String isPrimeOrNot(int num) {
		if (num < 0) { 
			return "not valid"; 
		} 
		if (num == 0 || num == 1) { 
			return "not prime";
		} 
		if (num == 2 || num == 3) {
			return "prime number"; 
		} 
		if (( (num * num) - 1) % 24 == 0) {
			return "prime"; 
		} else { 
			return "not prime";
		} 
	}
}
