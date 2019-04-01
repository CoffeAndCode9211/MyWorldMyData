package com.main.blog;

import java.util.List;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorDemo {

	
	public static void main(String[] args) {
		List<String> lstData = new ArrayList<>();
		lstData.add("Test");
		lstData.add("Test1");
		lstData.add("Test2");
		lstData.add("Test3");
		
		Iterator<String> i = lstData.iterator();
		
		while(i.hasNext()){
			System.out.println(i.next());
			lstData.remove(0);
			
		}
		System.out.println(lstData);
		
	}
	
}
