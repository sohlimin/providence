class Customer {
    private final int identifier;
    private final double arrivalTime;

    Customer(int identifier, double arrivalTime) {
        this.identifier = identifier;
        this.arrivalTime = arrivalTime;
    }
    
    public boolean canBeServed(double time) {
        return time <= arrivalTime;
    }

    public double serveTill(double serviceTime) {
        return arrivalTime + serviceTime;
    }

    public String toString() {
        return String.format("customer %d", identifier);
    }
}
