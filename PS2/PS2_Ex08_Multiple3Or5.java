/*
 * CS1010J Programming Methodology
 * Problem Set 2 Exercise #08: PS2_Ex08_Multiple3Or5.java
 * 
 * <Fill in a short description of this program>
 * 
 * 
 * <Type your name here>
 */

import java.util.Scanner;

class Multiple3Or5 {
  
	 public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 
		System.out.print("Enter n: ");
		int n = sc.nextInt() - 1;
		int ncopy = n;
		int found = 0; 
		while (n > 0) {
			if (n % 3 == 0 || n % 5 == 0) {
			       found++;
			}
	 		n--;
		}		
		System.out.println(found);
		System.out.println(multiplefind(ncopy));
    
 	 }
	 
	public static int multiplefind(int lol) {
		return lol / 3 + lol / 5 - lol / 15;
	 }
}
