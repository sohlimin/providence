/*
 * CS1010J Programming Methodology
 * Problem Set 4 Exercise #09: PS4_Ex09_Fraction.java
 * 
 * A class to describe Fraction. A fraction has two attributes:
 * numerator and denominator.
 * 
 * Soh Li Min
 */

class Fraction {
  
  	private int numer, denom;
  
  	public Fraction(int numerator, int denominator) {
    	this.numer = numerator;
	this.denom = denominator;
  	}
  
  	private int euclidGcd(int a, int b) {
    
    		int remainder;
    		while (b > 0) {
      			remainder = a % b;
      			a = b;
      			b = remainder;
    		}   
    		return a;
  	}
  
  	private Fraction simplify() {
    		
		int div = euclidGcd(this.denom, Math.abs(this.numer));
    	//	if (this.numer < ){
				
	//	} else {
			Fraction result = new Fraction(this.numer / div, this.denom / div);
	//	}
    		return result;
  	}
  
  	public Fraction add(Fraction another) {			//FADHIL FEEDBACK: Prematurely optimised - more unnecessary complexity
    		
		int commDenom = 0;
		int sumOfNumer = 0;
		int div = euclidGcd(this.denom, another.denom);
		//The code block below makes no difference
		/*if (this.denom == another.denom) {
			commDenom = this.denom;
		      	sumOfNumer = this.numer + another.numer;	
		} else*/ if (div == 1) {
			commDenom = this.denom * another.denom;
			sumOfNumer = this.numer * another.denom + another.numer * this.denom;
		} else {
			commDenom = this.denom * (another.denom / div);
			sumOfNumer = (this.numer * (another.denom / div)) + (another.numer * (this.denom / div));	
		}
    		Fraction result = new Fraction(sumOfNumer, commDenom).simplify();	 
        	return result;
  	}
  
  	public Fraction minus(Fraction another) {
    		
		int commDenom = 0;
		int difOfNumer = 0;
		int div = euclidGcd(this.denom, another.denom);
		if (div == 1) {
			commDenom = this.denom * another.denom;
			difOfNumer = this.numer * another.denom - another.numer * this.denom;
		} else {
			commDenom = this.denom * (another.denom / div);
			difOfNumer = (this.numer * (another.denom / div)) - (another.numer * (this.denom / div));
		}
    		Fraction result = new Fraction(difOfNumer, commDenom).simplify();
    		return result;
  	}
  
  	public Fraction times(Fraction another) {
   		
		int newDenom = this.denom * another.denom;
		int newNumer = this.numer * another.numer;
    		Fraction result = new Fraction(newNumer, newDenom).simplify(); 
    		return result;
  	}
  
  	public Fraction divide(Fraction another) {
   		
		int newDenom = this.denom * Math.abs(another.numer);
       		int newNumer = this.numer * another.denom;	       
		Fraction result = new Fraction(newNumer, newDenom).simplify();
    		
    		if (another.numer < 0 ^ this.numer < 0) {
			return new Fraction(-result.numer, result.denom);
		} else {
			return result;
		}
  	}
  
  	public String toString() {
		return String.format("%d/%d", this.numer, this.denom); 
  	}
  
  // Check if this object equals another
  	public boolean equals(Fraction another) {
   		Fraction simp = another.simplify();
		Fraction temp = new Fraction(this.numer, this.denom).simplify();
    		return temp.numer == simp.numer && temp.denom == simp.denom;
  	}
  
  // Check if this object is larger than another
  	public boolean largerThan(Fraction another) {
		int newNumer = 0;
		int otherNumer = 0;
		int div = euclidGcd(this.denom, another.denom);
		if (div == 1) {
			newNumer = this.numer * another.denom;
			otherNumer = another.numer * this.denom;
		} else {
			newNumer = this.numer * (another.denom / div);
			otherNumer = another.numer * (this.denom / div);
		}
		return newNumer > otherNumer; 
	}
}
