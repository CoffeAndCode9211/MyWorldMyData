package com.main.java;

import java.util.AbstractList;
import java.util.ArrayList;

public class ReflectionExample {
    public static void main(String[] args) {
        Class<AbstractList> data = java.util.AbstractList.class;
        System.out.println(data.getConstructors());
        ReflectionExample.class.getConstructors();

    }
} 
