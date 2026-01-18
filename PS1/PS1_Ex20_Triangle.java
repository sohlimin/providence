/*
 * CS1010J Programming Methodology
 * Problem Set 1 Exercise #20: PS1_Ex20_Triangle.java
 * 
 * <Fill in a short description of this program>
 * 
 * 
 * <Type your name here>
 */

import java.util.Scanner;

class Triangle {
  
  	public static void main(String[] args) {
    	
    		Scanner sc = new Scanner(System.in);
   		int first = sc.nextInt();
		int second = sc.nextInt();
		int third = sc.nextInt();
    
    	if(first >= second + third || second >= first + third || third >= first + second) {
    		System.out.println("Not a triangle");
    	} else if(first == second && second == third) {
    		System.out.println("Equilateral");
	} else if(first == second || second == third || first == third) {
		System.out.println("Isosceles");
	} else {
    		System.out.println("Scalene");
  	}
}
}
