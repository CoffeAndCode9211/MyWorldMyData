package com.main.collection;

import java.util.Enumeration;
import java.util.Vector;

public class EnumerationExample {

    public static void main(String[] args) {

        Vector<UserName> names = new Vector<>();
        names.add(new UserName("Ashish", "Kumar", 12));
        names.add(new UserName("sfdsdfsf", "fasfsdf", 234));
        names.add(new UserName("Ashisafdasfsh", "fdasf", 12));
        names.add(new UserName("sadfdsafsfw", "wreewr", 45));

        Enumeration<UserName> data = names.elements();
        while (data.hasMoreElements()) {
            System.out.println(data.nextElement());
        }
    }
}
