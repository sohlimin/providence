class LeaveEvent extends Event {

	LeaveEvent(double eventTime, Customer c) {
		super(eventTime, c);
		
	}

	public String toString() {
		return super.eventTime() + " " + c.toString() + " leaves";
	}
	public Pair<Event, Shop> next(Shop shop) {
    		return new Pair<>(null, shop);
	}
}
