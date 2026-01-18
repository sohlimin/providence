/*
 * CS1010J Programming Methodology
 * Problem Set 4 Exercise #09: PS4_Ex09_Fraction.java
 * 
 * A class to describe Fraction. A fraction has two attributes:
 * numerator and denominator.
 * 
 * <Type your name here>
 */

class Fraction {
  
    // Attributes
    private int numer;
    private int denom;
  
    // Constructor
    public Fraction(int numerator, int denominator) {
        this.numer = numerator;
        this.denom = denominator;
    }
  
    // Private helper method to calculate
    // and return greatest common divisor
    private int euclidGcd(int a, int b) {
        int remainder;
        
        // minor optimisation to allow algorithm to work with negative values of b
        // this situation may arise if the user inputs fractions of form a/-b or -a/-b
        // achieved by changing b > 0 to b != 0
        while (b != 0) {
            remainder = a % b;
            a = b;
            b = remainder;
        }      
        return a;
    }
  
    // Return a new Fraction object that is simplified from 'this' object
    // 'this' (the calling) fraction object should not be modified.
    private Fraction simplify() {
        int gcd = euclidGcd(numer, denom);
        int newNumer = numer / gcd;
        int newDenom = denom / gcd;
        
        // check to see if fraction is in from a/-b or -a/-b
        // if so, convert fraction to -a/b or a/b
        if (newDenom < 0) {
            newNumer *= -1;
            newDenom *= -1;
        }
        
        Fraction result = new Fraction(newNumer, newDenom);
        return result;
    }
  
    // Add this Fraction object with another and return
    // the sum as a new Fraction object in simplified form
    public Fraction add(Fraction another) {
        Fraction result = new Fraction(this.numer * another.denom + another.numer * this.denom, 
                this.denom * another.denom);
        return result.simplify();
    }
  
    // Return 'this' - 'another' as a new Fraction object
    // This approach has an upside - if the add method is correct, then the minus method
    // must be correct.
    // What's the downside?
    public Fraction minus(Fraction another) {
        return add(another.times(new Fraction(-1, 1)));
    }
  
    // Return 'this' * 'another' as a new Fraction object
    public Fraction times(Fraction another) {
        Fraction result = new Fraction(this.numer * another.numer, this.denom * another.denom); 
        return result.simplify();  // stub
    }
  
    // Return 'this' / 'another' as a new Fraction object
    public Fraction divide(Fraction another) {
        return times(new Fraction(another.denom, another.numer));
    }
    
    public double evaluate() {
        return (double) numer / denom;
    }

    // return "numerator/denominator"
    public String toString() {
        return String.format("%d/%d", numer, denom);
    }
  
    // Check if this object equals another
    // Rationalise how this works.
    public boolean equals(Fraction another) {
        return minus(another).numer == 0;
    }
  
    // Check if this object is larger than another
    public boolean largerThan(Fraction another) {
        return minus(another).numer > 0;
    }
}
