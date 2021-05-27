package com.main.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BigIntegerFactorial {


    public static void main(String[] args) throws NumberFormatException, IOException {
        StringBuffer data = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int noOfCase = Integer.parseInt(br.readLine());
        while (noOfCase-- > 0) {
            data.append(getFactorial(Integer.parseInt(br.readLine())));
            data.append("\n");
        }
        System.out.println(data.toString());

    }

    public static BigInteger getFactorial(int number) {
        BigInteger fac = new BigInteger("1");
        while (number > 1) {
            fac = fac.multiply(new BigInteger(String.valueOf(number)));
            number--;
        }
        return fac;
    }


}
