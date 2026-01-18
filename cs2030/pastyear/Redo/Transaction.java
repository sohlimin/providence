abstract class Transaction {
    private final Seating seating;
    private final String log;
    
    Transaction(Seating seating, String log) {
        this.seating = seating;
        this.log = log;
    }

    Transaction transact(Transaction t) {
        return this;
    }
    
    public Seating seating() {
        return this.seating;
    }

    public Seating updateSeating(Pair<Integer,Integer> rowOfSeats) {
        return this.seating.book(rowOfSeats);
    }
    
    public String updateLog(String moreWords) {
        return log + moreWords;
    }

    public String toString() {
        return String.format("%s%s", log, this.seating.toString());
    }
}
