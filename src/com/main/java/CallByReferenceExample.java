package com.main.java;

class TestData {
	int a, b;
	TestData(int i, int j) {
		a = i;
		b = j; 
	}
	// pass an object
	void meth(TestData o) {
		o.a *= 2;
		o.b /= 2;
	}
}

public class CallByReferenceExample {

	public static void main(String args[]) {
		TestData ob = new TestData(15, 20);
		System.out.println("ob.a and ob.b before call: " + ob.a + " " + ob.b);
		ob.meth(ob);
		System.out.println("ob.a and ob.b after call: " + ob.a + " " + ob.b);
	}

}
