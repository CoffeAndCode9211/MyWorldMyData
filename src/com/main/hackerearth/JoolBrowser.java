package com.main.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JoolBrowser {

	public static void main(String[] args) throws IOException {
		StringBuffer data = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int noOfCase = Integer.parseInt(br.readLine());
		while(noOfCase-- > 0){
			String name = br.readLine().trim();
			data.append(getUniqueCharCount(name) + 4+"/"+name.length());
			data.append("\n");
		}
		
		System.out.println(data.toString());
		
	}
	
	public static int getUniqueCharCount(String str) {
	    int count = 0;
	    for (int i = 4; i < str.length() - 4; i++) {
	    	char ch = str.charAt(i);
	    	if( !(ch == 'a'|| ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') ){
	    			count++;
	    		
	    	}
	        
	    }
	    return count;
	}
}
