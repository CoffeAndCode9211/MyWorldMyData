package com.main.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.lang3.builder.CompareToBuilder;


public class SortUsingCompareToBuilder implements Comparator<UserName> {
	public int compare(UserName o1, UserName o2) {
		return new CompareToBuilder()
		.append(o1.getFirstName(), o2.getFirstName())
		.append(o1.getLastName(), o2.getLastName())
		.append(o1.getAge(), o2.getAge()).toComparison();
	}
	
	public static void main(String[] args) {
		UserName name[] = {
				new UserName("Ashish", "Kumar", 12),
				new UserName("Suman", "Benur", 12),
				new UserName("Naveen", "beta", 34),
				new UserName("Ashish", "Berar", 35),
				new UserName("Dheepan", "Raj", 10),
				new UserName("Satish", "Gandhi", 26),
				
		};
		
		List<UserName> names = Arrays.asList(name);
	    Collections.sort(names, new SortUsingCompareToBuilder());
	    
	    System.out.println(names);
	}
}
