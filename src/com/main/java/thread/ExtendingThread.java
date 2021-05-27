package com.main.java.thread;

public class ExtendingThread extends Thread {
    public void run() {
        System.out.println("thread is running...");
    }

    public static void main(String[] args) {
        ExtendingThread thread = new ExtendingThread();
        thread.start();
    }
}
