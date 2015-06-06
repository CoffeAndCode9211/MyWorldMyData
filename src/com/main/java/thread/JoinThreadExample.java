package com.main.java.thread;

class JoinThreadExample extends Thread{  
	public void run(){  
		for(int i=1;i<=5;i++){  
			try{  
				Thread.sleep(500);  
			}catch(Exception e){System.out.println(e);}  
			System.out.println(Thread.currentThread().getName());  
		}  
	}  
	public static void main(String args[]){  
		JoinThreadExample t1=new JoinThreadExample();  
		JoinThreadExample t2=new JoinThreadExample();  
		JoinThreadExample t3=new JoinThreadExample();  
		t1.start();  
		try{  
			//t1.join();  
			t1.join(1500); 
		}catch(Exception e){System.out.println(e);}  

		t2.start();  
		t3.start();  
	}  
}  
