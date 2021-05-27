package com.main.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfPrime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        while (number-- > 0) {
            short check = 0;
            int inputNo = Integer.parseInt(br.readLine());
            for (int i = 2; i <= inputNo / 2; i++) {
                if (isPrime(i)) {
                    if (isPrime(inputNo - i)) {
                        System.out.println("Deepa");
                        check = 1;
                        break;
                    }
                }
            }
            if (check == 0) {
                System.out.println("Arjit");
            }
        }
    }


    public static boolean isPrime(int number) {
        int i;
        for (i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
