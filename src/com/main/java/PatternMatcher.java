package com.main.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {

	public static void main(String[] args) {
		String URL = "Hellow this is my worlod";
		Pattern pattern = Pattern.compile("o");
		Matcher matcher = pattern.matcher(URL);
		if (matcher.find()) {
		    System.out.println(matcher.group().length()); 
		} else {
		    System.out.println("Match not found");
		}
	}
}
