package com.main.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

class CarNames {


    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        while (number-- > 0) {

            String data = br.readLine();
            List<Character> uniqueChar = new ArrayList<Character>();
            for (int i = 0; i < data.length(); i++) {
                if (!uniqueChar.contains(data.charAt(i))) {
                    uniqueChar.add(data.charAt(i));
                }
            }
            int count = 0;
            int dataCount = 0;
            boolean check = true;
            for (int i = 0; i < uniqueChar.size(); i++) {
                int temp = 0;
                if (count == 0) {
                    temp = StringUtils.countMatches(data, uniqueChar.get(i).toString());
                    dataCount = temp;
                    count++;
                } else {
                    temp = StringUtils.countMatches(data, uniqueChar.get(i).toString());
                    if (dataCount == temp) {
                        check = false;
                        continue;
                    } else {
                        check = true;
                        System.out.println("Not OK");
                        break;
                    }
                }

            }
            if (check == false) {
                System.out.println("OK");
            }
        }
    }
}
