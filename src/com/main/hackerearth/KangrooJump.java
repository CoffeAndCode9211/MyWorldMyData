package com.main.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KangrooJump {
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuffer data = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int noOfCase = Integer.parseInt(br.readLine());
		while(noOfCase-- > 0){
			String[] eachRow = br.readLine().split(" ");
			data.append( Math.round( (double) ( Long.parseLong(eachRow[1]) - Long.parseLong(eachRow[0]) ) / Long.parseLong(eachRow[2]) ) );
			data.append("\n");
		}
		System.out.println(data.toString());
	}
}
