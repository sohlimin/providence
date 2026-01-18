/*
 * CS1010J Programming Methodology
 * Problem Set 1 Exercise #12: PS1_Ex12_MagicDigit.java
 * 
 * <Fill in a short description of this program>
 * 
 * 
 * Soh Li Min
 */

import java.util.Scanner;

class MagicDigit {
  
	public static void main(String[] args) {
		
		System.out.print("Enter 1st number: ");
		Scanner a = new Scanner(System.in);
		int input = a.nextInt();
    		boolean isValid = validitycheck(input);
		
		if (!isValid) {
			System.out.println("Please key in only 5 digit numbers.");     	
		} else {
			int output = getMagic(input);
			System.out.println("Magic digit = " + output);
		}

    		System.out.print("Enter 2nd number: ");
    		
		input = a.nextInt();
		
    		isValid = validitycheck(input);

		if (!isValid) {
			System.out.println("Please key in only 5 digit numbers.");       	
		} else {
			int output = getMagic(input);
			System.out.println("Magic digit = " + output);
		}
  	}	
 
	public static boolean validitycheck(int userinput) { //assuming the program wont run if input has non-numerical letters other than '-' (don't know about +4000)
		if (userinput > 99999 || userinput < 10000) { //reject 6 digit or negative inputs
			return false;
		}else { /*
			String converted = (String) userinput;
			if (converted.length != 5) {//reject inputs if they are shorter than 5 digits
				return false; */
			return true;
			} 
		
		}
		
	

  	// Take a number and return the magic digit
	public static int getMagic(int num) {
    		int positionOne = num / 10000;
		int positionThree = (num / 100) % 10;
		int positionFive = num % 10;	
 		return (positionOne + positionThree + positionFive) % 10; 
 	 }
}
