package com.main.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Demo{
	public static void main(String[] args) {
		
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				printMsg();
			}
		};
		runnable.run();
		
		
		List numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
		numbers.forEach(System.out::println);

		
		Stream stream =
		         Stream.of("d2", "a2", "b1", "b3", "c")
		             .filter(s -> s.startsWith("a"));

		     stream.anyMatch(s -> true); 
		     
		     
		     Supplier<Stream> streamSupplier =
		             () -> Stream.of("d2", "a2", "b1", "b3", "c")
		                     .filter(s -> s.startsWith("a"));

		         streamSupplier.get().anyMatch(s -> true);   // ok
		         streamSupplier.get().noneMatch(s -> true);  // ok
		         
		     
	}
	
	public static void printMsg(){
		System.out.println("Thread Started...");
	}
	
}
