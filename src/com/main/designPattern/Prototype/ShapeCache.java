package com.main.designPattern.Prototype;

import java.util.Hashtable;

public class ShapeCache {

	private static Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();

	public static Shape getShape(String shapeId) {
		Shape cachedShape = shapeMap.get(shapeId);
		return (Shape) cachedShape.clone();
	}

	// for each shape run database query and create shape
	// shapeMap.put(shapeKey, shape);
	// for example, we are adding two shapes

	public static void loadCache() {
		Triangle triangle = new Triangle();
		triangle.setId("1");
		shapeMap.put(triangle.getId(), triangle);

		Square square = new Square();
		square.setId("2");
		shapeMap.put(square.getId(), square);

		
	}
}
