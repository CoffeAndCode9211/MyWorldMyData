package com.main.interview;

import java.util.Hashtable;

public class StringEquals {
	
	
	public static void main(String [] args){ 

		
		System.out.println("**********String Equals**********");
		String fstr= new String("Javatutorials");
		String sstr= new String("Javatutorials"); 

		System.out.println(fstr.equals(sstr));
		System.out.println(fstr==sstr);

		System.out.println(fstr.hashCode());
		System.out.println(sstr.hashCode());
		/*
		 * 
		 * Output:
		  
		 
		 	true
			false
			1921912019
			1921912019
			
		 	we compared two string using equals() method and it returns true.and comparing using == operator returns false.
			Basically equal() will also return false on comparing those two strings because default functionality of equal() 
			method is to compare references and two strings are created using new operator so both references are different.
			But String class overriding equals() method and in that equals method it comparing content of the strings and returning 
			true if both are having same content false if not.
		  */
		
		System.out.println("**********StringBuffer Equals**********");
		
		StringBuffer aa= new StringBuffer("Javatutorials");
		StringBuffer bb= new StringBuffer("Javatutorials"); 
		 
		System.out.println(aa.equals(bb));
		System.out.println(aa==bb);
		 
		System.out.println(aa.hashCode());
		System.out.println(bb.hashCode());
		
		/*
		 Output:
		 	false
			false
			366712642
			1829164700
			
			If you observe above java program when we are comparing two stringBuffer objects equal() method returning 
			false even content is same. Because StringBuffer class not overriding equals() and hashcode() methods.
			StringBuilder is also not overriding equals() method
				
		 	Basically Strings are Immutable means Whenever we try to change the value of string result will be new string. So string content wont change.
			StringBuffer main use is mutable means when we append a string to it it will add to existing object.
			When the content changes the hashcode will changes.
			

		 */
		
		System.out.println("**********Hashtable with String key**********");
		
		
		Hashtable<CharSequence, String> ht=new Hashtable<CharSequence, String>();
		 
        ht.put(fstr, "abc");
        ht.put(sstr, "xyz");
        
        System.out.println(ht);
        //  In the above java program we tried to add two strings objects as keys to the hashtable.
        //  Hashtable put method internally calles equals() method and if its true it wont add.
		
        System.out.println("**********Hashtable with StringBuffer key**********");
        
        ht.clear();
        ht.put(aa, "abc");
        ht.put(bb, "xyz");
        
        System.out.println(ht);
		
	}
}
