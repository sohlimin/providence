/*
 * CS1010J Programming Methodology
 * Problem Set 3 Exercise #20: PS3_Ex20_MinMax.java
 * 
 * user inputs a 2D array, the program outputs its min and max as a tuple (array of 2)
 * 
 * Soh Li Min
 */

import java.util.*;

class MinMax {
  
  	public static void main(String[] args) {
    		Scanner s = new Scanner(System.in);
    		System.out.print("Enter the size of the matrix: ");
    		int row = s.nextInt();
    		int col = s.nextInt();
    		int [] [] jews = new int [row] [col];
    		System.out.println("Enter elements row by row:");
    		for (int i = 0; i < row ; i++) {
	    		for (int j = 0; j < col; j++) {
		    		jews[i][j] = s.nextInt();
	    		}
    		}
		int[] tuple = getMinMax(jews);
    		System.out.println("Min = " + tuple[0] );
    		System.out.println("Max = " + tuple[1] );
  	}
  
  	// Return the minimum and maximum values in a matrix
  	public static int[] getMinMax(int[][] mtx) {
    		int max = mtx[0][0];
		int min = mtx[0][0]; 
		for (int i = 0; i < mtx.length; i++) {
			for (int j = 0; j < mtx[i].length; j++) {
				if (mtx[i][j] > max) {
					max = mtx[i][j];
				}
				if (mtx[i][j] < min) {
					min = mtx[i][j];
				}
			}
		}
		int[] tulep = new int[2];
	       	tulep[0] = min;
		tulep[1] = max;
		return tulep;
  	}
}
