package com.main.designPattern.Builder;


/* A customer ordering a Sub. */
public class SubBuilderMain {

	public static void main(String[] args) {
		Waiter waiter = new Waiter();
		SubwayBuilder vegSub = new VegSubBuilder();
		SubwayBuilder chknSub = new ChickenSubBuilder();
		
		waiter.setSubwayBuilder(vegSub);
		waiter.constructSub();
		
		Subway sub = waiter.getSub();
		
		
	}

}
