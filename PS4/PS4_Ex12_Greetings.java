/*
 * CS1010J Programming Methodology
 * Problem Set 4 Exercise #12: PS4_Ex12_Greetings.java
 * 
 * This program reads age, name and gender of a person,
 * prints out corresponding greeting message.
 * 
 * Soh Li Min can code! Wow!
 */

import java.util.*;

class Greetings {
  
  	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Your age? ");
    	int age = sc.nextInt();
    	sc.nextLine();//bufferflush
    	System.out.print("Your name? ");
    	String name = sc.nextLine().trim();
    	System.out.print("Your gender? ");
    	String orient = sc.nextLine().trim();
    	if (age < 18){
	    	if (orient.toUpperCase().equals("MALE")){ 
    			System.out.println("Hello boy " + name);
	    	} else {
    			System.out.println("Hey girl " + name);
	    	}
    	} else {
	    	if (orient.toUpperCase().equals("MALE")) {
    			System.out.println("Hello Mr. " + name);
	    	} else {
    			System.out.println("Hey Ms. " + name);
		}
  	}
	}
}
