package com.main.java;

public class PrintPyramid {

    public static void main(String[] args) {
        int size = 7;
        printPyramid(size);
        System.out.println();
        System.out.println();
        printLeftTriangle(size);
        System.out.println();
        System.out.println();
        printInvertedOddPyramid(size);
        System.out.println();
        System.out.println();
        printRightTriangle(size);

    }

    static void printInvertedOddPyramid(int n) {
        int i, j;
        for (i = n; i > 0; i--) {
            if (i % 2 != 0) {
                for (j = (n - i) / 2; j > 0; j--)
                    System.out.print(" ");
                for (j = i; j > 0; j--)
                    System.out.print("*");
                System.out.println();
            }
        }
    }

    static void printRightTriangle(int n) {
        int i, j;
        for (i = n; i > 0; i--) {
            for (j = n - i; j > 0; j--)
                System.out.print(" ");
            for (j = i; j > 0; j--)
                System.out.print("*");
            System.out.println();
        }
    }

    static void printLeftTriangle(int n) {
        int i, j;
        for (i = n; i > 0; i--) {
            for (j = i; j > 0; j--)
                System.out.print("*");
            System.out.println();
        }
    }

    static void printPyramid(int n) {
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n - i; j++)
                System.out.print(" ");
            for (j = 0; j < i; j++)
                System.out.print("*");
            System.out.println();
        }
    }


}
