package com.main.java.thread;

public class RunnableThread implements Runnable {
    public void run() {
        System.out.println("running thread name is:" + Thread.currentThread().getName());
        System.out.println("running thread priority is:" + Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {
        RunnableThread object = new RunnableThread();
        Thread thread = new Thread(object);
        Thread thread1 = new Thread(object);
        Thread thread2 = new Thread(object);
        thread.setName("Ashish");
        thread1.setName("BBBBB");
        thread2.setName("CCCCC");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread.start();
        thread1.start();
        thread2.start();

    }
}
