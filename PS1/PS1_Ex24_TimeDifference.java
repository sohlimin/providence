/*
 * CS1010J Programming Methodology
 * Problem Set 1 Exercise #24: PS1_Ex24_TimeDifference.java
 * 
 * <Fill in a short description of this program>
 * 
 * 
 * Soh Li Min
 */
import java.util.Scanner;
import java.text.*;

class TimeDifference {
  
	public static void main(String[] args) {
    
    		Scanner sc = new Scanner(System.in);
		int startHour = sc.nextInt();
	       	int startMin = sc.nextInt();
		int startSec = sc.nextInt();

		System.out.println();

		int endHour = sc.nextInt();
		int endMin = sc.nextInt();
		int endSec = sc.nextInt();
		
		int hour = endHour - startHour;
		int min = endMin - startMin;
		int sec = endSec - startSec;

		if (min < 0) {
			hour--;
			min += 60;
		} 
		
		if (sec < 0) {
			min--;
			sec += 60;
		}
		

    		// To show output as two digits with possible leading zero.
    		// For example, df.format(8) will show 8 as 08
    		DecimalFormat df = new DecimalFormat("00");
    		
		System.out.println("Time difference: " + df.format(hour) + ":" + df.format(min) +  ":" + df.format(sec) );
	}
}

