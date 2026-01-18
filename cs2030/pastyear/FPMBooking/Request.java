class Request extends Transaction {
    private final Pair<Integer, Integer> rowOfSeats;
    private final int billing;
    private final Bank bank;

    Request(Seating plan, Pair<Integer, Integer> rowOfSeats,
            int billing, Bank bank) {
        super(plan, "Requesting");
        this.rowOfSeats = rowOfSeats;
        this.billing = billing;
        this.bank = bank;
    }
    
    Transaction transact(Transaction t) {
        Seating plan = t.getSeating();
        if (plan.isAvailable(rowOfSeats)) {
            if (bank.test(billing)) {
                Seating newSeating = plan.book(rowOfSeats);
                String newLog = String.format("%s\nbilled %d; booked %s",
                        t.getLog(),
                        billing, 
                        new Pair<>(rowOfSeats.t(), 
                            rowOfSeats.t() + rowOfSeats.u() - 1));
                return new Approve(newSeating, newLog);
            } else {
                String newLog = String.format("%s\nnot billed %d", 
                        t.getLog(), billing);
                return new Reject(plan, newLog);
            }
        } else {
            return t;
        }
    }

    @Override 
    public String toString() {
        return String.format("REQUEST:\n%s", super.toString());
    }
}
