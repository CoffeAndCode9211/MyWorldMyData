package com.main.java;

public class ExceptionFlow {

	/** 
	 * if we dont use try catch than in case of any exception sequence breaks and further code doesnt get executed so 
	 * in that case 4 will not get executed 
	 * if we use try catch than 4 will get printed 
	 * if we return in try block then before that finally block gets executed 
	 * 
	 * 
	 * */
	
	public static void main(String[] args) {
		int a =1;
		try {
			int b = 10 / a;
			
			System.out.println(1);
			return;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(2);
		//	return;
		}finally{
			System.out.println(3);
		}
		System.out.println(4);
		
		
	}
}
