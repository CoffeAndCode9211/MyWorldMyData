package com.main.interview;

public class StaticMethod {
	
	public static void show(){
		System.out.println("This is static method");
	}
	
	public static void main(String[] args) {
		StaticMethod staticMethod = null;
		staticMethod.show();
		StaticMethod.show();
		
		
	}
}

/*   
 Output : 
 This is static method
 
 Explaination : 
 
	We can call static methods using reference variable which is pointing to null because static methods 
	are class level so we can either call using class name and reference variable which is pointing to null
 
 
 */