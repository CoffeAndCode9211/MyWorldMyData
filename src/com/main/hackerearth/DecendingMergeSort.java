package com.main.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DecendingMergeSort {

	private long[] array;
	private long[] tempMergArr;
	private int length;
	public static void main(String args[] ) throws Exception {


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
	public void sort(long inputArr[]) {
		this.array = inputArr;
		this.length = inputArr.length;
		this.tempMergArr = new long[length];
		doMergeSort(0, length - 1);
	}

	private void doMergeSort(int lowerIndex, int higherIndex) {

		if (lowerIndex < higherIndex) {
			int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
			// Below step sorts the left side of the array
			doMergeSort(lowerIndex, middle);
			// Below step sorts the right side of the array
			doMergeSort(middle + 1, higherIndex);
			// Now merge both sides
			mergeParts(lowerIndex, middle, higherIndex);
		}
	}

	private void mergeParts(int lowerIndex, int middle, int higherIndex) {

		for (int i = lowerIndex; i <= higherIndex; i++) {
			tempMergArr[i] = array[i];
		}
		int i = lowerIndex;
		int j = middle + 1;
		int k = lowerIndex;
		while (i <= middle && j <= higherIndex) {
			// change to <= for ascending order
			if (tempMergArr[i] >= tempMergArr[j]) {
				array[k] = tempMergArr[i];
				i++;
			} else {
				array[k] = tempMergArr[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			array[k] = tempMergArr[i];
			k++;
			i++;
		}
	}
}
