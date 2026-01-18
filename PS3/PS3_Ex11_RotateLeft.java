/*
 * CS1010J Programming Methodology
 * Problem Set 3 Exercise #11: PS3_Ex11_RotateLeft.java
 * 
 * shifts array elements one place to the left
 * 
 * Soh Li Min
 */

import java.util.*;

class RotateLeft {
  
  	public static void main(String[] args) {
    		Scanner s = new Scanner(System.in);
    		System.out.print("Enter the number of elements: ");
    		int size = s.nextInt();
		int[] stuff = new int[size];
    		System.out.print("Enter " + size + " elements: ");
    		for (int i = 0; i < size; i++) {
			stuff[i] = s.nextInt();
		}
		rotateLeft(stuff);
		System.out.print(Arrays.toString(stuff));
	}
  
  	public static void rotateLeft(int[] arr) {
    		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			
			if (i == 0) {
				temp = arr[0]; //store first element in temporary variable
				arr[i] = arr[i + 1];
			} else if (i == arr.length - 1) { //when we reach last element, assign it the stored value
				arr[arr.length - 1] = temp;
			} else { // will execute from second to second-last element
				arr[i] = arr[i + 1];
			}

		}
  	}
}
