package com.main.java;

public class CustomException extends Exception{


	private static final long serialVersionUID = 1L;
	
	CustomException(){
		
	}
	
	CustomException(String msg){
		super(msg);
	}
	
	CustomException(String msg, Exception e){
		super(msg, e);
	}
	
	public CustomException(Throwable cause)
	{
		super(cause);
	}
	
	
	
}
