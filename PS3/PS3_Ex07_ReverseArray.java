/*
 * CS1010J Programming Methodology
 * Problem Set 3 Exercise #07: PS3_Ex07_ReverseArray.java
 * 
 * reverses the vals in an array 
 * 
 * Soh Li Min
 */

import java.util.*;

class ReverseArray {
  
  	public static void main(String[] args) {
    
    	int[] arr = readArray();
    
    	reverseArray(arr);
    
    	System.out.print("Reversed: " + Arrays.toString(arr));
  	}
  
  	// Read and return an array
  	public static int[] readArray() {
    
    		Scanner sc = new Scanner(System.in);
    
    		System.out.print("How many values in the array? ");
    		int size = sc.nextInt();
		int[] arra = new int[size];
    		System.out.print("Enter " + size + " values: ");
		for (int i = 0 ; i < size ; i++) {
			arra[i] = sc.nextInt();
		}
		return arra;
  	}
  
  	public static void reverseArray(int[] arr) {
    		for (int i = 0; i< arr.length/2 ; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length - (1 + i)];
			arr[arr.length - (1 + i)] = temp;
		}

    	// Can you avoid defining additional array?
  	}
}
