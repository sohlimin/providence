/*
 * CS1010J Programming Methodology
 * Problem Set 3 Exercise #05: PS3_Ex05_Deviation.java
 * 
 * input n double real numbers, return standard deviation.  
 * 
 * Soh Li Min
 */

import java.util.*;
import java.text.*;

class Deviation {
  
  	public static void main(String[] args) {
    
    		System.out.print("Enter the size of the array: ");
    		Scanner s = new Scanner(System.in);
	       	int saiz = s.nextInt();
		double[] stuff = new double[saiz];
    		System.out.print("Enter " + saiz + " elements: ");
    		for (int i = 0 ; i < saiz ; i++) {
			stuff[i] = s.nextDouble();
		}
		double stdDeviation = computeDeviation(stuff);
    		System.out.println(String.format("Standard deviation is: %.2f", stdDeviation));
  	}
  
  	public static double computeDeviation(double[] val) {
    		double av = average(val);
		double intermediate = 0;
		for (double h : val) {
			intermediate += Math.pow(h - av, 2);
		}
		double sd = Math.sqrt(intermediate / val.length);
    		return sd;
  	}
  
  	public static double average(double[] val) {
    		double totaled = 0;
		for (double d : val) {
			totaled += d;
		}
		double avg = totaled / val.length;
		return avg; 
	}
}
