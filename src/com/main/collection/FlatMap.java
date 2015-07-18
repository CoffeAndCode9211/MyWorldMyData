package com.main.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



/* Convert list of list to list  */
public class FlatMap {
	public static void main(String[] args) {
		List<List<Object>> list = new ArrayList<>();
				List<Object> lst = list.stream()
				        .flatMap(x -> x.stream())
				        .collect(Collectors.toList());
	}
}
