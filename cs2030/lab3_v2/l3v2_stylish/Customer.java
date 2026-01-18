class Customer implements Comparable<Customer> {
    private final int id;
    private final double arrTime;
    private final double svcTime; //new
    
    /* 
     * old
     *
    Customer(int id, double arrTime){
        this.id = id;
        this.arrTime = arrTime;
    }
    */

    Customer(int id, double arrT, double svcT) {
        this.id = id;
        this.arrTime = arrT;
        this.svcTime = svcT;
    }

    public String toString() {
        return "customer " + this.id;
    }
    
    public double svcTime() {
        return this.svcTime;
    }
    
    @Override
    public int compareTo(Customer other) {
        return Double.compare(this.arrTime, other.arrTime);
    }

    public boolean canBeServed(double serverAvlTime) {
        return this.arrTime >= serverAvlTime;
    }
    
    public double serveTill() {
        return this.arrTime + this.svcTime;
    }
}
