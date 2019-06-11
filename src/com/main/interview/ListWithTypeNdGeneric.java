package com.main.interview;

import java.util.ArrayList;
import java.util.List;

public class ListWithTypeNdGeneric {
	public static void main(String[] args) {

		List<Integer> a = new ArrayList<>();
		a.add(10);
		a.add(20);
		
		
		List b = new ArrayList<>();
		
		b.add(30);
		b.add("test");
		b.add(new ListWithTypeNdGeneric());
		
		
		List<Object> c = new ArrayList<>();
		c.add(false);
		a.addAll(b);
		//a.addAll(c);
		System.out.println(a);
		
	}
}
