package com.main.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UserNameSortComparator {

    static final Comparator<UserName> AGEORDER = new Comparator<UserName>() {
        public int compare(UserName u1, UserName u2) {
            return u1.getAge().compareTo(u2.getAge());
        }
    };

    static final Comparator<UserName> SENIORITY_ORDER =
            new Comparator<UserName>() {
                public int compare(UserName e1, UserName e2) {
                    int dateCmp = e2.getAge().compareTo(e1.getAge());
                    if (dateCmp != 0)
                        return dateCmp;

                    return (e1.getFirstName().compareTo(e2.getFirstName()));
                }
            };

    public static void main(String[] args) {

        UserName name[] = {
                new UserName("Aashish", 12),
                new UserName("Suman", 12),
                new UserName("Naveen", 34),
                new UserName("Ashish", 10),
                new UserName("Dheepan", 10),
                new UserName("Satish", 26)

        };

        List<UserName> names = Arrays.asList(name);
        Collections.sort(names, AGEORDER);
        System.out.println("AGEORDER => " + names);
        Collections.sort(names, SENIORITY_ORDER);
        System.out.println("SENIORITY_ORDER => " + names);
        Collections.sort(names, new AgeComparator());
        System.out.println("AgeComparator => " + names);
    }


}
