class SolidImpl implements Shape3D, Solid {
	private final Shape3D ajajaj;
	private final double density;

	SolidImpl(Shape3D shape, double density) {
		this.ajajaj = shape;
	       	this.density = density;
	}
	public double volume() {
		return this.ajajaj.volume();
	}
	public double mass() {
		return volume() * density;
	}
}
