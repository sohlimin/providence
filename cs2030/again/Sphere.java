class Sphere implements Shape3D {
	private final double radius;

	Sphere(double radius){
		this.radius = radius;
	}

	public double volume() {
		return 4.0/3 * Math.PI * Math.pow(this.radius, 3);
	}

	@Override
	public String toString() {
		return String.format("sphere [%.2f]", this.radius);
	}
}
