package com.main.java;

import com.main.designPattern.Singelton.Singleton;

public class DoubleCheckedSingleton {


    /*
    until you make _instance variable volatile.
    Without volatile modifier it's possible for
    another thread in Java to see half initialized
    state of _instance variable, but with volatile
    variable guaranteeing happens-before relationship,
    all the write will happen on
    volatile _instance before any read of _instance variable.

    */
    private volatile static DoubleCheckedSingleton instance;

    private DoubleCheckedSingleton() {
    }

    /**
     * avoid multiple object creation
     */
    public static DoubleCheckedSingleton getInstanceDC() {
        if (instance == null) { // Single Checked
            synchronized (Singleton.class) {
                if (instance == null) { // Double checked
                    instance = new DoubleCheckedSingleton();
                }
            }
        }
        return instance;
    }


/*
	public static synchronized Singleton getInstanceTS() 
	{ 
		if (_instance == null) 
		{ 
			_instance = new Singleton(); 
		}
		return _instance; 
	}
*/


}


