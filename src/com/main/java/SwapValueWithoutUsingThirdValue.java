package com.main.java;

public class SwapValueWithoutUsingThirdValue {
    public static void main(String[] args) {
        int a = 9;
        int b = 8;
        a = a + b;
        if (a > b) {
            b = a - b;
        } else {
            b = b - a;
        }
        a = a - b;
        System.out.println(a + " : " + b);
    }
}
