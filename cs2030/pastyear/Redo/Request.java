class Request extends Transaction {
    private final Pair<Integer,Integer> rowOfSeats; 
    private int billing;
    private final boolean bankOutcome;
    
    Request(Seating plan, Pair<Integer,Integer> rowOfSeats, int billing, Bank bank) {
        super(plan, "\nRequesting\n");
        this.rowOfSeats = rowOfSeats;
        this.billing = billing;
        this.bankOutcome = bank.test(billing);
    }

    Transaction transact(Transaction t) {
        if (t.seating().isAvailable(rowOfSeats)) {
            if (bankOutcome) {
                return new Approve(t.updateSeating(rowOfSeats),
                        t.updateLog(String.format("billed %d; booked %s\n", billing,
                            new Pair<>(rowOfSeats.t(), rowOfSeats.t() + rowOfSeats.u() -1))));
            } else {
                return new Reject(t.seating(), 
                        t.updateLog(String.format("not billed %d\n", billing)));
            }
        } else {
            return t;
        }
    }

    public String toString() {
        return String.format("REQUEST:%s",super.toString());
    }

}
