/*
 * CS1010J Programming Methodology
 * Problem Set 4 Exercise #19: PS4_Ex19_RecursiveSum.java
 * 
 * This program prints f(x) whose value
 * is given by the recursive formula.
 * 
 * Soh Li Min
 */

import java.util.*;

class RecursiveSum {
  
  	public static void main(String[] args) {  // complete
    
    		Scanner scanner = new Scanner(System.in);
    
    		System.out.print("Enter x (x >= 0): ");
    		int x = scanner.nextInt();
    
    		System.out.println("f(x) = " + f(x));
  	}
  
  	// Calculate f(x) according to recursive formula
  	// Pre-cond: x >= 0
  	public static int f(int x) {
    		if (x < 0) {
			return -1;
		} else if (x == 0 || x == 1 || x == 2){
			return 1;
		} else if (x % 2 == 0) {
			return f(x - 1) + f(x - 2) + f(x - 3);
		} else {
			return f(x - 1) + f(x - 2);
		}
  
  	}
}
