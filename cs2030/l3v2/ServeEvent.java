class ServeEvent extends Event{
	private final int serverID;

	ServeEvent(Customer c, int id, double eventTime) {
		super(eventTime, c);
		this.serverID = id;

	}
	public String toString() {
		return super.eventTime() + " " + c.toString() + " serve by server " + serverID; 
	}

	public Pair<Event, Shop> next(Shop shop) {
		//AvlTime property of Server -> store in Event's eventTime
		//this Server is the same one from the previous ArriveEvent that returns this class with its serverID in parameter.
		//new shop has the server available
		return new Pair<Event,Shop>(new DoneEvent(shop.ppl().filter(x -> x.id() == this.serverID).findFirst().map(x -> x.avlTime()).orElse(1.0), super.c()), shop);
		//double newEvTime = shop.staff().stream().filter(x -> x.id() == this.serverID).map(x -> x.timeAvailableAgain()).findFirst().get()
	}
}
