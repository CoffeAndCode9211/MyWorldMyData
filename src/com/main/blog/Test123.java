package com.main.blog;

class Food {
	
	int good = 3;
	void show(){
		System.out.println(good);
	}
}
class Fruit extends Food {
	
	int good = 4;
	void show(){
		System.out.println(good);
	}
}

public class Test123 extends Food {
	public static void main(String[] args) {
		Fruit a = new Fruit();
		a.show();
		
		Food b = new Fruit();
		a.show();
		
	}
}
