class DoneEvent extends Event {

	DoneEvent(double eventTime, Customer c) {
		super(eventTime, c);
	}

        public Pair<Event, Shop> next(Shop shop) {
                return new Pair<>(null, shop);
        }
	public String toString() {
		return super.eventTime + " " + super.c + " done";
	}

}
