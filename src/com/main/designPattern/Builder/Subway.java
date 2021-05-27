package com.main.designPattern.Builder;

// Product
public class Subway {

    private String breadType;
    private String sauce = "";


    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

}
