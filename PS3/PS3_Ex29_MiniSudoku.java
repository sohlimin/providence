/*
 * CS1010J Programming Methodology
 * Problem Set 3 Exercise #29: PS3_Ex29_MiniSudoku.java
 * 
 * Takes in a 4 by 4 unsolved Sudoku board, and returns the solution.
 * The sample runs give you the easiest version. At any time, there is at most one blank in a certain row, column or 2x2 section
 * 
 * Soh Li Min
 */

import java.util.*;
import java.util.stream.IntStream;

class MiniSudoku {
  
  	public static void main(String[] args) {
    		Scanner s = new Scanner(System.in);
		int[][] unsolved = new int[4][4];
    		System.out.println("Enter board (0 for blank cell):");
    		for (int i = 0; i < unsolved.length; i++) {
			for (int j = 0; j < unsolved[i].length; j++) {
				unsolved[i][j] = s.nextInt(); 	
			}	
		}
			
		String solution = Arrays.deepToString(solve(unsolved))
				.replace("], [", "\n")
				.replace(",", " ")
				.replace("[[", "")
				.replace("]]", "");	
    		
		System.out.println("The Sudoku puzzle solved:\n" + solution);
 		   
  	}

	public static int[][] solve(int[][] board) {
		int[][] oldBoard;
		
		do {
		
			oldBoard = duplicate(board);

			board = rowCheck(board);
			board = colCheck(board);
			board = sectCheck(board);

		} while (!Arrays.deepEquals(board, oldBoard));
		
		return board;
		//UPDATE: Even the code above yields same result, so I narrowed down to 2) sectCheck logic is incomplete

		//Problem: premature termination before puzzle is fully solved. 
		//Maybe the problem is in: 
		//1) the algorithm below/base case, or 2) sectCheck logic

		/*	
		// Base case: identical board is returned 3 times consecutively = puzzle is solved (no zeroes left) UPDATE: doesn't work.
		int[][] b = rowCheck(board);
		if (Arrays.deepEquals(b, board)) { 					//1st 
			if (Arrays.deepEquals(colCheck(b), board)) {			//2nd 
				if (Arrays.deepEquals(sectCheck(b), board)) {		//3rd identical return
					return b;
				}
			}
		}
		
		if (Arrays.deepEquals(colCheck(b), b)) {					
			if (Arrays.deepEquals(sectCheck(b), b)) {
				return solve(b);
			}
		}
		
		
		b = colCheck(b);

		if (Arrays.deepEquals(sectCheck(b), b)) {
		       return solve(b);
		}
 				
		b = sectCheck(b);
		return solve(b);
		*/
	}
	//because "oldBoard = board" doesnt copy the board, but make oldBoard point to the same reference as board
	public static int[][] duplicate(int[][] original) {
		int[][] newCopy = new int[original.length][original[0].length];
		for (int i = 0; i < original.length; i++) {
			newCopy[i] = Arrays.copyOf(original[i], original[i].length);
		}
		return newCopy;
	}
		
	//determines the last number to complete the set, and fills it in 
	public static int[][] missingPiece(int[][] board, int[] pos, String mode) {
		int sum = 0;
		int partial = 0;
		int missing = 0;					//there are one of 1, 2, 3, 4 in a complete set, and the missing number is 0
		for (int i = 0; i <= board.length; i++) {
			sum += i;
		}
		if (mode.equals("row")) {
			partial = IntStream.of(board[pos[0]]).sum();
		}
		if (mode.equals("col")) {
			for (int i = 0; i < board.length; i++) {    	//for each row in that column index...
                        	partial += board[i][pos[1]];
			}
		}
		if (mode.equals("sect")) {
			int k = (pos[0] / 2) * 2;
			int l = (pos[1] / 2) * 2;			//determine which section from the pos
			for (int i = k; i < k + 2; i++) {
				for (int j = l; j < l + 2; j++) {
					partial += board[i][j];
				}
			}
		}	
		missing = sum - partial;
		board[pos[0]][pos[1]] = missing;
		return board;
	}

	//checks rows for presence of only 1 zero. Creates int[] position index of that 0. Replaces that 0, then returns the board
	public static int[][] rowCheck(int[][] board) {
		int[] position = new int[2];
		int zeroCount = 0;
		int colTrack = 0;					//we need to track columns because the check is always performed at the last column
		for (int i = 0; i < board.length; i++) {		//for each row...
			for (int j = 0; j < board[i].length; j++) {	//...check each column
				if (board[i][j] == 0) {
					zeroCount++;
					colTrack = j;
				}
				if (j == board[i].length - 1) {		//upon reaching and checking last column
					if (zeroCount > 1) {
						zeroCount = 0;		//reset counter and column tracker
						//colTrack = 0;
					}
					if (zeroCount == 1) {
						position[0] = i;	//position int[] array [row, column]
						position[1] = colTrack;
						board = missingPiece(board, position, "row");
						return board;
					}
				}
			}
		}
		return board; 
	}

	//checks columns for presence of only 1 zero. If found, replaces that 0, then returns board.
	public static int[][] colCheck(int[][] board) {
		int[] position = new int[2];
		int zeroCount = 0;
		int rowTrack = 0;
		for (int j = 0; j < board.length; j++) {		//for each column...
			for (int i = 0; i < board.length; i++) {	//...check each row
				if (board[i][j] == 0) {
					zeroCount++;
					rowTrack = i;
				}
				if (i == board.length - 1) {		//upon reaching and checking last row
					if (zeroCount > 1) {
						zeroCount = 0;
						//rowTrack = 0;
					}
					if (zeroCount == 1) {
						position[0] = rowTrack;
						position[1] = j;
						board = missingPiece(board, position, "col");
						return board;
					}
				}
			}
		}
		return board;
	}

	//checks sections...
	public static int[][] sectCheck(int[][] board) {
		int[] position = new int[2];
		int zeroCount = 0;
		int rowTrack = 0;
		int colTrack = 0;
		
		for (int g = 0; g < board.length; g += 2) {
			for (int h = 0; h < board[0].length; h += 2) {
			
				zeroCount = 0;	

				for (int i = g; i < g + 2; i++) {
					for (int j = h; j < h + 2; j++) {
						
						if (board[i][j] == 0) {
                                                	zeroCount++;
                                                	rowTrack = i;
                                                	colTrack = j;
						} 
					}
				}
                               	
				if (zeroCount == 1) {
                                	position[0] = rowTrack;
                  			position[1] = colTrack;
                                        board = missingPiece(board, position, "sect");
                                //	return board;
                       		}
						
			}
			
		}
	

		//Problem1: the h for-loop runs only once when h = 0 because h < 2  (i know, dunno how to work around it as when i made h <= 2, one of the tiles became 5, DED)
		//Problem2: even if problem 1 is solved, the whole thing combined only checks 2 sections...
		//...the top left and bottom right, for i & j both = 0,1 and i & j both = 2,3, not when i = 0,1 & j = 2,3 and vice versa
		/*
		for (int h = 0; h < board.length / 2; h += (board.length / 2)) {	// h < board.length / 2 - "number of steps", h + (board.length / 2) - "step size" 
			for (int i = h; i < h + (board.length / 2); i++) {		// i and j for-loops iterate just a single 2 x 2 section
				for (int j = h; j < h + (board.length / 2); j++) {
					if (board[i][j] == 0) {
						zeroCount++;
						rowTrack = i;
						colTrack = j;
					}
					if (i == h + (board.length / 2) - 1 && j == h + (board.length / 2) - 1) {
						if (zeroCount > 1) {
							zeroCount = 0;
						}
						if (zeroCount == 1) {
							position[0] = rowTrack;
							position[1] = colTrack;
							board = missingPiece(board, position, "sect");
							return board;
						}
					}
				}
			}
		}
		*/
		return board;
	}
}
