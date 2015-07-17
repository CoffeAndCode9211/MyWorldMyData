package com.main.collection;

//return true if a is perfect power of b in java
class SortOnKey {
	public static boolean isPower(int x, int y) {

		// logy(x) should be an integer
		double d = Math.log(Math.abs(x)) / Math.log(Math.abs(y));

		if ((x > 0 && y > 0) || (x < 0 && y < 0)) {
			if (d == (int) d) {
				return true;
			} else {
				return false;
			}
		} else if (x > 0 && y < 0) {
			if ((int) d % 2 == 0) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(isPower(-32, -2));
		System.out.println(isPower(2, 8));
		System.out.println(isPower(8, 12));
		System.out.println(isPower(9, 9));
		System.out.println(isPower(-16, 2));
		System.out.println(isPower(-8, -2));
		System.out.println(isPower(16, -2));
		System.out.println(isPower(8, -2));


		int sum=0;  int n=123456;    
		  while(n>9){
		   int rem;
		   rem=n%10;
		   sum=sum+rem;
		   n=n/10;
		   if(n<9) {
		      sum+=n;
		      n=sum;
		      sum=0;
		   }
		  }
		  System.out.println(n);



	}

}