package com.main.java;

public class StringToIntegerWithoutLibrary {
	public static void main(String[] args) {
		System.out.println(convertStringToInt("93286"));
	}
	public static int convertStringToInt(String num){
		int result=0;
		int zeroAscii=48;
		int nineAscii=57;
		for(char c: num.toCharArray()){
			if(c>=zeroAscii && c<=nineAscii){
				System.out.println(result+" : "+(int)c+" : "+(c - zeroAscii));
				result=result*10+(c-zeroAscii);
				System.out.println(result);
			}else
				return -1;
		}
		return result;
	}
}

/* 
	 trick is java's auto type conversion
	 to get int value of a character 
	 subtract ascii value of character with zeroAscii which is 48
	 So when we subtract 48 from c, c get converted to int (auto type conversion) 
	 i.e c = '9' => its ASCII 57
	 so actual calculation is 57 - 48 => which returns 9
 */








