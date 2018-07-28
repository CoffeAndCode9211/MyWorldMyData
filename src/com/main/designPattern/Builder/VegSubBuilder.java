package com.main.designPattern.Builder;

/* "ConcreteBuilder" */
public class VegSubBuilder extends SubwayBuilder{

	@Override
	public void buildBread() {
		subway.setBreadType("HoneyComb");
	}

	@Override
	public void buildTopping() {
		subway.setSauce("SweetHoney");
	}

}
