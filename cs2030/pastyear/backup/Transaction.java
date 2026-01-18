abstract class Transaction {
    private final Seating seating;
    private final String log;

    Transaction(Seating seating) {
        this.seating = seating;
    }
    
    protected <Seating> Seating updateSeating(Function<Seating,Seating> f) {
        return f.apply(this.seating);
    }

    protected String updateLog(String s) {
        return this.log + s;
    }

    abstract Transaction transact(Transaction t);

    public String toString() {
        return this.seating.toString();
    }

}
