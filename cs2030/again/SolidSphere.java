class SolidSphere extends Sphere implements Solid{
	private final double density;
	private final SolidImpl solidimpl;

	SolidSphere(double radius, double density) {
		super(radius);
		this.density = density;
		this.solidimpl = new SolidImpl(this, density);
	}

	public double mass() {
		return solidimpl.mass();
	}

	@Override
	public String toString() {
		return "solid-" + super.toString() + String.format(" with a mass of %.2f", mass());
	}
}
