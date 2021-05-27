package com.main.designPattern.Singelton;

public class Singleton {


    /* singleton with static factory method  */
    static Singleton singleton = new Singleton();

    /* A private Constructor prevents any other
     * class from instantiating.
     */
    private Singleton() {
    }

    /* Static 'instance' method */
    public static Singleton getInstance() {
        return singleton;
    }

    /* Other methods protected by singleton-ness */
    public static void demoMethod() {
        System.out.println("demoMethod for singleton");
    }
}


	