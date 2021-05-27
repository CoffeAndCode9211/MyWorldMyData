package com.main.interview;

public class SameObjType {
    public static void main(String[] args) {
        SameObjType obj = new SameObjType();
        //obj.test1(null);
    }

    void test1(String a) {
        System.out.println("String");
    }

    void test1(int... a) {
        System.out.println("array");
    }

    void test1(Object a) {
        System.out.println("Obj");
    }


}
