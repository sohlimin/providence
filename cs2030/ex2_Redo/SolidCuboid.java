class SolidCuboid extends Cuboid implements Solid {
    private final SolidImpl solidImpl; 

    SolidCuboid(double h, double w, double l, double d) {
        super(h,w,l);
        solidImpl = new SolidImpl(this, d); 
    }
    
    public double mass() {
        return solidImpl.mass();
    }
    
    public String toString() {
        return String.format("solid-%s with a mass of %.2f", super.toString(), mass());
    }
}
