package com.main.java;

import java.io.IOException;

public class ThrowsExample {


    static void checkThrow() throws IOException {
        int data = 1;
        System.out.println(data);
        throw new IOException("Throwing IO Exception");
    }

    public static void main(String args[]) throws IOException {
        checkThrow();
        System.out.println("normal flow...");
    }
}
