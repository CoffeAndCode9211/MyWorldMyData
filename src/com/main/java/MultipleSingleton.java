package com.main.java;

public class MultipleSingleton {
    private static MultipleSingleton instance;

    private MultipleSingleton() {
    }

    /**
     * this code will create multiple instances of Singleton class if called by more than one thread parallel
     */
    public static MultipleSingleton getInstance() {
        if (instance == null) {
            instance = new MultipleSingleton();
        }
        return instance;
    }


}


