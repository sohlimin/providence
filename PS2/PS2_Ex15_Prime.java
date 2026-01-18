/*
 * CS1010J Programming Methodology
 * Problem Set 2 Exercise #15: PS2_Ex15_Prime.java
 * 
 * <Fill in a short description of this program>
 * 
 * 
 *Soh Li Min
 */

import java.util.Scanner;

class Prime {
  
	public static void main(String[] args) {
    
    		System.out.print("Enter a positive integer: ");
    		Scanner sc = new Scanner(System.in); 
		int input = sc.nextInt();
		boolean prime = isPrime(input);
		if (prime){
		System.out.println(input + " is a prime");
		} else {
    		System.out.println(input + " is not a prime");
  		}
	}
  
  	// <Write a short description of the method here>
  	public static boolean isPrime(int num) {
    		
		
		if (num % 2 == 0 || num % 3 == 0) { //divide by the smallest primes (most common divisors) 
			return false;
		} else if (num % 5 == 0 || num % 7 == 0) {
			return false;
		} else {
			for (int i = 11; i < num; i++) { // we want loop to stop at the first found divisor 'i'
						    // but i dont know how to NOT check for multiples of primes as the divisor - ideally(most efficiently), increment should skip to the next prime  
				if (num % i == 0) {
					return false;
				}
			}
    			return true;
  		}
	}
}
