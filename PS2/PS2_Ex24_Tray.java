/*
 * CS1010J Programming Methodology
 * Problem Set 2 Exercise #24: PS2_Ex24_Tray.java
 * 
 * <Fill in a short description of this program>
 * 
 * Soh Li Min
 */

import java.util.*;

class Tray {
	public static void main(String[] args) { 
		double side1;
    		double side2;
    		System.out.print("Enter size of tray: ");
		Scanner sc = new Scanner(System.in);
    		side1 = sc.nextDouble();
		side2 = sc.nextDouble();
    		
		double p = perimeter(side1, side2);
    
    		System.out.println("Minimum perimeter after folding = " + p);
  	}

	public static boolean isTheLongerSide(double sideA, double sideB) {
		if (sideA >= sideB){
			return true;
		} else {
			return false;
		}
	}
	

	public static double perimeter(double side1, double side2) {
		for (int i = 0; i < 3; i++){
			
			if (isTheLongerSide(side1, side2)){
				side1 /= 2.0;
			} else {
				side2 /= 2.0;
			}
		}
		return 2.0 * (side1 + side2);
	}
}
