/*
 * CS1010J Programming Methodology
 * Problem Set 1 Exercise #21: PS1_Ex21_BMI.java
 * 
 * <Fill in a short description of this program>
 * 
 * 
 * <Type your name here>
 */
import java.util.Scanner;


class BMI {
  
  	public static void main(String[] args) {
    
    
   	System.out.print("Enter your gender (0 for female, 1 for male): ");
    	Scanner sc = new Scanner(System.in);
	int gend = sc.nextInt();
        	
    
    	System.out.print("Enter your weight (kg) and height (m): ");        
	double weight = sc.nextDouble();
    	double height = sc.nextDouble();	
    	int bType = bodyType(gend, weight, height);
    
    	switch (bType) {
    		case -1 :
    			System.out.println("Stuff yourself with more food!");
			break;
		case 0 :
    			System.out.println("Great! Maintain it!");
			break;
		case 1 :
    			System.out.println("Time to join the gym!");
			break;
  	}
	}
  
	public static int bodyType(int gender, double weight, double height) {
   		double bmi = weight / (height *  height);
		if (gender == 0){
	       		if (bmi <= 19) {
	 			return -1;
			} else if (bmi > 19 && bmi <= 24) {
				return 0;
			} else {
				return 1;
			}			
  		} else { //we removed check for gender = 1 because what if user entered 2, the program dunno what to return
			if (bmi < 20) {
				return -1;
			} else if (bmi > 20 & bmi <= 25) {
				return 0;
			} else {
				return 1;
			}
		}
	}
}
