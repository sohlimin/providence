/*
 * CS1010J Programming Methodology
 * Problem Set 4 Exercise #24: PS4_Ex24_LargestDigitPair.java
 * 
 * This program determines the largest pair of digits
 * of a positive integer num.
 * 
 * Soh Li Min
 */

import java.util.*;

class LargestDigitPair2 {
  
	public static void main(String[] args) {
    
    		System.out.print("Enter a positive integer: ");
    		Scanner s = new Scanner(System.in);
    		int number = s.nextInt();
		int ldp = largestDigitPair(number);
		System.out.println("Largest pair of digits in " + number + " is " + ldp );
  	}
  
  	// Return the largest digit pairs in num
  	// Pre-cond: num > 0
  	public static int largestDigitPair(int num) {
		
		if (num == 0) { // the leftest most pair and the only pair is the largest pair
			
			return 0;

		} else if (num < 100) {
			
			return num;

		} 
			
		int rpair = num % 100;			
		int ldigits = num / 100;
				
		int recursiveRpair = largestDigitPair(ldigits);
		return Math.max(rpair, recursiveRpair);

  	}
}
