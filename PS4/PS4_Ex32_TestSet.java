/*
 * CS1010J Programming Methodology
 * Problem Set 4 Exercise #32: PS4_Ex32_Set.java
 * 
 * This program reads two set of integers and checks
 * if these two sets are identical.
 * 
 * Soh Li Min
 */

import java.util.*;

class TestSet {
  
  	public static void main(String[] args) {
    
    		Scanner scanner = new Scanner(System.in);
    
    		Set set1 = readSet(scanner, "Set 1: ");
    		Set set2 = readSet(scanner, "Set 2: ");
    
    		System.out.println("Set 1 has " + set1.getSize() + " element(s): " + set1.toString() );
    		System.out.println("Set 2 has " + set2.getSize() + " element(s): " + set2.toString() );
    
    		if (set1.isSubsetOf(set2) && set1.getSize() == set2.getSize()) {
    			System.out.println("Two sets are identical");
		} else {
    		System.out.println("Two sets have different values");
		}
	}

  	// Return a set of data
  	public static Set readSet(Scanner scanner, String index) {
    
    		System.out.print("Enter the number of elements in " + index);
    		int siz = scanner.nextInt();	
    		Set set = new Set(siz); 
    		System.out.print("Enter " + siz + " element(s): ");
    		for (int i = 0 ; i < siz ; i++) {
			set.add(scanner.nextInt());
		}

    		return set;
  	}
}
