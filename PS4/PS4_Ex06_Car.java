/*
 * CS1010J Programming Methodology
 * Problem Set 4 Exercise #06: PS4_Ex06_Car.java
 * 
 * Define a Car class consisting of three attributes:
 * model, colour, and odometer reading.
 * 
 * Soh Li Min
 */

class Car {
  
  	private String model;
	private String color;
	private double odom;
  
  	public Car(String mod, String col, double odo) {
    		this.model = mod;
		this.color = col;
		this.odom = odo;
  	}
  
  	public String getModel() {
    		return this.model;
  	}
  
  	public String getColour() {
    		return this.color;
  	}
  
  	public double getOdometer() {
    		return this.odom;
  	}
  
  	// Update the odometer with the distance travelled
  	public void updateOdometer(double distance) {
   		this.odom += distance;
	       if(this.odom > 999.9){
		       this.odom %= 1000;
	        }	       
  	}
}
