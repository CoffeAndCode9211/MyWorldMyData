package com.main.blog;

class Test {
	static int i;
	int j;
	// Initializer block starts..
	{
		// This code is executed before every constructor.
		System.out.println("Initializer blocker called");
	}
	// Static block
	static {
		i = 10;
		System.out.println("static block called ");
		try{
			int a = 0/0;
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	// Constructor Block
	Test() {
		System.out.println("Constructor called");
	}
}

public class StaticTest {
	public static void main(String args[]) {
		System.out.println(Test.i);
		Test t1 = new Test();
		Test t2 = new Test();
	}
}
