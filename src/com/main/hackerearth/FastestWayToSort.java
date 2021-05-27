package com.main.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FastestWayToSort {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws Exception {

        int arr[];
        int N = readInt();
        for (int i = 0; i < N; i++) {
            int F = readInt();
            int j = 0;
            arr = new int[F];
            while (F != 0) {
                arr[j] = readInt();
                j++;
                F--;
            }
            Arrays.sort(arr);
            StringBuilder sb = new StringBuilder();
            for (j = (arr.length - 1); j >= 0; j--)
                sb.append(arr[j] + " ");
            System.out.println(sb);
        }
    }

    private static int readInt() throws IOException {
        int n = 0;
        char ch = (char) br.read();
        int sign = 1;
        while (ch < '0' || ch > '9') {
            if (ch == '-')
                sign = -1;
            ch = (char) br.read();
        }
        while (ch >= '0' && ch <= '9') {
            n = (n << 3) + (n << 1) + (int) ch - '0';
            ch = (char) br.read();
        }
        n = n * sign;
        return n;
    }


}
