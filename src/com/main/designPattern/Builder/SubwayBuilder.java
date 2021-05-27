package com.main.designPattern.Builder;

/* "Abstract Builder" */
public abstract class SubwayBuilder {
    protected Subway subway;

    public Subway getSubway() {
        return subway;
    }

    public void newSubway() {
        subway = new Subway();
    }

    public abstract void buildBread();

    public abstract void buildTopping();

}
