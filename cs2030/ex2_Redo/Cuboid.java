class Cuboid implements Shape3D {
    private final double h;
    private final double w;
    private final double l;

    Cuboid(double h, double w, double l) {
        this.h = h;
        this.w = w;
        this.l = l;
    }
    
    public double volume() {
        return h*w*l;
    }

    public String toString() {
        return String.format("cuboid [%.2f x %.2f x %.2f]", h, w, l);
    }
}
