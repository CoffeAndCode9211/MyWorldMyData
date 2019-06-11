package com.main.hackerearth;

import java.util.HashSet;

public class HashCodeNdEquals {
	public String name;

	@Override
	public int hashCode() {
		return 31;
	}
	
	@Override
	public boolean equals(Object obj) {
		return true;
	}
	
	public static void main(String[] args) {
		HashCodeNdEquals a = new HashCodeNdEquals();
		HashCodeNdEquals b = new HashCodeNdEquals();
		a.name = "Test";
		b.name = "Hey";
		
		HashSet set = new HashSet<>();
		set.add(a);
		set.add(b);
		
		System.out.println(set.size());
		
		
		
	}
	

}
