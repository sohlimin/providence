/*
 * CS1010J Programming Methodology
 * Problem Set 4 Exercise #28: PS4_Ex28_Addition.java
 * 
 * This program computes the sum of two integers in a recursive way.
 * 
 * Soh Li Min
 */

import java.util.*;

class Addition {
  
  	public static void main(String[] args) {
    
    		System.out.print("Enter two positive integers: ");
    		Scanner s = new Scanner(System.in);
    		int num1 = s.nextInt();
    		int num2 = s.nextInt();
		int sum = add(num1, num2, 0);
    		System.out.println("Sum = " + sum);
  	}
  
  	// Add two integers recursively by adding digits in corresponding
  	// columns together with carry.
  	public static int add(int num1, int num2, int carry) {
    		if (num1 == 0 && num2 == 0 && carry == 0) {	//base case
			System.out.print("fag");
			return 0;
		}
		
		
		
		System.out.print("bitch");
		int rDigit1 = num1 % 10;
		int rDigit2 = num2 % 10; 
		int newDigit = (rDigit1 + rDigit2) % 10; 	//resultant digit in a certain position  
		


		if (carry > 0) { 					//update newdigit if there is a carry from the previous call
			newDigit += 1;
		}


		int lDigit = 0;
		
		if (rDigit1 + rDigit2 > 9) { 				//recursion to base case
			System.out.print("bum");
			lDigit = add(num1 / 10, num2 / 10, 1);
			System.out.print("ass");
		
		} else {
			System.out.print("clown");
			lDigit = add(num1 / 10, num2 / 10, 0);
			System.out.print("fucker");
			
			if (lDigit == 0) {
				return newDigit;
			}
		}
		


			String digitL = String.valueOf(lDigit);
			String digitR = String.valueOf(newDigit);
			System.out.print("dick");
    			return Integer.parseInt(digitL.concat(digitR));
		} 	
}

