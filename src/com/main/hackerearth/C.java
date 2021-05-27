package com.main.hackerearth;

public class C extends B {
    C() {
        super("World ");
        new B("World ");
    }

    public static void main(String[] args) {
        new C();
    }

}

class A {
    A() {
        System.out.println("Hello ");
    }
}

class B extends A {
    B(String type) {
        System.out.println(type);
    }

    B() {

    }
}