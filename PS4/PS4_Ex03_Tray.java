/*
 * CS1010J Programming Methodology
 * Problem Set 4 Exercise #03: PS4_Ex03_Tray.java
 * 
 * A rectangle tray has two attributes: length and width.
 * 
 * Soh Li Min
 */

class Tray {
  
 	private double length;
  	private double width;
  
  	public Tray(double side1, double side2) {
    		this.length = side1;
		this.width = side2; 
  	}
  
  	public void fold() {
    		if(this.length <= this.width){
			this.width /= 2.0;
		} else {
			this.length /= 2.0;
		}
      	}
  
  	public double computePerimeter() {
    		double p = (this.length + this.width) * 2.0;
		return p;
  	}
}
