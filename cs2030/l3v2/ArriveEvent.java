import java.util.Optional;

class ArriveEvent extends Event {
	

	ArriveEvent(Customer c, double eventTime) {
		super(eventTime, c);
	}

	public String toString() {
		return super.eventTime() + " " + this.c.toString() + " arrives";
	}
	
	public Pair<Event,Shop> next(Shop shop) {
		
		Pair<Event, Shop> maybePair = shop.findServer(this.c)
			.map(x -> new Pair<Event,Shop>(new ServeEvent(this.c, x.id(), super.eventTime()),shop.update(x.serve(this.c))))
			.orElse(new Pair<Event,Shop>(new LeaveEvent(super.eventTime(), super.c()),shop));

		return maybePair;
		
		

	}
	
}
