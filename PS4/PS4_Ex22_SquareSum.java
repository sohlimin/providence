/*
 * CS1010J Programming Methodology
 * Problem Set 4 Exercise #22: PS4_Ex22_SquareSum.java
 * 
 * This program reads a positive integer,
 * and returns the sum of all its digits in square.
 * 
 * Soh Li Min 
 */

import java.util.*;

class SquareSum {
  
  	public static void main(String[] args) {
    
    		System.out.print("Enter a positive integer: ");
    		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int result = squareSum(number);
		
    		System.out.println("Square sum of all digits is " + result );
  	}
  
  	// Calculate the square sum of all digits in a given number
  	// Pre-cond: number > 0
  	public static int squareSum(int n) {
    		//if (n == 0) {
		//	return 0;
		if (n < 10) {
			return n * n;
		} else {
			int r = n % 10;	
			return r * r + squareSum(n / 10);
		}
	}
    		
	//begin finding base case is the easiest possible case. think about the slightly more complex version, work it out on a piece of paper 	
		
	
}

