package com.main.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {

	public static void main(String[] args) {

		Collection<String> colData = getObject();

		// getting unique records without order 
		Set<String> uniqueData = new HashSet<>(colData);		
		Iterator<String> iterator = uniqueData.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}

		// getting unique record with insertion order 
		Set<String> uniqueDataWithOrder = new LinkedHashSet<>(colData);
		iterator = uniqueDataWithOrder.iterator();
		System.out.println("Give me a Break");
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}

		Set<String> uniqueDataWithSorting = new TreeSet<>(colData);
		iterator = uniqueDataWithSorting.iterator();
		System.out.println("Give me a Break");
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}



		// converting array to Set 
		String[] stringArray = new String[100];
		for (int i = 0; i < stringArray.length; i++) {
			stringArray[i] = i+"";
		}

		Set<String> data = new HashSet<>(Arrays.asList(stringArray));



		// show all unique records without showing all duplicate even once 

		Set<String> uniques = new HashSet<String>();
		Set<String> dups    = new HashSet<String>();

		for (String a : colData)
			if (!uniques.add(a))
				dups.add(a);
		// Destructive set-difference
		uniques.removeAll(dups);

		System.out.println("Unique words:    " + uniques);
		System.out.println("Duplicate words: " + dups);


	}


	public static Collection<String> getObject(){

		Collection<String> myList = new ArrayList<>();
		myList.add("Java"); 
		myList.add("Unix");
		myList.add("Oracle");
		myList.add("Oracle");
		myList.add("Oracle");
		myList.add("Oracle");
		myList.add("Oracle");
		myList.add("C++");
		myList.add("Perl");
		return myList; 

	}
}
