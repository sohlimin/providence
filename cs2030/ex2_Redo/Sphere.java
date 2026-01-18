class Sphere implements Shape3D {
    private final double r;
    
    Sphere(double r) {
        this.r = r;
    }

    public double volume() {
        return 4.0/3 * Math.PI * r * r * r;
    }

    public String toString() {
        return String.format("sphere [%.2f]", r);
    }
}
