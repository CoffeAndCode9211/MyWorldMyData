package com.main.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demand {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		int wordLength = word.length();
		int number = Integer.parseInt(br.readLine());
		StringBuilder sr = new StringBuilder();
		while(number-- > 0){
			String value[] = br.readLine().split(" ");
			long value1 = Long.parseLong(value[0]);
			long value2 = Long.parseLong(value[1]);
			if(word.charAt( (int) ((value1-1) % wordLength) ) == word.charAt( (int) ((value2-1) % wordLength))){
				sr.append("Yes");
			}else{ 
				sr.append("No");
			}
			sr.append("\n");
		}
		System.out.println(sr.toString());
	}
}




