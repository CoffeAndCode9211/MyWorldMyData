package com.main.java8;


interface Sayable{   
	void say();   
}   
public class MethodReferences {   
	public static void saySomething(){   
		System.out.println("Hello, this is static method.");   
	}   

	public void saySomethingNew(){   
		System.out.println("Hello, this is method.");   
	} 

	public MethodReferences(){  
		System.out.print("Hello World");  
	}  

	public static void main(String[] args) {   
		// Referring static method   
		Sayable sayable = MethodReferences::saySomething;   
		// Referring Object
		Sayable sayable1 =  new MethodReferences()::saySomethingNew;  	 
		// Referring Constructor
		Sayable sayable2 = MethodReferences::new;  
		// Calling interface method   
		sayable.say();  
		sayable1.say();  
		sayable2.say();  
	}   
}

