/*
 * CS1010J Programming Methodology
 * Problem Set 3 Exercise #30: PS3_Ex30_Minesweeper.java
 * 
 * This program reads in a minefield containing mines,
 * and computes the values of the safe squares.
 * 
 * Soh Li Min
 */

import java.util.*;

class Minesweeper {
  
  	public static void main(String[] args) {
    
    		Scanner sc = new Scanner(System.in);
    		System.out.print("Enter level (1-3): ");
    		int level = sc.nextInt();
		sc.nextLine();
		if (level == 1)	{
	       		printTiles(compute(readBoard(8, 8)));
			
		} else if (level == 2) {
	       		printTiles(compute(readBoard(12, 16))); 
			
		} else if (level == 3) {			
			printTiles(compute(readBoard(16, 30)));
		}

	}
	
	public static int[][] readBoard(int row, int col) {
    		
		Scanner u = new Scanner(System.in);
		System.out.println("Enter the " + row + " x " + col + " board:");
		int[][] minefield = new int[row][col];
		
		for (int i = 0; i < row ; i++) {
			String line = u.nextLine();
			for (int j = 0; j < col; j++) {
				minefield[i][j] = line.charAt(j);
			}
		}
		return minefield;
	}
    	public static int[][] compute(int[][] sym) {
		
		for (int i = 0 ; i < sym.length; i++) {
			for (int j = 0; j < sym[i].length; j++) {
				/*
				//convert all * to 9
				if (sym[i][j] == 42) {
					sym[i][j] = 9;

				}*/
				//non mines 
				if (sym[i][j] == 45) {
					sym[i][j] = 0;
				}
			}
		}
	
		//retroactively change values mine-centrically as each is discovered.
		for (int i = 0; i < sym.length; i++ ) {
			for (int j = 0; j < sym[i].length; j++) {
				if (sym[i][j] >= 42) {
				//every tile excluding first column has an index to the left
					if (j > 0) {
						sym[i][j - 1] += 1;		//West
					}
				

				//every tile excluding the last column has an index to the right
					if (j < sym[i].length - 1) {		
						sym[i][j + 1] += 1;		//East
					}
				
				//every tile, excluding the first row, has a row above
					if (i > 0) {				
						sym[i - 1][j] += 1;		//North
					       	if (j < sym[i].length - 1) {	
							sym[i - 1][j + 1] += 1;	//NE
						}
						if (j > 0) {
							sym[i - 1][j - 1] += 1;	//NW
						}
					}
				
				//every tile, excluding the last row, has a row below
					if (i < sym.length - 1) { 
						sym[i + 1][j] += 1;		//South
					       	if (j < sym[i].length - 1) {	
							sym[i + 1][j + 1] += 1;	//SE
						}
						if (j > 0) {
							sym[i + 1][j - 1] += 1;	//SW
						} 
					}

					
				}
			}
		}
		for (int i = 0; i < sym.length; i++ ) {
			for (int j = 0; j < sym[i].length; j++) {
				if (sym[i][j] >= 42) {
					sym[i][j] = 9;
				}
			}
		}
		return sym;
	}

		
	//formats our 2D array nicely and prints it
	public static int[][] printTiles(int[][] tiles) {
		//removes brackets, commas, and makes new line for each array in the array
		System.out.println(Arrays.deepToString(tiles)
				.replace("], [", "\n")
				.replace(", ", " ")
				.replace("[[", "")
				.replace("]]", ""));
		return tiles;
	}
}
