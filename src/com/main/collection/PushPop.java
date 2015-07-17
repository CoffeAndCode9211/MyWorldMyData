package com.main.collection;

import java.util.Stack;

public class PushPop {

	
	public static void main(String[] args) {
		
		String data = "This is sfks sdhfkjsh)kdahflhl";
		Stack<Character> st = new Stack();
		
		for(char c : data.toCharArray()){
			if(c == '('){
				st.push(c);
			}else if(c == ')' && st.size() > 0){
				
				st.pop();
			}
		}
		System.out.println(st.size());
		
	}
	
}
