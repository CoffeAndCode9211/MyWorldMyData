package com.main.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UserNameSortComparable {
	public static void main(String[] args) {
		UserName name[] = {
				new UserName("Ashish", "Kumar", 12),
				new UserName("Suman", "Benur", 12),
				new UserName("Naveen", "Kumar", 34),
				new UserName("Ashish", "Kumar", 35),
				new UserName("Dheepan", "Raj", 10),
				new UserName("Satish", "Gandhi", 26),

		};

		List<UserName> names = Arrays.asList(name);
		Collections.sort(names);
		System.out.println(names);

	}
}
