/*
 * CS1010J Programming Methodology
 * Problem Set 3 Exercise #09: PS3_Ex09_Pair.java
 * 
 * return true if given a key, the sum of two elements in an unsorted non-repetitive integer array is equals to key. 
 * 
 * Soh Li Min
 */

import java.util.*;

class Pair {
  
  	public static void main(String[] args) {
    		Scanner s = new Scanner(System.in);
    		System.out.print("Enter the number of distinct elements: ");
    		int size = s.nextInt();
    		int[] stuff = new int[size];
    		System.out.print("Enter " + size + " elements: ");
    		for(int i = 0; i < size; i++) {
	    		stuff[i] = s.nextInt();
		}
    		System.out.print("Enter key: ");
    		int key = s.nextInt();
		boolean existence = checkPair(stuff, key);
    		if (existence) {
		System.out.println("Exist");
		} else {
    		System.out.println("Not exist");
		}
	}
  
  	// 
  	public static boolean checkPair(int[] arr, int key) {
    		for (int i = 0 ; i < arr.length ; i++) {
			for (int j = 1 ; j < arr.length ; j++) {
				if (arr[j] == key - arr[i]) {
					return true;
				}
			}
		}
    		return false;
  	}
}
