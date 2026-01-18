/*
 * CS1010J Programming Methodology
 * Problem Set 4 Exercise #27: PS4_Ex27_OddDigitSum.java
 * 
 * This program checks if the sum of all digits of
 * a given number is odd.
 * 
 * Soh Li Min
 */

import java.util.*;

class OddDigitSum {
  
  	public static void main(String[] args) {
    
    		System.out.print("Enter a positive integer: ");
    		Scanner s = new Scanner(System.in);
    		int numb = s.nextInt();
		boolean b = isDigitSumOdd(numb);
		if (!b) {
    			System.out.println("Sum of digits for " + numb + " is even");
		} else {
			System.out.println("Sum of digits for " + numb + " is odd");
  		}
	}
  	// Return true if the sum of all digits is odd, or false otherwise.
  	// Pre-cond: num > 0
  	public static boolean isDigitSumOdd(int num) {
    		return num == 1;
			
		if (num < 10) {
			return num % 2 != 0;
				
		} else { 

			int rDigit = num % 10; //gets rightmost digit
		 	
			if (isDigitSumOdd(num / 10)) { //winding to get to base case
    
				return rDigit % 2 == 0; //these steps execute during unwinding. namely, is rDigit to the right of the base case odd or even? 
			} else { 
				return rDigit % 2 != 0; 	
			}
  		}
		return false;
	}
}
