/*
 * CS1010J Programming Methodology
 * Problem Set 4 Exercise #23: PS4_Ex23_Contains.java
 * 
 * This program checks if digit 'k' appears in 'number'.
 * 
 * Soh
 */

import java.util.*;

class Contains {
  
  public static void main(String[] args) {
    
    System.out.print("Enter a positive integer: ");
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    System.out.print("Enter a single digit integer k: ");
    int k = s.nextInt();

    if (contains(n, k)) {
    	System.out.println( k + " appears in " + n );
    } else {
    	System.out.println( k + " doesn't appear in " + n );
    }
    }
  
  // Check if k appears in any digit of number
  // Return true if so, or false otherwise
  // Pre-cond: number > 0, k < 10 && k >= 0
  public static boolean contains(int number, int k) {
	if (number == k) {
		return true;
    	} else if (number > 9) {
		if (!contains(number % 10, k)) {
			return contains(number / 10, k);
		} else {
		       return true;	
		}
	} 
	return false;
  }
}
