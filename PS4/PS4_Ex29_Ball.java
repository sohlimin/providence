/*
 * CS1010J Programming Methodology
 * Problem Set 4 Exercise #29: PS4_Ex29_Ball.java
 * 
 * Ball class has two attributes: colour and radius.
 * 
 * Soh Li Min
 */

class Ball {
  
  	private String colour;
  	private double radius;
  
  	public Ball(String colour, double radius) {
    		this.colour = colour;
		this.radius = radius;
  	}
  
  	// Return colour of a ball
  	public String getColour() {
		return this.colour;
  	}
  
  	// Return radius of a ball
  	public double getRadius() {
    		return this.radius;
  	}
  
  	// Compare this ball with another.
  	// Return true if they have the same values, or false otherwise
  	public boolean equals(Ball another) {
    		return this.colour.toLowerCase().equals(another.colour.toLowerCase()) && this.radius == another.radius;
  	}
  
  	// Return e.g. "[colour = Red, radius = 5]"
  	public String toString() {
    	return String.format("[colour = %s, radius = %.1f]", this.colour, this.radius);
  	}
}

