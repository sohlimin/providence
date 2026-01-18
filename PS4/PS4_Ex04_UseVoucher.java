/*
 * CS1010J Programming Methodology
 * Problem Set 4 Exercise #04: PS4_Ex04_UseVoucher.java
 * 
 * This program helps Mr. Tan to use a couple of vouchers
 * wisely together with cash such that there is no overpay anytime.
 * 
 *Soh Li Min
 */

import java.util.*;

class UseVoucher {
  

  	public static void main(String[] args) {
    
   		Scanner sc = new Scanner(System.in);
   		System.out.print("Enter voucher name: ");
		String name = sc.next();
    		
    		System.out.print("Enter voucher face value: $");
    		int faceVal = sc.nextInt();
    
    		System.out.print("Enter the number of vouchers: ");
    		int num = sc.nextInt();
    
    		// create a Voucher object with 3 values read
    		Voucher v = new Voucher(name, faceVal, num);
    
    		System.out.print("Enter the price to pay: $");
    		int price = sc.nextInt();
   		 
    		int c = price - v.useVoucher(price) * v.getValue();
    		int vRemaining = v.getAmt() - v.useVoucher(price);
    		// Call useVoucher() method to compute the number of vouchers to be used
    		System.out.println("Use " + v.useVoucher(price) + " " + v.getName() + " voucher(s)");
    		System.out.println("Cash payment: $" + c);
    		System.out.println("There remains " + vRemaining + " voucher(s)");
  	}
}
