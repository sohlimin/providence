class SolidSphere extends Sphere implements Solid {
    private final SolidImpl solidImpl;
    
    SolidSphere(double r, double d) {
        super(r);
        solidImpl = new SolidImpl(this ,d);
    }
    
    public double mass() {
        return solidImpl.mass();
    }
    
    public String toString() {
        return String.format("solid-%s with a mass of %.2f", super.toString(), mass());
    }
}
