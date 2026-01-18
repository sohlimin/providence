class LeaveEvent extends Event {
    LeaveEvent(Customer customer, double time) {
        super(customer, time);
    }
    
    public Pair<Event,Shop> next(Shop shop) {
        return new Pair<Event,Shop>(this, shop); 
    }

    public String toString() {
        return String.format("%s leaves", super.toString());
    }
}
