class Circle {
	private final static double epsilon = 1E-15;
	private final Point centre;
	private final double radius;

	Circle(Point centre, double radius) {
		this.centre = centre;
		this.radius = radius;
	}

	@Override
	public String toString() {
		return String.format("circle of radius %.1f centred at %s", radius, centre.toString());
	}

	boolean containsPoint(Point p) {
		return p.distanceTo(this.centre) < this.radius + epsilon;
	}

}
