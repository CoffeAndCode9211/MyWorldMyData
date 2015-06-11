package com.main.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReadLine {
	public static void main(String args[] ) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int noOfTestCase = Integer.parseInt(line);
		while(noOfTestCase > 0){
			int maxR = 0;
			line = br.readLine();
			line = line.toUpperCase();
			int index = line.indexOf('K');
			//System.out.println(index);
			
			char[] data = line.toCharArray();
			
			
			
			for(int i=index; i < data.length; i++){
				if(data[i] == 'R'){
					data[i] = 'K';
				}else if(data[i] == 'K'){
					data[i] = 'R';
				}
				maxR = maxR(data, maxR);
			}
			System.out.println(maxR);
			noOfTestCase--;
		}
	}
	
	public static int maxR(char[] data, int maxR ){
		int count = 0;
		for(int i=0; i < data.length; i++){
			if(data[i] == 'R'){
				count++;
			}
		}
		if(count > maxR){
			maxR = count;
		}
		//System.out.println(maxR);
		return maxR;
	}
	
}
