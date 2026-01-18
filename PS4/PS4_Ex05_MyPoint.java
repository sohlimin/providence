/*
 * CS1010J Programming Methodology
 * Problem Set 4 Exercise #05: PS4_Ex05_MyPoint.java
 * 
 * This class provides various routines to
 * manipulate points in the coordinate plane (x, y).
 * 
 * Soh Li Min
 */

import java.text.*;

class MyPoint {
  
  	private double xCoord, yCoord;
  
  	public MyPoint(double xInit, double yInit) {
   		this.xCoord = xInit;
		this.yCoord = yInit;
  	}
  
  	public double getX() {
    		return this.xCoord;
  	}
  
  	public double getY() {
    		return this.yCoord;
  	}
  
  	public void setX(double x) {
    		this.xCoord = x;
  	}
  
  	public void setY(double y) {
    		this.yCoord = y;
  	}
  
 	public double distanceTo(MyPoint another) {
    		double dx = this.xCoord - another.getX();
		double dy = this.yCoord - another.getY();
		return Math.sqrt(dx * dx + dy * dy);
  	}
  
  	public double computeRectArea(MyPoint another) {
     		double dx = this.xCoord - another.getX();
    		double dy = this.yCoord - another.getY();
		return Math.abs(dx * dy);
  	}
  
  // Return string representation of a point
  // Format: (x, y) where x and y are shown in 3 decimal places
  	public String toString() {
    		return String.format("(%.3f, %.3f)", this.xCoord, this.yCoord);
  	}
}
