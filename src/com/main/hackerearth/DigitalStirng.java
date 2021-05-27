package com.main.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DigitalStirng {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = br.readLine();
        int total = 0;
        for (char c : data.toCharArray()) {
            total += noOfDash(c);
        }
        System.out.println(total);
    }

    public static int noOfDash(char digit) {
        int noOfDash = 0;
        switch (digit) {
            case '0':
                noOfDash = 6;
                break;
            case '1':
                noOfDash = 2;
                break;
            case '2':
                noOfDash = 5;
                break;
            case '3':
                noOfDash = 5;
                break;
            case '4':
                noOfDash = 4;
                break;
            case '5':
                noOfDash = 5;
                break;
            case '6':
                noOfDash = 6;
                break;
            case '7':
                noOfDash = 3;
                break;
            case '8':
                noOfDash = 7;
                break;
            case '9':
                noOfDash = 6;
                break;
        }
        return noOfDash;
    }
}
