package com.main.interview;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FailFastExample {
	public static void main(String[] args)
	{
		Map<String,String> premiumPhone = new HashMap<String,String>();
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
 Fail fast iterator while iterating through the collection , instantly throws Concurrent Modification 
 Exception if there is structural modification  of the collection
 
 Example : HashMap,Vector,ArrayList,HashSet
 */
