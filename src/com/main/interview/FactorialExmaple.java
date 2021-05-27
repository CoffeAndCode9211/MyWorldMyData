package com.main.interview;

public class FactorialExmaple {

    public static int factorial(int n) {
        int result = 0;
        if (n <= 0) {
            return 0;
        }
        if (n == 1) return 1;
        System.out.println("Goint to call Factorial function :" + n);
        result = factorial(n - 1) * n;
        System.out.println(n + " : " + result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Factorial of 3: " + factorial(12));
    }

}
/*
 When a method calls itself, new local variables and parameters are allocated storage on the stack,
 and the method code is executed with these new variables from the start. As each recursive call returns, 
 the old local variables and parameters are removed from the stack, and execution resumes at the point of 
 the call inside the method. Recursive methods could be said to “telescope” out and back.

*/