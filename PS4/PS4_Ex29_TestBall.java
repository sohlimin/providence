/*
 * CS1010J Programming Methodology
 * Problem Set 4 Exercise #29: PS4_Ex29_TestBall.java
 * 
 * This program:
 * i.  Create an array of three balls with given colour and radius.
 * ii. Check whether any two balls have the same color and radius.
 * iv. Print out the radius of the biggest ball.
 * 
 * Soh Li Min
 */

import java.util.*;

class TestBall {
  
  	public static void main(String[] args) {
    
    		Scanner sc = new Scanner(System.in);
    
    		Ball[] balls = new Ball[3];  // 3 balls
    
    		for (int i = 0; i < 3; i++) {
      			System.out.print("Enter colour and radius of ball " + (i+1) + ": ");
			String c = sc.next();
			double r = sc.nextDouble();
			balls[i] = new Ball(c, r);
    		}	
    		
		boolean allSame = balls[0].equals(balls[1]) && balls[0].equals(balls[2]);	
    		
		boolean allDiff = !(balls[0].equals(balls[1])) && !(balls[1].equals(balls[2]));
		
		boolean same12 = balls[0].equals(balls[1]) && !(balls[1].equals(balls[2]));			
		
		boolean same23 = balls[1].equals(balls[2]) && !(balls[0].equals(balls[1]));			
		
		
		boolean same13 = balls[0].equals(balls[2]) && !(balls[0].equals(balls[1]));			

		if (allSame) {
    			System.out.println("Three balls are all the same");
		}

    		if (allDiff) {
			System.out.println("Three balls are all different");
		}

		if (same12) {
			System.out.println("1st and 2nd balls are the same");
    		}

		if (same23) {
    			System.out.println("2nd and 3rd balls are the same");
		}

		if (same13) {
    			System.out.println("1st and 3rd balls are the same");
		}
    		
		double maxR = 0;

    		for (int i = 0; i < 3; i++) {
			
			if (balls[i].getRadius() > maxR) {
				maxR = balls[i].getRadius();
			}
		}
    		
		System.out.println("The largest radius is: " + maxR);
  	}
}
