abstract class Transaction {
    private final Seating plan;
    private final String log;
    
    Transaction(Seating plan, String log) {
        this.plan = plan;
        this.log = log;
    }
    
    Seating getSeating() {
        return plan;
    }
    
    String getLog() {
        return log;
    }
    
    String addToLog(String toAdd) {
        return log + toAdd;
    }

    Seating book(Pair<Integer, Integer> seatsToBook) {
        return plan.book(seatsToBook);
    }

    Transaction transact(Transaction t) {
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s\n%s", this.log, this.plan.toString());
    }
}
