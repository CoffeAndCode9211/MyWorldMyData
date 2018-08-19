package com.main.blog;

public class JavaHeapStack {
	
	static int i=0;  // Static Variable
	int a = 12; // Instance Variable
	
	public static void main(String[] args) { 
		int i=1;  // Local Variable
		Object obj = new Object(); 
		JavaHeapStack mem = new JavaHeapStack(); 
		mem.foo(obj); 
	}

	private void foo(Object param) { 
		String str = param.toString(); 
		System.out.println(str);
	} 
}
