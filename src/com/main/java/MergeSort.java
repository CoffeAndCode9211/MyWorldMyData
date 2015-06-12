package com.main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.main.hackerearth.DecendingMergeSort;

public class MergeSort {
	
	private long array[];
	private long tmpMergeArray[];
	private int length; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number=Integer.parseInt(br.readLine());
		while(number-- > 0){
			int element=Integer.parseInt(br.readLine());
			long[] inputArr =new long[element];
			String a1[]= br.readLine().split(" ");
			for(int i=0;i<a1.length;i++){
				inputArr[i]=Long.parseLong(a1[i]);
			}
			DecendingMergeSort mms = new DecendingMergeSort();
			mms.sort(inputArr);
			StringBuilder s1=new StringBuilder();
			for(long i:inputArr){
				s1.append(i+" ");
			}
			System.out.println(s1);
		}
	}
	
	public void sort(long[] array){
		this.array = array;
		this.length = array.length;
		this.tmpMergeArray = new long[length];
		doMergeSort(0, length-1);
	}
	
	public void doMergeSort(int lowerIndex, int higherIndex){
		if(lowerIndex < higherIndex){
			int middle = lowerIndex + (higherIndex - lowerIndex)/2;
			doMergeSort(lowerIndex,  middle);
			doMergeSort( middle + 1,  higherIndex);
			mergeParts(lowerIndex, middle, higherIndex);
		}
	}
	
	public void mergeParts(int lowerIndex, int middle, int higherIndex){
		for(int i=0; i <= higherIndex; i++){
			tmpMergeArray[i] = array[i];
		}
		int i = lowerIndex;
		int j = higherIndex;
		int k = lowerIndex;
		while(i <= middle && j <= higherIndex){
			if(tmpMergeArray[i] >= tmpMergeArray[k]){
				array[k] = tmpMergeArray[i];
				i++;
			}else{
				array[k] = tmpMergeArray[i];
				j++;
			}
			k++;
		}
		while(i <= middle){
			array[i] = tmpMergeArray[k];
			k++;
			i++;
		}
	}
}
