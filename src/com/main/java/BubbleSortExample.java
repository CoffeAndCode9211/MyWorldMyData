package com.main.java;

import java.util.Arrays;

public class BubbleSortExample {

	static String bubbleSort(int[] data){
		for (int i = 0; i < data.length; i++) {
			for (int j = data.length -1;  j > i; j--) {
				if(data[j] < data[j-1]){
					swap(data, j , j-1);
				}
			}
		}
		return Arrays.toString(data);
	}
	
	
	
	static void swap(int[] data, int x, int y){
		int temp = data[x];
		data[x] = data[y];
		data[y] = temp;
	}
	
	
	public static void main(String[] args) {
		System.out.println(bubbleSort(new int[] { 12,3,4,2,4,5,6,7,3,4,6}));
		
	}
}
