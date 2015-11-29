package com.main.java;

public class LeftShiftExample {
	public static void main(String[] args) {	
		byte a = 64, b = 0;
		int c = 0;
		System.out.println("a bit count: "+Integer.toBinaryString(a));
		System.out.println("b bit count: "+Integer.toBinaryString(b));
		System.out.println("c bit count: "+Integer.toBinaryString(c));
		c = a << 2;
		System.out.println("c bit count (a << 2) : "+Integer.toBinaryString(c));
		b = (byte) (a << 2);
		System.out.println("b bit count: "+Integer.toBinaryString(b));
		System.out.println(a+" : "+b+" : "+c);
	}
}
