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
		int a = 0;
		try{
			System.out.println(1);
			int data = 4 /2;
			System.out.println(2);
			try {
				int b = 10 / a;
				System.out.println(3);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(4);
				//	return;
			}finally{
				System.out.println(5);
			}
			System.out.println(6);


			int q = 123/0;

			System.out.println(7);
			a = 0;
			try{
				int b = 10 / a;
				System.out.println(8);
			}catch(Exception e){
				e.printStackTrace();
				return;
			}finally{
				System.out.println("Final Finally");
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("main catch");
		}

	}
}
