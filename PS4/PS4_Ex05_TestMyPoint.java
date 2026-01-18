/*
 * CS1010J Programming Methodology
 * Problem Set 4 Exercise #05: PS4_Ex05_TestMyPoint.java
 * 
 * This class demonstrates the use of MyPoint class.
 * It reads a double seed and generates 2 points p and q as follows:
 *   p's x-coordinate: divide seed by 17 and take the quotient
 *   p's y-coordinate: divide seed by 53 and take the remainder
 *   q's x-coordinate: divide seed by 11 and take the quotient
 *   q's y-coordinate: divide seed by 41 and take the remainder
 * It then computes, by invoking appropriate member methods of the MyPoint class,
 * the Euclidean distance between the two points, and the area of the
 * rectangle bounded by these 2 points as the opposite corners.
 * 
 * Soh Li Min
 */

import java.util.*;
import java.text.*;

class TestMyPoint {
  
  	public static void main (String [] args) {
    
    
    		System.out.print("Enter seed: ");
    		Scanner sc = new Scanner(System.in);
    		double seed = sc.nextDouble();

    		MyPoint p = new MyPoint(seed / 17.0, seed % 53.0);	
    		System.out.println("p = " + p.toString());
    
    		MyPoint q = new MyPoint(seed / 11.0, seed % 41.0);
    		System.out.println("q = " + q.toString());
    
   		 
    		System.out.println(String.format("Distance = %.5f", p.distanceTo(q)));
    		System.out.println(String.format("Area = %.5f", p.computeRectArea(q)));
  }
}
