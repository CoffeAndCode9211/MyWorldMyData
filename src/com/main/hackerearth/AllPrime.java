package com.main.hackerearth;

import java.util.Scanner;

public class AllPrime {
	public static void main(String args[]) throws Exception {

		Scanner s = new Scanner(System.in);
		char space = ' ';
		int n = Integer.parseInt(s.nextLine());
		s.close();
		
		StringBuilder str = new StringBuilder();
		final boolean[] touched = new boolean[n+1];
		final double sqrtNum = Math.sqrt(n);
		for(int i = 2; i <= n; i += 2){
			touched[i] = true;
		}
		
		for(int i=3; i <= sqrtNum; i++){
			if(!touched[i]){
				for(int j=i*i; j <= n; j = j + (i*2) ){
					touched[j] = true;
				}
			}
		}
		
		for (int i = 2; i <= n; i++) {
            if (!touched[i]) {
            	str.append(i);
            	str.append(space);
            }
        }
		System.out.println(str.toString());
		
	}
}
