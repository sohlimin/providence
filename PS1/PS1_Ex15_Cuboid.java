/*
 * CS1010J Programming Methodology
 * Problem Set 1 Exercise #15: PS1_Ex15_Cuboid.java
 * 
 * <Fill in a short description of this program>
 * 
 * 
 * <Type your name here>
 */

import java.util.Scanner;
import java.text.*; //Decimal format not used so redundant

class Cuboid {
  
  	public static void main(String[] args) {
    		System.out.print("Enter length: ");
    		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
    		System.out.print("Enter width : ");
    		int w = sc.nextInt();
    		System.out.print("Enter height: ");
    		int h = sc.nextInt();
    		 
		int surfacearea = computeSurfaceArea(l, w, h);
    		double diagonal = computeDiagonal(l, w, h);
    		System.out.println(String.format("Surface area = %d", surfacearea));
    
   		System.out.println(String.format("Diagonal = %.2f", diagonal));
  	}
  
  	public static int computeSurfaceArea(int length, int width, int height) {
    		return 2 * ((length * width) + (width * height) + (height * length));
  	}
  
  	public static double computeDiagonal(int length, int width, int height) {
		return Math.sqrt(Math.pow(length, 2) + Math.pow(width, 2) + Math.pow(height, 2));
  	}
}
