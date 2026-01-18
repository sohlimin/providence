/*
 * CS1010J Programming Methodology
 * Problem Set 4 Exercise #07: PS4_Ex07_Complex.java
 * 
 * A complex number has the form a + bi where a is the real part and
 * b is the imaginary part.
 * 
 * Soh Li Min
 */

class Complex {
  
	private int r, i;
  
  	public Complex(int re, int im) {
    		r = re;
		i = im;
  	}
  
  
  	public void add(Complex another) {
    		r += another.r;
		i += another.i;
  	}
  
  	public void minus(Complex another) {
		r -= another.r;
	      	i -= another.i;    
  	}
  
  	public void multiple(Complex another) {
		r = r * another.r - i * another.i;
	   	i = i * another.r + r * another.i;	
  	}
  
  	public void divide(Complex another) {
		r = (r * another.r + i * another.i) / (another.r * another.r + another.i * another.i);
	     	i = (i * another.r - r * another.i) / (another.r * another.r + another.i * another.i);
  	}
  
  	// Return "(real + imag'i')"
  	public String toString() {
    		return String.format("(%d + %di)", r, i);
  	}
}
