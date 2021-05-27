package com.main.hackerearth;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class CommonMultiple {

    public static void main(String[] args) throws IOException {

        Scanner s = new Scanner(System.in);
        int len = s.nextInt();
        int c = 0;
        int[] d = new int[len];
        long count = 0;
        while (c < len) {
            int v = s.nextInt();
            d[c] = v;
            count += v;
            c++;
        }
        Arrays.sort(d);
        int result = binarySearch(d, 0, len - 1, count);
        System.out.println(result);
        s.close();

    }

    static int binarySearch(int arr[], int l, int r, long x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            if ((arr[mid] * l) == x)
                return mid;

            if ((arr[mid] * l) > x)
                return binarySearch(arr, l, mid - 1, x);
            return binarySearch(arr, mid + 1, r, x);
        }

        return -1;
    }


}
