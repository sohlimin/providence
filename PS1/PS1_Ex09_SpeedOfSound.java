/*
 * CS1010J Programming Methodology
 * Problem Set 1 Exercise #09: PS1_Ex09_SpeedOfSound.java
 * 
 * This program calculates the speed of sound in air of a given temperature.
 * 
 * <Type your name here>
 */

import java.util.Scanner;

class SpeedOfSound {
  
	public static void main(String[] args) {
		System.out.print("Temperature in degree Fahrenheit: ");
    		Scanner sc = new Scanner(System.in);
		double temp = sc.nextDouble();
		double peed = speedOfSound(temp);
    		System.out.println(String.format("Speed = %.2f ft/sec", peed));
  	}
  
  	// Compute the speed of sound given temperature
  	public static double speedOfSound(double t) { //uppercase are generics
    		 return 1086 * (Math.sqrt((5 * t + 297) / 247));
  	}
}
