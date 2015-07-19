package com.main.collection;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueExample {
	public static void main(String[] args) {

		
		
		Queue<String> queue = new PriorityQueue();
		queue.add("d");
		queue.offer("qqqq");
		System.out.println(queue.poll());
		System.out.println(queue.element());
		System.out.println(queue.element());
		
		
	}
}
