class Point {
	private final double x;
	private final double y;

	Point(double a, double b) {
		this.x = a;
		this.y = b;
	}
	
	Point() {
		this.x = 0.0;
		this.y = 0.0;
	}

	// As every class inherits from Object, all user-defined objects have a toString() method, even if not defined explicitly.
	// If not defined explicitly, the default implementation is called, which is not useful to humans
	// We therefore define our own implementation below.	
	@Override
	public String toString() {
		return String.format("Point at [x = %.3f, y = %.3f]", this.x, this.y); //this. is optional
	}	
}
