import java.util.Optional;

class ArriveEvent extends Event {
	

	ArriveEvent(Customer cus, double eventTime) {
		super(eventTime, cus);
		
	}

	public String toString() {
		return this.customer.toString() + " arrives";
	}
	
	public Pair<Event,Shop> next(Shop shop) {
		
		Optional<Server> optServer = shop.findServer(this.customer);
		
		/*
		 *imperative
		if(optServer.isPresent()) {
			Event newEvent = new serveEvent(this.customer, super.eventTime());
			Shop newShop = new Shop(shop.update(optServer.get());
			return new Pair<Event,Shop>(newEvent, newShop);
		} else {
			Event newEvent = new leaveEvent(this.customer, super.eventTime());
			return new Pair<Event,Shop>(newEvent, shop);
		} 
		*/

		//declarative
		Pair<Event, Shop> optPair = optServer
			.map(x -> new Pair<Event,Shop>(new ServeEvent(this.customer, x.id(), super.eventTime()),shop.update(x.serve(this.customer))))
			.orElse(new Pair<Event,Shop>(new LeaveEvent(super.eventTime(), super.customer()),shop));

		return optPair;
	}	
}
