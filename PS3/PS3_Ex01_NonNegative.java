/*
 * CS1010J Programming Methodology
 * Problem Set 3 Exercise #01: PS3_Ex01_NonNegative.java
 * 
 * Returns true if all elements in arr is non-negative.
 * 
 * Soh Li Min
 */

import java.util.*;

class NonNegative {
  
  	public static void main(String[] args) {
    
    		System.out.print("Enter the size of the array: ");
    		Scanner s = new Scanner(System.in);
    		int size = s.nextInt();
    		System.out.print("Enter " + size + " elements: ");
    		int[] stuff = new int[size];
		
		for (int i = 0 ; i < size ; i++) {
			stuff[i] = s.nextInt();
		}
		boolean isNonNeg = nonNegative(stuff);
		if (isNonNeg) {
    			System.out.println("All array elements are non-negative");
		} else {
    			System.out.println("Some array elements are negative");
		}
	}
  
  	public static boolean nonNegative(int[] arr) {
    		for ( int p : arr ) {
			if (p < 0) {
				return false;
			}
		}
    		return true;  
    
  	}
}
