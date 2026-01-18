class Approve extends Transaction {

    Approve(Seating plan, String log) {
        super(plan, log);
    }
    
    @Override 
    public String toString() {
        return String.format("APPROVED:\n%s", super.toString());
    }
}
