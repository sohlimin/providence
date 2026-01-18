class LeaveEvent extends Event {

	LeaveEvent(double eventTime, Customer cus) {
		super(eventTime, cus);
		
	}

	public String toString() {
		return super.eventTime() + " " + customer.toString() + " leaves";
	}
	@Override
	public Pair<Event, Shop> next(Shop shop) {
    		return new Pair<>(null, shop);
	}
}
