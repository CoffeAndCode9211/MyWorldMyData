package com.main.blog;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class B2 {

    private static TreeMap<Integer, String> val = new TreeMap<Integer, String>();

    public static List<String> romanizer(List<Integer> numbers) {
        List<String> lstData = new ArrayList<String>();
        val.put(1000, "M");
        val.put(900, "CM");
        val.put(500, "D");
        val.put(400, "CD");
        val.put(100, "C");
        val.put(90, "XC");
        val.put(50, "L");
        val.put(40, "XL");
        val.put(10, "X");
        val.put(9, "IX");
        val.put(8, "VIII");
        val.put(7, "VII");
        val.put(6, "VI");
        val.put(5, "V");
        val.put(4, "IV");
        val.put(3, "III");
        val.put(2, "II");
        val.put(1, "I");

        for (Integer i : numbers) {
            lstData.add(conv(i));
        }
        return lstData;
    }

    public final static String conv(int number) {
        int l = val.floorKey(number);
        System.out.println(l);
        if (number == l) {
            return val.get(number);
        }
        return val.get(l) + conv(number - l);
    }

    public static void main(String[] args) {
        List<Integer> aa = new ArrayList<>();
        aa.add(2);
        aa.add(3);
        aa.add(4);
        aa.add(5);
        aa.add(6);
        aa.add(7);
        aa.add(8);
        aa.add(9);
        aa.add(13);
        aa.add(34);
        aa.add(56);
        aa.add(75);

        System.out.println(romanizer(aa).toString());
    }

    public static String repeat(String s, int n) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

}
