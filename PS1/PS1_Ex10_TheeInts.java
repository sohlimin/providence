/*
 * CS1010J Programming Methodology
 * Problem Set 1 Exercise #10: PS1_Ex10_TheeInts.java
 * 
 * This program reads three positive integers,
 * prints out their digits in hundredth position.
 * 
 * <Type your name here>
 */

import java.util.Scanner;

class TheeInts {
	public static void main(String[] args) {
    
  		System.out.print("Enter 3 positive integers: ");
		Scanner sc = new Scanner(System.in);
		
		int a = getHundredth(sc.nextInt());
		int b = getHundredth(sc.nextInt());
		int c = getHundredth(sc.nextInt());

		System.out.println(String.format("%d %d %d", a, b, c));
	}
  
  // Take a number and return the digit in hundredth position
	public static int getHundredth(int num) {
		return (num / 100) % 10;
  	}
}
