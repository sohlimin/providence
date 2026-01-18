class Reject extends Transaction {
    private final int billing;

    Reject(int billing) {
        super(seating);
        this.billing = billing;
    }

    Transaction transact(Transaction transaction) {
        return this;    
    }

    public String toString() {
        return String.format("REJECTED:\n%s\nnot billed %d", super.toString(), this.billing); 
    }
}
