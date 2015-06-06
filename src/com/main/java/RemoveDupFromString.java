package com.main.java;

import java.util.HashSet;
import java.util.Set;

public class RemoveDupFromString {
	public static void main(String[] args) {
		String data = removeDuplicates("nnnisssshhhaa");
		System.out.println(data);
	}
	
	
	public static String removeDuplicates(String str) {
	    boolean seen[] = new boolean[256];
	    
	    Set<Character> hasSeen = new HashSet<Character>();
	    
	    StringBuilder sb = new StringBuilder(seen.length);

	    for (int i = 0; i < str.length(); i++) {
	        char ch = str.charAt(i);
	        if (!seen[ch] && !hasSeen.contains(ch)) {
	            seen[ch] = true;
	            sb.append(ch);
	        }
	    }

	    return sb.toString();
	}
}
