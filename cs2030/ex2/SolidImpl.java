class SolidImpl implements Shape3D, Solid {
	private Shape3D shape;
       	private double density;
       	//private double volume;
       	
	SolidImpl(Shape3D shape, double d) {
        	this.shape = shape;
                this.density = d;
        	System.out.println("trace");
	}
        public double volume(){
                return shape.volume();
        }
        public double mass(){
                return volume() * density;
        }
}
