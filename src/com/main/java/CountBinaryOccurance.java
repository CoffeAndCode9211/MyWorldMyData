package com.main.java;

public class CountBinaryOccurance {

    public static void main(String[] args) {
        int n = 43;
        System.out.println("Java 1's count:" + Integer.bitCount(n));
        int length = Integer.toBinaryString(n).length();
        System.out.println("Direct conversion count with size: " + length + " : " + Integer.toBinaryString(n));
        int noOfoneS = bitCount(n);
        System.out.println("No of 1's :" + noOfoneS);
        System.out.println("No of 0's :" + (length - noOfoneS));

    }

    public static int bitCount(int n) {
        int count = 0;
        while (n > 0) {
            // So if we subtract a number by 1 and do bitwise & with itself (n & (n-1)), we unset the righmost set bit
            System.out.println("AND these 2 values: " + Integer.toBinaryString(n) + " : " + Integer.toBinaryString(n - 1));
            n &= (n - 1);
            count++;
        }
        return count;
    }


}
