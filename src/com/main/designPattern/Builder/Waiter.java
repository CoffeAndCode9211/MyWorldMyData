package com.main.designPattern.Builder;

/* "Director" */
public class Waiter {
	private SubwayBuilder subwayBuilder;
	
	public void setSubwayBuilder(SubwayBuilder sub){
		subwayBuilder = sub;
	}
	
	public Subway getSub(){
		return subwayBuilder.getSubway();
	}
	
	public void constructSub() {
		subwayBuilder.newSubway();
		subwayBuilder.buildBread();
		subwayBuilder.buildTopping();
    }
	
}
