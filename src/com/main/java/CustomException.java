package com.main.java;

public class CustomException extends Exception{

	private static final long serialVersionUID = 1L;

	CustomException(String msg){
		super(msg);
	}
}
