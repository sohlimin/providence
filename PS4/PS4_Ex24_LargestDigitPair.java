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

class LargestDigitPair {
  
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
		
		if (num < 1000) { // the leftest most pair and the only pair is the largest pair
			
			return num % 100;

		} else if (num < 100) {
			
			return num;

		} else { // 4 or more digits
			
			int lpair = (num / 100) % 100;			
			int llpair = (num / 10000) % 100;
			if (lpair > num % 100) {
				
				return largestDigitPair(num/100); //if the left pair is consistently bigger than the right pair, then the left most, also largest pair will be at the last recursion 
						
			} else { //but if the right pair is larger, we need to remove the left pair from consideration and also keep the right pair in consideration
				if (llpair > num % 100) {
					return largestDigitPair(num/10000);
				} else { //if the right pair is STILL larger, then i dont know what the fk to do
					return num % 100;
				}

			}	
		}
 
  	}
}
