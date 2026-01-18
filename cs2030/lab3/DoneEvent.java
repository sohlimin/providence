class DoneEvent extends Event {

	DoneEvent(double eventTime, Customer cus) {
		super(eventTime, cus);
	}

        @Override
        public Pair<Event, Shop> next(Shop shop) {
                return new Pair<>(, shop);
        }
	public String toString() {
		return super.customer + " done";
	}

}
