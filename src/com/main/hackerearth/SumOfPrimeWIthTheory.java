package com.main.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * According to GoldBach Theorem
 * Every even integer greater than 2 can be written as the sum of two primes
 */
public class SumOfPrimeWIthTheory {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in=new java.io.BufferedReader(new InputStreamReader(System.in));
		short noOfTestCase = Short.parseShort(in.readLine());
		int inputData;
		while(noOfTestCase-- > 0) {
			inputData = Integer.parseInt(in.readLine());
			if(inputData>2)
				System.out.println("Deepa");
			else
				System.out.println("Arjit");
		}
		
	}
}
