/*
 * CS1010J Programming Methodology
 * Problem Set 2 Exercise #10: PS2_Ex10_Collatz.java
 * 
 * <Fill in a short description of this program>
 * 
 * 
 * Soh Li Min
 */

import java.util.Scanner;

class Collatz {
  
 	 public static void main(String[] args) {
    
    		System.out.print("Enter a natural number: ");
    		
		Scanner sc = new Scanner(System.in);
    		int input = sc.nextInt();
    
    		int iterationz = countIterations(input);
    
    		System.out.println("Number of iterations = " + iterationz );
  	}
  
  	// Calculate how many rounds are needed to process n till 1
  	public static int countIterations(int n) {
    		
		int noIterations = 0;
		
		while (n != 1) {
			if (n % 2 == 0) {
    				n /= 2;
			} else {
				n = 3 * n + 1;
			}
		noIterations++;
  		}
		return noIterations;
	}
}
