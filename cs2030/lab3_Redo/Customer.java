class Customer implements Comparable<Customer> {
    private final int identifier;
    private final double arrivalTime;
    //lab 3
    private final double serviceTime;

    Customer(int identifier, double arrivalTime) {
        this.identifier = identifier;
        this.arrivalTime = arrivalTime;
        //lab 3
        this.serviceTime = 1.0;
    }
    
    Customer(int identifier, double arrivalTime, double serviceTime) {
        this.identifier = identifier;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
    }
    
    public double serviceTime() {
        return serviceTime;
    }

    public boolean canBeServed(double time) {
        return time <= arrivalTime;
    }
    
    @Override
    public int compareTo(Customer other) {
        return Double.compare(arrivalTime, other.arrivalTime);
    }

    public double serveTill() {
        return arrivalTime + serviceTime;
    }

    public String toString() {
        return String.format("customer %d", identifier);
    }
}
