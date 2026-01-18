class Approve extends Transaction {
    private final int billing;
    private final Pair<Integer, Integer> requestedSeats;

    Approve(Seating newSeating, int billing, Pair<Integer,Integer> requestedSeats){
        super(newSeating);
        this.billing = billing;
        this.requestedSeats = requestedSeats;
    }

    public Transaction transact(Transaction t) {
        return this;
    }
    
    public String toString() {
        return String.format("APPROVED\nInitializing\nbilled %d; booked %s\n%s",
                this.billing, this.requestedSeats, super.toString());
    }

}
