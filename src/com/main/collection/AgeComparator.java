package com.main.collection;

import java.util.Comparator;

public class AgeComparator implements Comparator<UserName>{

	@Override
	public int compare(UserName e1, UserName e2) {
		int dateCmp = e1.getAge().compareTo(e2.getAge());
		if (dateCmp != 0)
			return dateCmp;

		return (e1.getFirstName().compareTo(e2.getFirstName()));
	}
}
