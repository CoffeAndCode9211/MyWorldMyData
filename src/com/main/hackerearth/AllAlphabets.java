package com.main.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class AllAlphabets {

    public static void main(String[] args) throws NumberFormatException, IOException {
        StringBuffer data = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int noOfCase = Integer.parseInt(br.readLine());
        while (noOfCase-- > 0) {
            String value = br.readLine();
            if (value.length() < 26) {
                data.append("NO");
            } else {
                if (getUniqueCharacter(value) == 26) {
                    data.append("YES");
                } else {
                    data.append("NO");
                }
            }

            data.append("\n");
        }
        System.out.println(data.toString());

    }

    public static int getUniqueCharacter(String data) {
        char[] character = data.toCharArray();
        HashSet<Character> hs = new HashSet<>();
        for (char c : character) {
            hs.add(c);
        }

        return hs.size();
    }

}
