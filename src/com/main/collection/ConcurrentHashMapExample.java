package com.main.collection;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
	public static void main(String[] args) {
		
		Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("A","Apple");
        concurrentHashMap.put("B","Blackberry");
        Iterator<Entry<String, String>> iterator = concurrentHashMap.entrySet().iterator();
        while ( iterator.hasNext()) {
			Entry<String, String> e = iterator.next();
			System.out.println(e.getKey() + " = " + e.getValue());
		}
	}
}
