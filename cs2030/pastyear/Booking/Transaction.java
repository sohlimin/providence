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

    public Seating getSeating() {
        return this.seating;
    }

    public Seating updateSeating(Pair<Integer,Integer> rowOfSeats) {
        return this.seating.book(rowOfSeats);
    }
    
    public String updateLog(String words) {
        return this.log + words;
    }

    public String toString() {
        return log + "\n" + seating.toString();
    }
}
