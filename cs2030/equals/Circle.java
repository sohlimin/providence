class Circle implements Shape {
    private final double radius;

    Circle(double radius) {
        this.radius = radius;
    }
    
    /*
    public boolean equals(Circle circle) {
        return circle.radius == this.radius;
    }
    */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj instanceof Circle circle) {
            return circle.radius == this.radius;
        }

        return false;
    }
    @Override
    public String toString() {
        return String.format("Circle with radius: %.3f", this.radius);
    }
}
