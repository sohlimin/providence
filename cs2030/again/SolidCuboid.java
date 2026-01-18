class SolidCuboid extends Cuboid implements Solid {
	private final double density;
	private final SolidImpl solidimpl;

	SolidCuboid(double height, double width, double length, double density) {
		super(height, width, length);
		this.solidimpl = new SolidImpl(this, density);		
		this.density = density;
	}

	public double mass() {
		return solidimpl.mass();
	}

	public String toString() {
		return "solid-" + super.toString() + String.format(" with a mass of %.2f", mass());
	}
}	
