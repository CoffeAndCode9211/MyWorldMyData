package com.main.java;


public class RemoveDupFromString {
	public static void main(String[] args) {
		String data = removeDuplicates("nnnisssshhhaa");
		System.out.println(data);
	}

	public static String removeDuplicates(String str) {
	    boolean seen[] = new boolean[256];
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
