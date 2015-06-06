package com.main.java;

public class TempException {

	static Integer validate(int age){
		Integer a = 0 ;
		try{
			a =  12/0;
		}catch(Exception e){
			//	e.printStackTrace();
			throw e;
		}
		return a;
	}



	public static void main(String[] args) {
		try{
			Integer a = validate(12);
			System.out.println("exception lost"+a);
		}catch(ArithmeticException e){
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}
}
