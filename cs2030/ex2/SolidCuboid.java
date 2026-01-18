class SolidCuboid extends Cuboid implements Solid{

            private final double density;
            private final SolidImpl solidimpl;
            
	    SolidCuboid(double l, double w, double h, double d){
                super(h, w, l);
                this.density = d;
   		this.solidimpl = new SolidImpl(new Cuboid(h, w, l), d); 
                
           }
            public String toString(){
                return "solid-" + super.toString() + String.format(" with a mass of %.2f", mass());
            }
            public double mass(){
		return solidimpl.mass();
            }
            public double volume(){
                return super.volume();
           }
}
