package com.main.java;

public class UserException {

	public static TestUserTO getUserData() {
		TestUserTO user = new TestUserTO();
		try{
			user.setUserId(Integer.parseInt("qw"));
			user.setUserName("TestData");
			user.setUserRollNo(null);
		}catch(Exception e){
			//e.printStackTrace();
			throw e;
		}
		return user;

	}


	public static void main(String[] args) throws CustomException {
		try{
			getUserData();
		}catch(Exception e){
			//e.printStackTrace();
			throw new CustomException("Parse exception "+e.getMessage());
		}
	}



}
