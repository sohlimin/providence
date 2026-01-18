/*
 * CS1010J Programming Methodology
 * Problem Set 4 Exercise #03: PS4_Ex03_FoldTray.java
 * 
 * This program reads the lengths of two sides of a
 * rectangle tray and computes the minimum perimeter
 * after folding it once along the x-axis or y-axis.
 * 
 * THIS FILE IS COMPLETE; NOT TO BE CHANGED
 */

import java.util.*;

class FoldTray {
  
  public static void main(String[] args) {
    
    Scanner scanner = new Scanner(System.in);
    
    System.out.print("Enter lengths of two sides: ");
    double length = scanner.nextDouble();
    double width = scanner.nextDouble();
    
    Tray tray = new Tray(length, width);
    
    tray.fold();
    
    System.out.println("Min perimeter after fold = " + tray.computePerimeter());
  }
}