/*
 * CS1010J Programming Methodology
 * Problem Set 1 Exercise #16: PS1_Ex16_TriangleIncenter.java
 * 
 * <Fill in a short description of this program>
 * 
 * 
 * Soh Li Min
 */

import java.util.Scanner;

class TriangleIncenter {
  
  	public static void main(String[] args) {
    
	
		System.out.print("Coordinates of 1st vertex: ");
    		Scanner sc = new Scanner(System.in);
		double xa = sc.nextDouble();
    		double ya = sc.nextDouble();
    		System.out.print("Coordinates of 2nd vertex: ");
    		double xb = sc.nextDouble();
		double yb = sc.nextDouble();
    		System.out.print("Coordinates of 3rd vertex: ");	
		double xc = sc.nextDouble();
    		double yc = sc.nextDouble();
		
		double a = computeLength(xb, yb, xc, yc); 
    		double b = computeLength(xa, ya, xc, yc); 
    		double c = computeLength(xa, ya, xb, yb); 
    		double p = a + b + c;
		
    		double xIncenter = (a * xa + b * xb + c * xc) / p;

    		double yIncenter = (a * ya + b * yb + c * yc) / p;

    		System.out.println(String.format("Coordinates of incenter = (%.2f, %.2f)" , xIncenter, yIncenter));
  	}
  


  	public static double computeLength(double x1, double y1, double x2, double y2) {
    		double length = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    		return length;

  	}
}
