package com.main.java8;

import java.util.Arrays;
import java.util.Comparator;

public class StreamApiExample {

	public static void main(String args[]){

		int[] num = new int[100000000];
		for (int i = 0; i < 100000000; i++) {
			num[i] = i*81234567;;
		}
		System.out.println("--Array size: " + num.length);
		sortIt(num, false);
		sortIt(num, true);
	}

	public static void sortIt(int[] src, boolean parallel) {
        try {
            long start = System.currentTimeMillis();
            if ( parallel == true ) {
                Arrays.parallelSort(src);
            }
            else {
                Arrays.sort(src);
            }
            long end = System.currentTimeMillis();
            System.out.println(
                "--Elapsed sort time: "+(parallel == true ? "Parallel: " : "Single:" ) + (end-start));
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
    }

	static final Comparator < String > NAMEORDER = new Comparator < String > () {
		public int compare(String u1, String u2) {
			// sort in ASC order of Name
			return u1.compareTo(u2);
		}
	};

}
