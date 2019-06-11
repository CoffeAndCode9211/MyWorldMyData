package com.main.interview;

public class SameObjTypeMeth {
	public static void main(String[] args) {
		SameObjTypeMeth obj = new SameObjTypeMeth();
		obj.test1(1,2);
	}

	void test1(int a, Integer b){
		System.out.println("int and Integer");
	}
	
	void test1(int a, int b){
		System.out.println("int and int");
	}
	
	void test1(int... a){
		System.out.println("int array");
	}
	
}
