class Request extends Transaction {
    private final Pair<Integer, Integer> rowOfSeats;
    private final int billing;
    private final Bank bank;

    Request(Seating plan, Pair<Integer,Integer> rowOfSeats, int billing, Bank bank) {
        super(plan);
        this.rowOfSeats = rowOfSeats;
        this.billing = billing;
        this.bank = bank;
    }
    
    public Transaction transact(Transaction t) {
    
        //if bank field is true, approve 
        if (bank.test(billing)) {
        
            //if seats booked overlap, return the same seating
            if (plan) {
            
            //if seats booked are different, update seating
       {
           
        }
    //if bank field is false or billing number is odd, reject and return
    //same seating

    }

    public String toString() {
        return "REQUEST:\nRequesting\n" + super.toString();
    }
}
