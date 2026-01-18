/*
 * CS1010J Programming Methodology
 * Problem Set 4 Exercise #13: PS4_Ex13_WordGame.java
 * 
 * This program reads in a word and computes
 * the total points of all the letters in the word.
 * 
 * Soh Li Min
 */

import java.util.*;

class WordGame {
  
  	public static void main(String[] args) {
    
    		System.out.print("Enter a word: ");
    		Scanner sc = new Scanner(System.in);
    		String word = sc.next();
		int points = computeScore(word);

    		System.out.println("Total score = " + points);
  	}	
  
  	public static int computeScore(String word) {
		int score = 0;
    		for (int i = 0 ; i < word.length() ; i++) {
			switch (word.charAt(i)) {
				case 'A' : case 'E' : case 'I' : case 'L' : case 'N' : case 'O' : case 'R' : case 'S' : case 'T' : case 'U' :
					score += 1;
					break;

				case 'D' : case 'G' :
					score += 2;
					break;

				case 'B' : case 'C' : case 'M' : case 'P' :
					score += 3;
					break;

				case 'F' : case 'H' : case 'V' : case 'W' : case 'Y' :
					score += 4;
					break;

				case 'K' :
					score += 5;
					break;

				case 'J' : case 'X' :
					score += 8;
					break;

				case 'Q' : case 'Z' :
					score += 10;
					break;

				default :
					score += 0;
			}
		}
		return score;
  	}
}
