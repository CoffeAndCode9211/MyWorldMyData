package com.main.designPattern.Builder;

/* "ConcreteBuilder" */
public class ChickenSubBuilder extends SubwayBuilder {

    @Override
    public void buildBread() {
        subway.setBreadType("Wheat");
    }

    @Override
    public void buildTopping() {
        subway.setSauce("Mustord");
    }

}
