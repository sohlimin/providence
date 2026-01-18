/*
 * CS1010J Programming Methodology
 * Problem Set 4 Exercise #09: PS4_Ex09_TestFraction.java
 * 
 * This programs test out the computations on two Fraction objects.
 * 
 * THIS PROGRAM IS COMPLETE; NOT TO BE CHANGED
 */

import java.util.*;

class TestFraction {
  
  public static void main(String[] args) {
    
    Scanner scanner = new Scanner(System.in);
    
    System.out.print("Enter 1st fraction: ");
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    Fraction frac1 = new Fraction(a, b);
    
    System.out.print("Enter 2nd fraction: ");
    a = scanner.nextInt();
    b = scanner.nextInt();
    Fraction frac2 = new Fraction(a, b);
    
    System.out.println("1st fraction is " + frac1);
    System.out.println("2nd fraction is " + frac2);
    
    if ( frac1.equals(frac2) ) {
      System.out.println("The two fractions are the same.");
    } else if ( frac1.largerThan(frac2) ) {
      System.out.println(frac1 + " is larger than " + frac2);
    } else {
      System.out.println(frac2 + " is larger than " + frac1);
    }
    
    Fraction sum = frac1.add(frac2);           // frac1 + frac2
    System.out.println(frac1 + " + " + frac2 + " = " + sum);
    
    Fraction difference = frac1.minus(frac2);  // frac1 - frac2
    System.out.println(frac1 + " - " + frac2 + " = " + difference);
    
    Fraction product = frac1.times(frac2);     // frac1 * frac2
    System.out.println(frac1 + " * " + frac2 + " = " + product);
    
    // assume that frac2 is not 0
    Fraction quotient = frac1.divide(frac2);   // frac1 / frac2
    System.out.println(frac1 + " / " + frac2 + " = " + quotient);
  }
} 