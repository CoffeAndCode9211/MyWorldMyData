package com.main.blog;

class Base
{
     public void foo(int i)
     {
     	System.out.println("Inside foo(int i) i= " + i);
     }
}

class Derived extends Base
{
     public void foo(float f)
     {
     	System.out.println("Inside foo(float f) f= " + f);
     }
}

public class OverRiddingHiding
{
     public static void main(String[] args)
     {
     	float  f = 1.2f;
     	int    i = 100;
     	Derived obj = new Derived();
     	obj.foo(i);               
     	obj.foo(f);       
     }
}
