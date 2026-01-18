class ServeEvent extends Event{
	private final int serverID;

	ServeEvent(Customer cus, int id, double eventTime) {
		super(eventTime, cus);
		this.serverID = id;

	}
	public String toString() {
		return customer.toString() + " serve by server " + serverID; 
	}

	@Override
	public Pair<Event, Shop> next(Shop shop) {
		//timeAvailableAgain property of Server -> store in Event's eventTime
		//this Server is the same one from the previous Arrive Event that called this class with the server's serverID in parameter.
		//return a shop that has the server available
		double newEvTime = shop.staff().stream().filter(x -> x.id() == this.serverID).map(x -> x.timeAvailableAgain()).findFirst().get();
		return new Pair<Event,Shop>(new DoneEvent(newEvTime, super.customer()), shop);
	}
}
