/*
 * CS1010J Programming Methodology
 * Problem Set 4 Exercise #10: PS4_Ex10_Calculator.java
 * 
 * This program implements a simple calculator that can perform
 * addition, subtraction, multiplication and division on integers.
 * 
 * Soh
 */

import java.util.*;
import java.text.*;

class Calculator {
  
  	public static void main(String[] args) {
    
    		Scanner sc = new Scanner(System.in);
    		System.out.print("Enter the number of operations: ");
		
		int noOfOps = sc.nextInt();
		
		for (int i = 0 ; i < noOfOps ; i++) {		
			
			String exp = sc.useDelimiter("\n").next();
			String[] expression  = exp.split(" ");	
			int operand1 = Integer.parseInt(expression[0]);
			String operator = expression[1];
			int operand2 = Integer.parseInt(expression[2]);
   			String answer = compute(operand1, operand2, operator);
			System.out.println(exp + " = " + answer);
		}
	}		
	public static String compute(int o1,int o2,String o) {
		int result = 0;
		double res = 0.0;
		if (o.equals("*")) {
			result = o1 * o2;
			return String.format("%d", result);
		} else if (o.equals("+")) {
			result = o1 + o2;
			return String.format("%d", result);
		} else if (o.equals("-")) {
			result = o1 - o2;
			return String.format("%d", result);
		} else if (o.equals("/")) {
			res = (double) o1 / o2;
			return String.format("%.2f", res);
		
		} else {
			return "?";
		}
	
	}
}
