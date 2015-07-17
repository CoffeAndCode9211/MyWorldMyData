package com.main.hackerearth;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Solution {

	static int[] manipulateArray(int[] inputArray) {
		int[] result = new int[inputArray.length];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int data : inputArray ){
			Integer freq = map.get(data);
			map.put(data, (freq == null ? 1: freq+1 ) );
		}
		
		Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
		int count = 0;
	    while ( it.hasNext() ) {
	       Map.Entry entry = (Map.Entry) it.next();
	       Integer key = (Integer) entry.getKey();
	       Integer value = (Integer) entry.getValue();
	       System.out.println(key + " => " + value);
	      
	    }//while
	    
		
		System.out.println(map.toString());
		
		
		
		return inputArray;
    }
	
	public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int[] res;
        
        int _inputArray_size = Integer.parseInt(in.nextLine());
        int[] _inputArray = new int[_inputArray_size];
        int _inputArray_item;
        for(int _inputArray_i = 0; _inputArray_i < _inputArray_size; _inputArray_i++) {
            _inputArray_item = Integer.parseInt(in.nextLine());
            _inputArray[_inputArray_i] = _inputArray_item;
        }
        
        res = manipulateArray(_inputArray);
        for(int res_i=0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }
        
        bw.close();
    }
	
	
}
