package com.main.java;

public enum EnumSingleton {


    /*  enum fields are compile time constants,
     * but they are instances of their enum type.
     * And, they're constructed when the enum type is referenced for the first time   */
    INSTANCE;  // public static final MySingleton INSTANCE = new MySingleton();
}
