/*
 * CS1010J Programming Methodology
 * Problem Set 3 Exercise #27: PS3_Ex27_Contour.java
 * 
 * This program can...
 * 1) take in a 2D array (topographic map)
 * 2) count peaks and valleys (array "countPeakValley")
 * 3) output a peaks and valleys map (2D array "peaksandvalleys")
 * 4) output a hiking map (2D array of 0s and 1s "hike"). reachable location = traversable from top left element
 *
 * Soh Li Min
 */

import java.util.*;

class Contour {
  
  	public static void main(String[] args) {
    
    		Scanner sc = new Scanner(System.in);
    		//1 
    		System.out.print("Enter the number of rows and cols: ");
    		int row = sc.nextInt();
    		int col = sc.nextInt();
    		int[][] map = new int[row][col];
    		System.out.println("Enter the data:");
    		scanArray(map, sc);
    		
		//3
    		int[][] peaksandvalleys = new int[row][col];

    		//2
		int[] countPeakValley = new int[2];
    		getPeaksValleys(map, peaksandvalleys, countPeakValley);
    		System.out.println("Number of peaks = " + countPeakValley[0]);
    		System.out.println("Number of valleys = " + countPeakValley[1]);
    		
		//3
		System.out.println("Peaks and Valleys map");
		printArray(peaksandvalleys);
    		
		//4
    		int[][] hike = new int[row][col];
   		getHikeTrail(map, hike); 
    		System.out.println("Hiking map");
		printArray(hike);
  	}
  
  	//2 & 3
  	public static void getPeaksValleys(int[][] map, int[][] peaksandvalleys, int[] countPeakValley) {
    		//2
		// We will check 3 neighbours along a column/row to get a initial arraylist of potential peaks...
		//...even 1 neighbour that is not lower than the element will rule out that the element is a peak.
		// For each potential peak, we iterate over remaining 5 neighbours (like sudoku subgrids) and eliminate from potentiallyPeaks ArrayList.
		
		List<int[]> potentiallyPeaks = new ArrayList<int[]>();
		List<int[]> potentiallyValleys = new ArrayList<int[]>();

		//Every element (excluding elements on map edges)
		for (int i = 1; i < map.length - 1; i++) {
			for (int j = 1; j < map[i].length - 1; j++) {
				/*
				//compare with NW, W, SW (j - 1 column)
				if (map[i][j] > map[i][j - 1] && map[i][j] > map[i - 1][j - 1] && map[i][j] > map[i + 1][j - 1]) {
  					int[] p = new int[2];
					p[0] = i;
					p[1] = j;
					potentiallyPeaks.add(p);
				}
				*/
				if (map[i][j] < map[i][j - 1] && map[i][j] < map[i - 1][j - 1] && map[i][j] < map[i + 1][j - 1]) {
					int[] v = new int[2];
					v[0] = i;
					v[1] = j;
					potentiallyValleys.add(v);
				}
				
				
  				int[] p = new int[2];
				p[0] = i;
				p[1] = j;
				potentiallyPeaks.add(p);

			}
		}
		List<int[]> confirmedPeaks = new ArrayList<int[]>();
		//Iterator<int[]> itr = potentiallyPeaks.iterator(); 
		//while (itr.hasNext()) {
		//	int[] p = itr.next();
		for (int[] p : potentiallyPeaks) {
			boolean disqualified = false;
			
			for (int i = -1; i <= 1 && !disqualified; i++) {
			     	for (int j = -1; j <= 1; j++) {
					
					if (i == 0 && j == 0) continue; //center cell (the one we're evaluating as a peak/valley)
					if (map[p[0] + i][p[1] + j] >= map[p[0]][p[1]]) {
						//itr.remove();
						disqualified = true;
						break; //exit j-loop
					}
				}
				//exit i-loop (&& !disqualified condition
			}	
			// while loop continues with itr.next()
			if (!disqualified) {
				confirmedPeaks.add(p);
			}
		}
                
		Iterator<int[]> iter = potentiallyValleys.iterator();
                while (iter.hasNext()) {
                        int[] v = iter.next();
                        boolean disqualified = false;

                        for (int i = -1; i <= 1 && !disqualified; i++) {
                                for (int j = 0; j <= 1; j++) {

                                        if (i == 0 && j == 0) continue;
                                        if (map[v[0] + i][v[1] + j] <= map[v[0]][v[1]]) {
                                        	iter.remove();
                                                disqualified = true;
                                                break;
                                        }
                                }
                        }
                }


		/* Modifying a list in an enhanced for loop is unsafe in Java.
		for (int[] v : potentiallyValleys) {

			for (int i = -1; i <2; i++) {
				for (int j = 0; j < 2; j++) {
					if (i != 0 && j != 0) {
						if (map[p[0] + i][p[1] + j] < map[p[0]][p[1]]) {
							potentiallyValleys.remove();
						}
					}
				}
			}
		}
		*/
		//countPeakValley[0] = potentiallyPeaks.size();
		countPeakValley[0] = confirmedPeaks.size();
		countPeakValley[1] = potentiallyValleys.size();

		//3
		for (int[] p : confirmedPeaks) {
			peaksandvalleys[p[0]][p[1]] = 1; //1 represents peak
		}
		for (int[] v : potentiallyValleys) {
			peaksandvalleys[v[0]][v[1]] = 2; //2 represents valley
		}
	}
	
  	//4
  	public static void getHikeTrail(int[][] map, int[][] hike) {
		hike[0][0] = 1;

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (hike[i][j] == 1) {	
					if (j + 1 < map[i].length && Math.abs(map[i][j] - map[i][j + 1]) <= 2) {
						hike[i][j + 1] = 1;
					}

					if (i + 1 < map.length && Math.abs(map[i][j] - map[i + 1][j]) <= 2) {
						hike[i + 1][j] = 1;
					}
				}
			}
		}
		for (int i = map.length - 1; i > -1; i--) {
			for (int j = map[i].length - 1; j > -1; j--) {
				if (hike[i][j] == 1) {	
					if (j - 1 > -1 && Math.abs(map[i][j] - map[i][j - 1]) <= 2) {
						hike[i][j - 1] = 1;
					}  	
					if (i - 1 > -1 && Math.abs(map[i][j] - map[i - 1][j]) <= 2) {
						hike[i - 1][j] = 1;
					}
				}
			}
		}
	}
  
  	// Provided method; don't modify it
  	// Read in the data for the contour map
  	public static void scanArray(int[][] array, Scanner sc) {
    		int numRows = array.length;
    		int numCols = array[0].length;
    		for (int row = 0; row < numRows; row++) {
      			for (int col = 0; col < numCols; col++) {
        			array[row][col] = sc.nextInt();
     			}
    		}
  	}
  
  	// Provided method; don't modify it
  	// Prints 2D arrays (with newline for every array)
  	public static void printArray(int[][] array) {
    		int numRows = array.length;
	       	int numCols = array[0].length;
    		for (int row = 0; row < numRows; row++) {
      			for (int col = 0; col < numCols; col++) {
        			System.out.print(array[row][col] + " ");
      			}
      			System.out.println();
    		}
  	}
}
