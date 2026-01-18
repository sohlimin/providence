/*
 * CS1010J Programming Methodology
 * Problem Set 4 Exercise #32: PS4_Ex32_Set.java
 * 
 * A Set has two attributes: an array used to store value and a 'size'
 * that indicates the number of data in the Set.
 * 
 * Soh Li Min
 */

import java.util.*;

class Set {
  
  	private int size;     // the number of data in a set
  	public int[] values; // array as an attribute

  	public Set(int num) {
    		this.size = num;
		this.values = new int[num]; 
  	}
  
  	// Add data to the back (first empty slot) of the set
  	public void add(int data) {
		boolean ran = false;
   		for (int i = 0 ; i < this.size ; i++) {
			if (this.values[i] == 0 && !ran) {
				this.values[i] = data;
				ran = true;	 
			}
		}
  	}

  	// Return true if data exists in the set, or false otherwise
  	public boolean contains(int data) {	
		for (int q : values) {
			if (q == data) {
				return true;
			}
		}
		return false;
  	}
  
  	// Return the number of integers in this set 
  	public int getSize() {
   		return this.size;
  	}
  
  	// Check if this set is a subset of another set
  	public boolean isSubsetOf(Set another) {
    		//if order matters
		/*
		boolean subsetDetect;
		detectSubset: {
		for (int i = 0 ; i < another.size - this.size - 1; i++) {
			for (int j = this.size - 1 ; j < another.size - 1 ; j++) {
				subsetDetect = Arrays.equals(values, 0, size - 1, another, i, j); 	
				if (subsetDetect) {
					return subsetDetect;
					break detectSubset;
				}
			}
		}
		}	
		*/

		//if order doesnt matter, reuse contains. Not sure how to account for if set another has 2 1s, and values has 4 1s.
		for (int p : values) {
			if (!(another.contains(p))) { 
				return false;
			} else {
				return true;
			}
		} 
		return false;
  	}
  
  	// Check if 'this' set has the same content as 'another' set
  	public boolean equals(Set another) {
    		return Arrays.equals(values, another.values);
  	}
  
  	// Return string representation of values in the Set.
  	// Format: e.g. "[1, 2, 3]"
  	public String toString() {
    		return String.format(Arrays.toString(values)); 
  	}
}
