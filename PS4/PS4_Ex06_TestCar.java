/*
 * CS1010J Programming Methodology
 * Problem Set 4 Exercise #06: PS4_Ex06_Car.java
 * 
 * This program uses Car class. It reads in a car's information,
 * and creates a Car object. It then reads a list of trips, updates
 * the odometer reading, and computes the average distance travelled per trip.
 * 
 * Soh Li Min
 */

import java.util.*;

class TestCar {
  
  	public static void main(String[] args) {
    
        
    		System.out.print("Enter model: ");
    		Scanner sc = new Scanner(System.in).useDelimiter("\n");
		String m = sc.next();
    
		System.out.print("Enter colour: ");
		String c = sc.next();
    
    		System.out.print("Enter odometer value: ");
    		double o = sc.nextDouble();
    
   		 // create a car object with 3 values read
    		Car lexus = new Car(m, c, o);
    
    		System.out.print("Enter the number of trips: ");
    		int noOfTrips = sc.nextInt();
		//ArrayList<Double> listOfDists = new ArrayList<>();
		double totalDist = 0;
		for (int i = 1; i <= noOfTrips ; i++) {
			System.out.print("Distance for trip " + i + ": ");
			totalDist += sc.nextDouble();
			//listOfDists.add(sc.nextDouble());
		}
		
		/*	
   		double totalDist = 0; 
    		// compute the total distance travelled
    		for (Double dist : listOfDists) {
			totalDist += dist;
		}	
    		*/
    		// update car with the total distance
    		lexus.updateOdometer(totalDist);
   
    
    		System.out.println("Model: " + lexus.getModel() );
    		System.out.println("Colour: " + lexus.getColour() );
    		System.out.println(String.format("Odometer: %.1f", lexus.getOdometer()) );
    
    		System.out.println("Trips: " + noOfTrips );
		double averageDist = totalDist / noOfTrips;
    		System.out.println("Distance per trip: " + averageDist );
  	}
}
