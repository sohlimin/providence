/*
 * CS1010J Programming Methodology
 * Problem Set 1 Exercise #19: PS1_Ex19_LeapYear.java
 * 
 * <Fill in a short description of this program>
 * 
 * 
 * Soh Li Min
 */

import java.util.*;

class LeapYear {
  
	public static void main(String[] args) {
    
    		Scanner sc = new Scanner(System.in);
    
    		System.out.print("Enter year: ");
    		int yer = sc.nextInt();
		boolean leap = isLeapYear(yer);	    
    		if (leap) {
    		System.out.println(yer + " is a leap year.");
		} else {
    		System.out.println(yer + " is not a leap year.");
  		}
	}
  
	public static boolean isLeapYear(int year) {
    		if (year % 4 == 0 && year % 100 != 0) {
			return true;
		} else if (year % 400 == 0) {
			return true;
		} else {
		return false;  
  		}
	}
}
