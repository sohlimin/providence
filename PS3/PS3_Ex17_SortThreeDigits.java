/*
 * CS1010J Programming Methodology
 * Problem Set 3 Exercise #17: PS3_Ex17_SortThreeDigits.java
 * 
 * reorder an array according to the first 3 digits, in ascending order
 * 
 * Soh Li Min
 */

import java.util.*;

class SortThreeDigits {
  
  	public static void main(String[] args) {
    		Scanner s = new Scanner(System.in);
    		System.out.print("Enter the number of elements: ");
    		int size = s.nextInt();
    		int[] shit = new int[size];
		System.out.print("Enter " + size + " elements: ");
    		for (int i = 0 ; i < size ; i++) {
			shit[i] = s.nextInt();
		}
    		sortArray(shit);
    
    		System.out.print("Sorted array: " + Arrays.toString(shit));
    
  	}
  
  	// Bubble sort the given array according to the first 3 digits
  	public static void sortArray(int[] arr) {
		

    		for (int i = arr.length - 1; i > 0; i--) { //from last element of array to the index 1 element of an array
			for (int j = 0; j < i; j++) { //from the first element of the array to the index before i
				if (moreThan(arr[j], arr[j + 1])) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
  
  	// Compare num1 with num2 according to their first 3 digits.
  	// Return true if num1 is bigger, or false otherwise
  	public static boolean moreThan(int num1, int num2) {
    		int n1 = convertTo3Digits(num1);
		int n2 = convertTo3Digits(num2);
		if (Math.max(n1, n2) == n2){
		return false;
		} 
		return true;
  	}

	public static int convertTo3Digits(int n) {
		while (n > 999) {
			n /= 10;
		}
		return n;		
	}
}
