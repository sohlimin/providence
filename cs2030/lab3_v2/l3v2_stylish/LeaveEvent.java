class LeaveEvent extends Event {

    LeaveEvent(double eventTime, Customer customer) {
        super(eventTime, customer);
        
    }

    public String toString() {
        return super.eventTime() + " " + customer.toString() + " leaves";
    }

    public Pair<Event, Shop> next(Shop shop) {
        return new Pair<>(this, shop);
    }
}
