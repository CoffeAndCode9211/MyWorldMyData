package com.main.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapExample {

    public static void main(String[] args) {

        String data = "Hello this my world Hello this is Your world with me and you";
        String dataSet = "Hello this is my";
        String[] dataValue = data.split(" ");
        String[] dataValue1 = dataSet.split(" ");

        Map<String, Integer> map = new HashMap<>();

        Map<String, Integer> map1 = new HashMap<>();


        for (String data1 : dataValue) {
            Integer freq = map.get(data1);
            map.put(data1, (freq == null ? 1 : freq + 1));
        }

        for (String data3 : dataValue1) {
            Integer freq = map1.get(data3);
            map1.put(data3, (freq == null ? 1 : freq + 1));
        }

        System.out.println(map.size() + " distinct words");
        System.out.println(map);

        System.out.println(map1.size() + " distinct words");
        System.out.println(map1);
		
		/*
		// iterate map
		for(String data2 : map.keySet()){
			System.out.println(data2);
		}
		System.out.println("give me a break");
		Iterator<String> iterator = map.keySet().iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		*/
        // with key value
        Iterator<Entry<String, Integer>> kv1 = map.entrySet().iterator();

        for (Map.Entry<String, Integer> kv : map.entrySet()) {
            kv.setValue(123);
            System.out.println(kv.getKey() + " : " + kv.getValue());

        }

        while (kv1.hasNext()) {
            Entry<String, Integer> e = kv1.next();
            System.out.println(e.getKey() + " : " + e.getValue());
        }

        // get common key to two Map objects.
        Set<String> key1 = new HashSet<>(map.keySet());
        key1.retainAll(map1.keySet());

        Iterator<String> ite = key1.iterator();
        while (ite.hasNext()) {
            System.out.println(ite.next());
        }


    }

    // with hashmap it prints
    // {with=1, world=2, Hello=2, and=1, this=2, me=1, Your=1, is=2, my=1, you=1}
    // with LinkedHashMap
    // Hello=2, this=2, is=2, my=1, world=2, Your=1, with=1, me=1, and=1, you=1}
    // with Tree Map
    // {Hello=2, Your=1, and=1, is=2, me=1, my=1, this=2, with=1, world=2, you=1}


}
