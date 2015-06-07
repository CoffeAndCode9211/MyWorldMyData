package com.main.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public enum UserComparator implements Comparator<UserName> {
	
	LAST_NAME {
		public int compare(UserName u1, UserName u2){
			return u1.getLastName().compareTo(u2.getLastName());
		}
	},
	FIRST_NAME{
		public int compare(UserName u1, UserName u2){
			return u1.getFirstName().compareTo(u2.getFirstName());
		}
	},
	AGE{
		public int compare(UserName u1, UserName u2){
			return u1.getAge().compareTo(u2.getAge());
		}
	};
	
	
	public static Comparator<UserName> getComparator(final UserComparator... multipleOptions) {
	    return new Comparator<UserName>() {
	        public int compare(UserName o1, UserName o2) {
	            for (UserComparator option : multipleOptions) {
	                int result = option.compare(o1, o2);
	                if (result != 0) {
	                    return result;
	                }
	            }
	            return 0;
	        }
	    };
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
	    Collections.sort(names, getComparator(FIRST_NAME,LAST_NAME,  AGE));
	    
	    System.out.println(names);
	}
}


