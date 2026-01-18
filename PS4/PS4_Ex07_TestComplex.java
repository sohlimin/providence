/*
 * CS1010J Programming Methodology
 * Problem Set 4 Exercise #07: PS4_Ex07_TestComplex.java
 * 
 * This program does addition, minus, multiplication and division
 * on two complex numbers.
 * 
 * Soh Li Min 
 */

import java.util.*;

class TestComplex {
	
	public static void main(String[] args) {
    
    		Scanner sc = new Scanner(System.in);
    		int real = sc.nextInt();
    		int imag = sc.nextInt();
    		Complex monk = new Complex(real, imag);
    		System.out.println("Complex number " + monk.toString() + " created");
    
    		// read commands, each followed by a complex number
    		// stop when "q" is read

    		char nextCom;
    		Complex nun = new Complex(rl, img);
		while (nextCom != 'q') {
    		
    		char com = sc.next().charAt(0);
		int rl = sc.nextInt();
    		int img = sc.nextInt();
			if (com == '+') {
    				monk.add(nun);
				System.out.println("After addition: " + monk.toString());
    			} else if (com == '-') {
				monk.minus(nun);
    				System.out.println("After subtraction: " + monk.toString());
    			} else if (com == '*') {
				monk.multiple(nun);
    				System.out.println("After multiplication: " + monk.toString());
    			} else if (com == '/') {   
				monk.divide(nun);
    				System.out.println("After division: " + monk.toString());
    			} else if (com == 'q') {
	    			break;
    			}
			nextCom = sc.next().charAt(0);
		}
			
  	}
}
