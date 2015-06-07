package com.main.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UserNameSortComparator {

	static final Comparator<UserName> AGEORDER = new Comparator<UserName>(){
		public int compare(UserName u1, UserName u2){
			return u1.getAge().compareTo(u2.getAge());
		}
	};

	static final Comparator<UserName> SENIORITY_ORDER = 
			new Comparator<UserName>() {
		public int compare(UserName e1, UserName e2) {
			int dateCmp = e2.getAge().compareTo(e1.getAge());
			if (dateCmp != 0)
				return dateCmp;

			return (e1.getUserId() < e2.getUserId() ? -1 :
				(e1.getUserId() == e2.getUserId() ? 0 : 1));
		}
	};

	public static void main(String[] args) {

		UserName name[] = {
				new UserName("Ashish", "Kumar", 10),
				new UserName("Suman", "Benur", 12),
				new UserName("Naveen", "Kumar", 12),
				new UserName("Ashish", "Kumat", 35),
				new UserName("Dheepan", "Raj", 45),
				new UserName("Satish", "Gandhi", 55),

		};

		List<UserName> names = Arrays.asList(name);
		Collections.sort(names, AGEORDER);
		System.out.println(names);
	}


}
