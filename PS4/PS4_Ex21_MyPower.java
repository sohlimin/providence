/*
 * CS1010J Programming Methodology
 * Problem Set 4 Exercise #21: PS4_Ex21_MyPower.java
 * 
 * This program computes the nth power of x,
 * where n is a non-negative integer.
 * 
 *  Soh Li Min
 */

import java.util.*;
import java.text.*;

class MyPower {
  
  	public static void main(String[] args) {  // complete
    
    		Scanner scanner = new Scanner(System.in);
    
    		System.out.print("Enter x and n: ");
    		double x = scanner.nextDouble();
    		int n = scanner.nextInt();
    
    		DecimalFormat df = new DecimalFormat("0.00");
    		System.out.println("myPow(" + x + ", " + n + ") = " + df.format(myPow(x, n)));
  	}
  
  	// Compute the nth power of x
  	// Pre-cond: n >= 0
  	public static double myPow(double x, int n) {
    		if (n < 0) {
			return -1;
		} else if (n == 0) {
			return 1;
		} else {
			return x * myPow(x , n - 1);
		}
  	}
}
