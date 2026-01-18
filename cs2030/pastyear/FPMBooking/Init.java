class Init extends Transaction {
    
    Init(Seating plan) {
        super(plan, "Initializing");
    }
    
    @Override 
    public String toString() {
        return String.format("INIT:\n%s", super.toString());
    }
}
