package com.main.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* Convert list of list to list  */
public class FlatMap {
    public static void main(String[] args) {
        List<List<Object>> list = new ArrayList<>();
        list.add(Arrays.asList(12, 34, 545));
        list.add(Arrays.asList(21, 434, 645));
        list.add(Arrays.asList(56, 77, 856));
        System.out.println("List of List: " + list);
        List<Object> lst = list.stream()
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());

        System.out.println("Flat List : " + lst);
    }
}
