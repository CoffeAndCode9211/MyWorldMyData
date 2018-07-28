package com.main.designPattern.FactoryPattern;

public class ShapeFactory {

	//use getShape method to get object of type shape 
	public Shape getShape(String shapeType){
		if(shapeType == null){
			return null;
		}		
		if(shapeType.equalsIgnoreCase("TRIANGLE")){
			return new Triangle();

		}  else if(shapeType.equalsIgnoreCase("SQUARE")){
			return new Square();
		}

		return null;
	}
}
