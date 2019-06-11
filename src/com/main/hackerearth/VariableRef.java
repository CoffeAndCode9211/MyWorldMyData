package com.main.hackerearth;

import java.util.HashSet;
import java.util.Set;

public class VariableRef {
	public static void main(String[] args) {
		Set<Integer> a = new HashSet<>();
		Integer a1 = 12;
		Integer a2 = 15;
		a.add(a1);
		a.add(a2);
		System.out.println(a.size());

		a.remove(a1);
		System.out.println(a.size());

		a2 = 40;
		a.remove(a2);

		System.out.println(a.size());

		// ===========

		String s1 = null;
		s1 += "Hello";
		System.out.println(s1);

		VariableRef aq = new VariableRef("ddd");

	}

	VariableRef() {
		System.out.println("ad");
	}

	VariableRef(String a) {
		System.out.println("adss");
	}

	int a;
	String s;

	{
		System.out.println("a");
		try {
			this.a = Integer.parseInt(s);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	static {
		System.out.println("static");
	}
	
	
	
}
