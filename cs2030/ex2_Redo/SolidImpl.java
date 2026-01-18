class SolidImpl implements Shape3D, Solid {
    private final Shape3D shape;
    private final double d;

    SolidImpl(Shape3D shape, double d) {
        this.shape = shape;
        this.d = d;
    }
    
    public double volume() {
        return shape.volume();
    }

    public double mass() {
        return this.volume() * d;
    }
}

