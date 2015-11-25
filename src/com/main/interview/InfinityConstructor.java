/**
 * 
 */
package com.main.interview;

/**
 * @author ashishkumar
 *
 */
public class InfinityConstructor {

	
	InfinityConstructor infinityConstructor = new InfinityConstructor();
	
	public int show(){
		return 1;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		InfinityConstructor infinityConstructor = new InfinityConstructor();
		infinityConstructor.show();

	}

}


/*  
 Output: 
 	Exception in thread "main" java.lang.StackOverflowError
	at com.main.interview.InfinityConstructor.<init>(InfinityConstructor.java:13)
	at com.main.interview.InfinityConstructor.<init>(InfinityConstructor.java:13)
	at com.main.interview.InfinityConstructor.<init>(InfinityConstructor.java:13)
	at com.main.interview.InfinityConstructor.<init>(InfinityConstructor.java:13)
	at com.main.interview.InfinityConstructor.<init>(InfinityConstructor.java:13)
	
Explanation:

	Whenever we create the object of any class constructor will be called first and memory allocated for all non static variables
	
	Here  B b= new B(); variable is object and assigned to new object of same class
	
	B b= new B(); statement leads to recursive execution of constructor will create infinite objects so at run time an exception will be raised
	Exception in thread "main" java.lang.StackOverflowError
		
 */
 
