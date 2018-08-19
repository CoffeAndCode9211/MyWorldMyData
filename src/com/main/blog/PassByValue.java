package com.main.blog;

class Bike {

	private String color;

	public Bike(){}
	
	public Bike(String c){
		this.color=c;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}


public class PassByValue {
	public static void main(String[] args) {

		Bike red = new Bike("Red"); //memory reference 50
		Bike blue = new Bike("Blue"); //memory reference 100
		
		swap(red, blue);
		System.out.println("red color="+red.getColor());
		System.out.println("blue color="+blue.getColor());
		
		foo(blue);
		System.out.println("blue color="+blue.getColor());
		
	}

	private static void foo(Bike bike) { //bike=100
		bike.setColor("Red"); //bike=100
		bike = new Bike("Green"); //bike=200
		bike.setColor("Blue"); //bike = 200
	}

	//Generic swap method
	public static void swap(Object o1, Object o2){ //o1=50, o2=100
		Object temp = o1; //temp=50, o1=50, o2=100
		o1=o2; //temp=50, o1=100, o2=100
		o2=temp; //temp=50, o1=100, o2=50
	} //method terminated
	
	
}
