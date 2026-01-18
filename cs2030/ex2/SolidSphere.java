class SolidSphere extends Sphere {
        private final SolidImpl solidimpl;   
	private final double density;
        SolidSphere(double radius, double d){
        	super(radius);
        	this.density = d;
        	this.solidimpl = new SolidImpl(new Sphere(radius), d);
        }
	public String toString(){
              	return  "solid-" + super.toString() + String.format(" with a mass of %.2f", mass());
        }
	public double mass(){
               	return solidimpl.mass();
        }
	public double volume(){
                return super.volume();
        }
}
