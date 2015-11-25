package com.main.interview;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class FailSafeExample {
	public static void main(String[] args)
	{
		ConcurrentHashMap<String,String> premiumPhone = 
                new ConcurrentHashMap<String,String>();
		premiumPhone.put("Apple", "iPhone");
		premiumPhone.put("HTC", "HTC one");
		premiumPhone.put("Samsung","S5");

		Iterator<String> iterator = premiumPhone.keySet().iterator();

		while (iterator.hasNext())
		{
			System.out.println(premiumPhone.get(iterator.next()));
			premiumPhone.put("Sony", "Xperia Z");
		}

	}

}

/* 
 Output: 
 
 iPhone
 HTC one
 S5

 
 Fail Safe Iterator makes copy of the internal data structure (object array) and iterates over the copied data structure.
 Any structural modification done to the iterator affects the copied data structure.
 
 Eg: ConcurrentHashMap
 */
