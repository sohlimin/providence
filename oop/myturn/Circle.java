class Circle {
	private int radius;
	private String colour;

	public void enlarge() {
		radius *= 2;
	}

	public int getRadius() {
		return radius;
	}
	
	public String getColour() {
		return colour;
	}

	public Circle(int rad, String col) {
		radius = rad;
		colour = col;
	}
	@Override
	String toString() {
		return "[ " + getRadius() + " , " + getColour() + " ]";
	}
	public boolean equals(Circle another) {
		return radius == another.radius && colour.equals(another.colour);
	}
}
