package com.main.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;


/**
 * How shuffle works in Collection with List
 * @author ashishkumar
 *
 */
public class ListExample {


	public static void main(String[] args) {
		
		List<String> data = getObject();
		
//		
//		Iterator<String> iterator = data.iterator();
//		int counter = 0;
//		while(iterator.hasNext()){
//			Collections.shuffle(data, new Random());
//			System.out.println(data);
//			counter ++;
//			if(counter > 15){
//				break;
//			}
//		}
//		
		
		
		ListIterator<String> lstIterator = data.listIterator();
		
		for (ListIterator<String> it = data.listIterator(data.size()); it.hasPrevious(); ) {
			System.out.println(it.previous());
		}
		
		ListIterator<String> lstIterator1 = data.listIterator(data.size());
		while (lstIterator1.hasPrevious()) {
			System.out.println(lstIterator1.previous());
		}
		
		
		while (lstIterator.hasNext()) {
			//System.out.println(lstIterator.next());
			//System.out.println(lstIterator.previousIndex());
		}
		System.out.println("Give me a break");
		while (lstIterator.hasPrevious()) {
			//System.out.println(lstIterator.previous());
		}
		
	}

	public static <E> void swap(List<E> list, int x, int y){
		E tmp = list.get(x);
		list.set(x, list.get(y));
		list.set(y, tmp);
	}

	public static List<String> getObject(){

		List<String> myList = new ArrayList<>();
		myList.add("Java"); 
		myList.add("Unix");
		myList.add("Oracle");
		myList.add("C++");
		myList.add("Perl");
		return myList; 

	}
	
	public static void shuffle(List<?> list, Random rnd) {
	    for (int i = list.size(); i > 1; i--)
	        swap(list, i - 1, rnd.nextInt(i));
	}
	
}


