package com.main.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Criminals {


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int noOfCase = Integer.parseInt(br.readLine().trim());
        while (noOfCase-- > 0) {
            int noOfBox = Integer.parseInt(br.readLine().trim());
            long noOfPackets[] = new long[noOfBox];
            for (int i = 0; i < noOfBox; i++) {
                noOfPackets[i] = Integer.parseInt(br.readLine().trim());
            }
            Arrays.sort(noOfPackets);
            int count = 0, tempCount = 1;
            for (int i = 0; i < noOfBox - 1; i++) {
                if (noOfPackets[i] == noOfPackets[i + 1]) {
                    tempCount++;
                    count = count < tempCount ? tempCount : count;
                } else {
                    tempCount = 1; // resetting counter
                }
            }
            count = count < tempCount ? tempCount : count;
            System.out.println(count);
        }
    }


}
