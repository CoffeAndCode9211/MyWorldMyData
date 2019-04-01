package com.main.blog;

class MainData {
	String a;
	
	public void getData(){
		System.out.println("A");
	}
}

public class TestData extends MainData {

	String b;
	
	public void getData(){
		System.out.println("B");
	}

	
	public static void main(String[] args) {
		MainData a = new TestData();
		a.getData();
	}
}
