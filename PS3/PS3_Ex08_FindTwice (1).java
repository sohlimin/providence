/*
 * CS1010J Programming Methodology
 * Problem Set 3 Exercise #08: PS3_Ex08_FindTwice.java
 * 
 * returns the least index of an element that is repeated in an integer array. If array does not have, returns -1
 * 
 * Soh Li Min 
 */

import java.util.*;

class FindTwice {
  
  	public static void main(String[] args) {
    		Scanner s = new Scanner(System.in);
    		System.out.print("Enter the number of elements: ");
    		int size = s.nextInt();
    		int[] stuff = new int[size];
		System.out.print("Enter " + size + " elements: ");
    		for (int i = 0 ; i < size; i++) {
			stuff[i] = s.nextInt();	
		}
		int indexLeast = findTwice(stuff);
		if (indexLeast == -1) {
    		System.out.println("Array doesn't contain duplicated data");
		} else {
    		System.out.println(stuff[indexLeast] + " is the first element that appears at least twice"); 
		}
	}
  	public static int findTwice(int[] arr) {
    		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 1; j < arr.length ; j++) {
				if (i != j) {
					if (arr[i] == arr[j]) {
					return i;
					}
				}
			}
		}	
    		return -1;
	}
}

