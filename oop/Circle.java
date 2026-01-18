class Circle {
	private final Point centre;
	private final double radius;

	Circle(Point centre, double radius) { 
		this.centre = centre;
		this.radius = radius;
	}
	
	Circle(double x, double y, double radius) {
		this.centre = new Point(x, y);
		this.radius = radius;
	} // this is a constructor, a signature is what it takes in as params, and returns, multiple methods can coexist w the same name so long as their signature is diff (method overloading)

	@Override //parent class (Object) has a method with the same signature, but this (the child) has a different implementation : Method Overriding
	public String toString() {
		String output = String.format("Circle of radius %.3f centered at %s", radius, centre.toString());
		return output;
	}
} 

//Objects should know how to communicate with each other and not know each others' anatomy
//For this reason, implementation details should be kept secret as far as possible
