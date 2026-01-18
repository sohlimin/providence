class ArriveEvent extends Event{
    
    ArriveEvent(Customer customer, double time) {
        super(customer, time);
    }

    public Pair<Event, Shop> next(Shop shop) {
        return shop
            .findServer(super.customer()) //Maybe<Server>
            .map(x -> new Pair<Event, Shop>(new ServeEvent(super.customer(), super.eventTime(), x), shop))
            .orElse(new Pair<Event, Shop>(new LeaveEvent(super.customer(), super.eventTime()), shop));
    }

    public String toString() {
        return String.format("%s arrives", super.toString()); 

    }
}
