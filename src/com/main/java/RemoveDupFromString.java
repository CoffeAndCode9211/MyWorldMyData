package com.main.java;


public class RemoveDupFromString {
	public static void main(String[] args) {
		String data = removeDuplicates("nnnisssshhhaaz");
		System.out.println(data);
	}

	// ascii for z is 122 
	public static String removeDuplicates(String str) {
	    boolean seen[] = new boolean[123];
	    StringBuilder sb = new StringBuilder(seen.length);
	    for (int i = 0; i < str.length(); i++) {
	        char ch = str.charAt(i);
	        if (!seen[ch] ) {
	            seen[ch] = true;
	            sb.append(ch);
	        }
	    }
	    return sb.toString();
	}
}
