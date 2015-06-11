package com.main.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NonIncreasingSorting {


	private int[] array;
	private int[] tempMergArr;
	private int length;

	public static void main(String a[]) throws IOException{


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int noOfTestCase = Integer.parseInt(line);
		while(noOfTestCase > 0){
			line = br.readLine();
			line = br.readLine();
			String data[] = line.split(" ");
			int array[] = new int[data.length];
			for(int a1=0; a1 < data.length; a1++){
				array[a1] = Integer.parseInt(data[a1]);
			}

			NonIncreasingSorting mms = new NonIncreasingSorting();
			mms.sort(array);
			for(int i:array){
				System.out.print(i);
				System.out.print(" ");
					
			}
			
			
			noOfTestCase--;
		}
	}
			public void sort(int[] array2) {
				this.array = array2;
				this.length = array2.length;
				this.tempMergArr = new int[length];
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
					if (tempMergArr[i] <= tempMergArr[j]) {
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
