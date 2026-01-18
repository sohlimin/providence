class ServeEvent extends Event {
    private final Server server;
    ServeEvent(Customer customer, double time, Server server) {
        super(customer, time);
        this.server = server;
    }
    
    public Pair<Event,Shop> next(Shop shop) {
        return new Pair<Event, Shop>(new DoneEvent(super.customer(), super.doneTime()), shop.update(server.serve(super.customer())));
    }

    public String toString() {
        return String.format("%s serve by %s", super.toString(), server); 
    }
}

