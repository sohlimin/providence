class DoneEvent extends Event {

    DoneEvent(double eventTime, Customer customer) {
        super(eventTime, customer);
    }

    public Pair<Event, Shop> next(Shop shop) {
        return new Pair<Event, Shop>(this, shop);
    }

    public String toString() {
        return super.eventTime + " " + super.customer + " done";
    }

}
