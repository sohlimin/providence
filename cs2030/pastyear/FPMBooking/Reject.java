class Reject extends Transaction {

    Reject(Seating plan, String log) {
        super(plan, log);
    }
    
    @Override 
    public String toString() {
        return String.format("REJECTED:\n%s", super.toString());
    }
}
