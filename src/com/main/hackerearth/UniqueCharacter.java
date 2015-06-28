package com.main.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UniqueCharacter {
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuffer finalString = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int noOfCase = Integer.parseInt(br.readLine());
		while(noOfCase-- > 0){
			finalString.append(removeDuplicates(br.readLine()));
			finalString.append("\n");
		}
		System.out.println(finalString.toString());
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
