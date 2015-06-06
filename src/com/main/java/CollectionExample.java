package com.main.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Collectors;

public class CollectionExample {

	public static void main(String[] args) {
		
		Collection<String> myList = getObject();
		
		// Method 1
		
			myList.parallelStream()
				.filter(e -> e == "Oracle")
				.forEach(e -> System.out.println(e.toString()));
			
			
			String joined = myList.stream()
				.map(Object:: toString)
				.collect(Collectors.joining(", "));
			System.out.println(joined);
			
			/*
			int total = employees.stream()
					.collect(Collectors.summingInt(Employee::getSalary)));
			*/
			
		// Method 2
			for (String data : myList) {
				System.out.println("For Each: "+data);
			}
		
		// Method 3
			Iterator<String> itr = myList.iterator();
			while(itr.hasNext()){
				System.out.println("Iterator: "+itr.next());
			}
			
		
			Collection<String> col1 = new ArrayList<>();
			col1.add("data"); 
			col1.add("value");
			/*
			if( myList.containsAll(col1) ){
				System.out.println("Yahoo found you");
				
			}
			
			*/
			
			myList.addAll(col1);
			// As we modified collection it throws ConcurrentModificationException so we need to set iterator again
			
			//myList.removeAll(Collections.singleton("Oracle"));
			
			itr = myList.iterator();
			while(itr.hasNext()){
				System.out.println("Iterator1: "+itr.next());
			}
			
			
			
			
			
		
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


