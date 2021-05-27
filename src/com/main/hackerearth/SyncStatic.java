package com.main.hackerearth;

public class SyncStatic {
    public static void main(String[] args) {
        System.out.println("Main");
        SyncStatic a = new SyncStatic();
        a.print(args);

    }

    static {
        System.out.println("Static");
    }

//	synchronized(this)
//	{
//		System.out.println("sync");
//	}

    public void print(String[] args) {
        try {
            System.out.println(args[0]);

        } catch (NullPointerException ne) {
            System.out.println("Null Pointer");
        } catch (IndexOutOfBoundsException ne) {
            System.out.println("Index Out of Bound");
        }

    }

}
