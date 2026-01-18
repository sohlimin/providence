/*
 * CS1010J Programming Methodology
 * Problem Set 3 Exercise #24: PS3_Ex24_DiagonalMatrix.java
 * 
 * returns boolean, checks for descending diagonal or antidiagonal matrix
 * 
 * Soh Li Min
 */

import java.util.*;

class DiagonalMatrix {
  
  	public static void main(String[] args) {
    		
		Scanner s = new Scanner(System.in);
    		System.out.print("Enter the size of the square matrix: ");
    		int size = s.nextInt();
		int[][] singapore = new int[size][size];
    		System.out.println("Enter elements row by row:");
    		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				singapore[i][j] = s.nextInt();
			}
		}
		boolean dd = isDescDiagonal(singapore);
		if (dd) {
    			System.out.println("Given matrix is a descending diagonal matrix.");
		} else {
    			System.out.println("Given matrix is not a descending diagonal matrix.");
		}
	       	boolean ad = isAntiDiagonal(singapore);	
		if (ad) {
    			System.out.println("Given matrix is an anti-diagonal matrix.");
		} else {
    			System.out.println("Given matrix is not an anti-diagonal matrix.");        
		}
	}


	public static boolean isDescDiagonal(int[][] mtx) {
		int diffBtw = 0;
		int prev = mtx[0][0];
		for (int i = 0 ; i < mtx.length; i++) {
			for (int j = 0 ; j < mtx[i].length; j++){
				//the consecutive elements on the diagonal has difference of 1
				
				if (i == j && i != 0) {
					diffBtw = mtx[i][j] - prev;
					if (diffBtw != -1) {
						return false;
					} else {
						prev = mtx[i][j];
					}
				
				} else if (mtx[i][j] != 0 && i != j) {
					return false;
				}
			}
		}
			return true;
	}

	public static boolean isAntiDiagonal(int[][] mtx) {

		for (int i = 0 ; i < mtx.length; i++) {			
			for (int j = 0; j < mtx.length; j++){
				if (!(i == mtx.length - 1 - j)){
					if (mtx[i][j] != 0) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
