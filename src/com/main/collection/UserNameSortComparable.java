package com.main.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UserNameSortComparable {
    public static void main(String[] args) {
        UserName name[] = {
                new UserName("Aashish", "Kumar", 12),
                new UserName("Suman", "Benur", 12),
                new UserName("Naveen", "Kumar", 34),
                new UserName("Ashish", "Kumar", 10),
                new UserName("Dheepan", "Raj", 10),
                new UserName("Satish", "Gandhi", 26),

        };

        List<UserName> names = Arrays.asList(name);
        Collections.sort(names);
        System.out.println(names);

        List<Integer> ints = new ArrayList<Integer>();
        ints.add(4);
        ints.add(3);
        ints.add(7);
        ints.add(5);

        Collections.sort(ints);
        System.out.println(ints);


        Collections.sort(names, Collections.reverseOrder());
        System.out.println("Sort by reverse natural order");
        System.out.println(names);


    }
}
