/*
 * CS1010J Programming Methodology
 * Problem Set 2 Exercise #11: PS2_Ex11_CycleLength.java
 * 
 * <Fill in a short description of this program>
 * 
 * 
 * Soh Li Min
 */

import java.util.Scanner;

class CycleLength {
  
  	public static void main(String[] args) {
    
    		System.out.print("Enter range: ");
		Scanner sc = new Scanner(System.in);    
    		int low = sc.nextInt();
		int high = sc.nextInt();
    		
		int maxL = maxCycleLength(low, high);
    		System.out.println("Maximum cycle length = " + maxL);
  	}
  
  	// Calculate how many rounds are needed to process n till 1
  	public static int countIterations(int n) {
    		
		int noIterations = 0;
		while (n != 1) {
			if (n % 2 == 0) {
				n /= 2;
			} else {
				n = 3 * n +1;
			}
			noIterations++;
		}
    		return noIterations;
  	}
  	
	//List list = new ArrayList(high - low + 1);
  	
	// Calculate the cycle length of all the numbers
  	// in range [low, high]; return maximum cycle length
  	public static int maxCycleLength(int low, int high) {
    		
		//List<Integer> list = new ArrayList<Integer>(int high - low + 1);
		int higherIterationz = 0;
		//List list = new ArrayList(high - low + 1);
		for (int i = high ; i >= low ; i-- ) {
    			int iterationz = countIterations(i);
			//list.add(iterationz);
			if (iterationz > higherIterationz) {			
				higherIterationz = iterationz;
			}
		}
		
		//System.out.println(list);

		return higherIterationz;
  	}
}
