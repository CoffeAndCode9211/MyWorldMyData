package com.main.collection;

import java.util.Hashtable;
import java.util.Map;

public class HashTableExample {

    public static void main(String[] args) {
        Hashtable<String, Integer> balance = new Hashtable<>();
        balance.put("Zara", 12);
        balance.put("Aaaa", 32);
        balance.put("Qwer", 65);
        balance.put("Zxcv", 45);
        balance.put("Sdfg", 76);

        for (Map.Entry<String, Integer> data : balance.entrySet()) {
            System.out.println(data.getKey() + " : " + data.getValue());
        }


    }
}
