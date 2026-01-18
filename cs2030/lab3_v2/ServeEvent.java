class ServeEvent extends Event {
    private final int serverID;

    ServeEvent(Customer customer, int id, double eventTime) {
        super(eventTime, customer);
        this.serverID = id;

    }

    public String toString() {
        return super.eventTime() + " " + customer.toString() + " serve by server " + serverID; 
    }

    public Pair<Event, Shop> next(Shop shop) {
        return new Pair<Event, Shop>(new DoneEvent(super.customer.serveTill(), super.customer), 
                shop);
    }
}
