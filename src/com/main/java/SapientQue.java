package com.main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//class Parent{
//	Parent display(int i){
//		System.out.println("Parent");
//		return null;
//	}
//}

public class SapientQue extends Thread {

    // final static String str = "SSS";
    //
    // SapientQue display(int i){
    // System.out.println("Child");
    // return null;
    // }

    public void start() {
        System.out.println("Inside Start");
    }

    public static void main(String[] args) {

        try {
            Thread t = new Thread(new SapientQue());
            t.start();
            t.run();
            t.wait();

        } catch (Exception e) {
            System.out.println(e);
        }


//		
//		Thread t = new Thread(new SapientQue());
//		t.setName("POLO-1");
//		t.setPriority(10);
//		t.start();
//		
//		Thread t1 = new Thread(new SapientQue());
//		t1.setName("POLO-2");
//		t1.setPriority(1);
//		t1.start();

        // Parent p = new SapientQue();
        // p.display(5);

        // Date d1 = new Date();
        // System.out.println(fibonacci1(50));
        // Date d2 = new Date();
        // System.out.println((d2.getTime()-d1.getTime())/1000);
        //
        // Date d3 = new Date();
        // System.out.println(fibonacci2(50));
        // Date d4 = new Date();
        // System.out.println((d4.getTime()-d3.getTime())/1000);

        // int x = 5;
        //
        // boolean t1 = true;
        // boolean t2 = false;
        //
        // if((x==4) && !t2)
        // System.out.println("1");
        //
        // System.out.println("2");
        //
        // if((t2=true) && t1)
        // System.out.println("3");
        //
        //
        // if( (t2=true) )
        // System.out.println("33");
        //
        // System.out.println(t2);

        // String x = new String("test");
        // String y = new String("test");
        //
        // System.out.println(x == y);
        // System.out.println(x.equals(y));

        // int i=0;
        //
        // for(int i=0; i < 2; i++){
        // System.out.println(i);
        // }

        // SapientQue s = new SapientQue();
        // System.out.println(s.check());

        // List l = new ArrayList<>();
        // SapientQue a = new SapientQue();
        //
        // SapientQue b = new SapientQue();
        // l.add(a);
        // l.add(b);
        //
        // Collections.sort(l);
        //
        // for(int i=0; i < l.size(); i++){
        // System.out.println(l.get(i));
        // }

        // String str = "ABC";
        // System.out.println(str);

    }

    // static {
    // String str = "Hi";
    // str = "XYZ";
    // System.out.println(SapientQue.str);
    // }

    // int check(){
    // int x = 3;
    // try{
    // //throw new IOException();
    // return 44;
    // }catch(Exception e){
    // System.out.println("catch block");
    // x = 4;
    // return x;
    // }finally{
    // System.out.println("Finally Running"+x);
    // x = 5;
    // return x;
    // }
    // }

    // public static <E> void append(List<E> list){
    // E elem = new E();
    // list.add(e);
    // }

    private static int fibonacci1(int index) {
        if (index == 1 || index == 2) {
            return 1;
        }
        return fibonacci1(index - 1) + fibonacci1(index - 2);
    }

    private static Map<Integer, Integer> map1 = new HashMap<>();

    private static int fibonacci2(int index) {
        if (map1.containsKey(index)) {
            return map1.get(index);
        }
        if (index == 1 || index == 2) {
            map1.put(index, 1);
        } else {
            map1.put(index, fibonacci2(index - 1) + fibonacci2(index - 2));
        }
        return map1.get(index);
    }

    public void run() {
        System.out.println("Inside Run");
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
    }

}
