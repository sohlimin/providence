/*
 * CS1010J Programming Methodology
 * Problem Set 3 Exercise #03: PS3_Ex03_MaxDifference.java
 * 
 * This program find the biggest difference between adjacent array elements in a array with n integers
 * 
 * Soh Li Min
 */

import java.util.*;

class MaxDifference {
  
  	public static void main(String[] args) {
    
    		System.out.print("Enter the size of the array: ");
    		Scanner s = new Scanner(System.in);
    		int size = s.nextInt();
    		System.out.print("Enter " + size + " elements: ");
    		int[] stuff = new int[size];
    		for(int i = 0; i < size ; i++) {
			stuff[i] = s.nextInt();
    		}
    		int biggD = maxDifference(stuff);
    		System.out.println("Max difference = " + biggD);
  	}	
  
  	public static int maxDifference(int[] arr) {
  		int bigDiff = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (Math.abs(arr[i] - arr[i + 1]) > bigDiff) {
				bigDiff = Math.abs(arr[i] - arr[i + 1]);
			}
		}
		return bigDiff;
  	}
}
