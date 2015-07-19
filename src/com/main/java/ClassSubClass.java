package com.main.java;

public class ClassSubClass {
	public static void main(String[] args) {
		System.out.println(" " + bogo(new Extension()));
	}

	static int bogo(Base b) {
		return b.add(8);
	}
}


class Base {
	protected int i;

	Base() {
		System.out.println("Base Class Constructor: "+i);
		add(1);
	}

	int add(int v) {
		System.out.println("Base Class Add: "+i);
		return i += v;
	}
}

class Extension extends Base {
	Extension() {
		System.out.println("Extension Class Constructor: "+i);
		add(1);
	}

	int add(int v) {
		System.out.println("Extension Class Add: "+i);
		return i += v * 2;
	}
}

/* 
 As soon as sub class or child class;s constructor is called first base class or parent class constructor is called
 then sub class constructor
 
 
 OUTPUT:
 
	Base Class Constructor: 0
	Extension Class Add: 0
	Extension Class Constructor: 2
	Extension Class Add: 2
	Extension Class Add: 4
	20
 
 */