class Request extends Transaction {
    private final Pair<Integer,Integer> rowOfSeats;
    private final int billing;
    private final Bank bank;

    Request(Seating plan, Pair<Integer,Integer> rowOfSeats, int billing, Bank bank) {
        super(plan, "Requesting");
        this.rowOfSeats = rowOfSeats;
        this.billing = billing;
        this.bank = bank;
    }
    
    public Transaction transact(Transaction t) {
        if (t.getSeating().isAvailable(rowOfSeats)) {
            if (this.bank.test(this.billing)) {
                return new Approve(t.updateSeating(rowOfSeats), 
                        t.updateLog(String.format(
                                "\nbilled %d; booked %s", this.billing,
                                new Pair<Integer,Integer>(rowOfSeats.t(),
                                    rowOfSeats.t() + rowOfSeats.u() - 1))));
            } else {
                return new Reject(t.getSeating(), t.updateLog(
                    String.format("\nnot billed %d", this.billing))); 
            }
            
        
        } else {
            return t;
        }
    }

    public String toString() {
        return String.format("REQUEST:\n%s", super.toString());
    }


}
