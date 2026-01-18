/*
 * CS1010J Programming Methodology
 * Problem Set 3 Exercise #12: PS3_Ex12_RotateRightK.java
 * 
 * same as exercise 11 but diabolical
 * 
 * Soh Li Min
 */

import java.util.*;

class RotateRightK {
  
  	public static void main(String[] args) {
    		Scanner s = new Scanner(System.in);
    		System.out.print("Enter the number of elements: ");
    		int size = s.nextInt();
		int[] stuff = new int[size];
    		System.out.print("Enter " + size + " elements: ");
    		for (int i = 0 ; i < size ; i ++) {
			stuff[i] = s.nextInt();
		}	
    		System.out.print("Enter k: ");
    		int kTimes = s.nextInt();
	       	rotateRightK(stuff, kTimes);
		System.out.print(Arrays.toString(stuff));	
  	}
  
  	public static void rotateRightK(int[] arr, int k) {
    		int noOfCalls = k % arr.length;
		
		for (int i = 0 ; i < noOfCalls ; i ++) {
			rotateRight(arr);
		}
  	}
  	//after # = size number of calls of rotateRight, we obtain the original array
  	public static void rotateRight(int[] arr) {
    		int temp = 0;
		for(int i = arr.length - 1; i > -1; i--) {
			if (i == arr.length - 1) {
				temp = arr[i];
				arr[i] = arr[i - 1];
			} else if (i == 0) {
				arr[i] = temp;
			} else {
				arr[i] = arr[i - 1];
			}
		}
  	}
}
