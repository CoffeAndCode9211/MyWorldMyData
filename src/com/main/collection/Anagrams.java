package com.main.collection;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {

	public static void main(String[] args) {
		int minGroupSize =6;

		// Read words from file and put into a simulated multimap
		Map<String, List<String>> m = new HashMap<>();
		try {
			InputStream stream = Anagrams.class.getResourceAsStream("dictionary.txt");
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
			while (reader.readLine() != null) {
				String word = reader.readLine();
				String alpha = alphabetize(word);
				List<String> l = m.get(alpha);
				if (l == null)
					m.put(alpha, l=new ArrayList<String>());
				l.add(word);
			}
		} catch (Exception e) {
			System.err.println(e);
			System.exit(1);
		}

		// Print all permutation groups above size threshold
		for (List<String> l : m.values())
			if (l.size() >= minGroupSize)
				System.out.println(l.size() + ": " + l);
	}

	private static String alphabetize(String s) {
		char[] a = s.toCharArray();
		Arrays.sort(a);
		return new String(a);
	}
}
