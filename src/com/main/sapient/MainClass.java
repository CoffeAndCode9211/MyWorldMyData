package com.main.sapient;

import java.util.Scanner;

public class MainClass {

	public static void main(String args[] ) throws Exception {
       
    
        //Scanner
        Scanner s = new Scanner(System.in);
        int dim = Integer.parseInt(s.nextLine());
        int no = Integer.parseInt(s.nextLine());
        while(no > 0){
            String[] phoDim = s.nextLine().split(" +");
            int dim1 = Integer.parseInt(phoDim[0]);
            int dim2 = Integer.parseInt(phoDim[1]);
            
            if(dim1 <= dim || dim2 <= dim){
                System.out.println("UPLOAD ANOTHER");
            }else if(dim1 >= dim && dim2 >= dim){
            	if(dim1 == dim2){
            		System.out.println("ACCEPTED");
            	}else{
            		System.out.println("CROP IT");
            	}
            }
            no--;
        }
       

    }
	
}
