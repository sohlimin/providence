/*
 * CS1010J Programming Methodology
 * Problem Set 4 Exercise #11: PS4_Ex11_ICCheckCode.java
 * 
 * This program reads a NRIC number and produces its check code.
 * 
 * Soh Li Min
 */

import java.util.*;
import java.util.stream.*;

class ICCheckCode {
  
  	public static void main(String[] args) {
    
    		System.out.print("Enter 7-digit NRIC number: ");
    		Scanner sc = new Scanner(System.in);
		String nric = sc.next();
		String[] okwhatever = new String[7];
		int[] jumbaJuice = new int[7];;
		for (int i = 0; i < nric.length() ; i++) {
			okwhatever[i] = String.valueOf(nric.charAt(i));
			jumbaJuice[i] = Integer.parseInt(okwhatever[i]);
		}
    		
		String leCode = generateCode(jumbaJuice);

		System.out.println("Check code is " + leCode);
  	}
  
  // Generate check code according to the given algorithm
  	public static String generateCode(int[] juice) {
    		
		int[] lifeForce = {2, 7, 6, 5, 4, 3, 2};
		int sum = IntStream.range(0, juice.length)
					.map(i -> lifeForce[i] * juice[i]).sum();
		
		int step3 = 11 - (sum % 11);

		HashMap<Integer, String> mapper = new HashMap<Integer, String>();
		
		int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
		String[] code = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "Z", "J"};
		
		for (int i = 0 ; i < 10; i++) {
			mapper.put(num[i], code[i]);
		}

    		return mapper.get(step3);
  	}
}
