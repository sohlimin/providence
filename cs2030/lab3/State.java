import java.util.Optional;

class State {
	
	private final Shop shop;
	private final PQ<Event> pq;
	private final String latestState;

	/*
	State(Shop shop) {
		this.shop = shop;
		this.latestState = "";
		this.pq = null;
	}
	*/

	State(PQ<Event> pq, Shop shop, String latestState) {
		this.shop = shop;
		this.pq = pq;
		this.latestState = latestState;
	}
	

	State(PQ<Event> pq, Shop shop) {
		this.shop = shop;
		this.pq = pq;
		this.latestState = "";
	}

	/*
	public State next(Customer customer) {
		return shop.findServer(customer)
			.map(x -> new State(shop.update(x.serve(customer)), customer + " arrives\n" + customer + " served by " + x))
			.orElse(new State(shop, customer + " arrives\n" + customer + " leaves"));
	}
	*/

	//we have PQ<Event>, shop 
	//next(Shop) in any event returns the next event and updated shop 
	//This method effectively polls the head of pq (and removes it from pq),
	//generates the event caused by the removed head and adds it to pq.
	//PQ class has poll() that returns Pair<optional of the removed head of the pq, the updated pq>.
	public State next() {
		
		Optional<Event> optEv = pq.poll().t();
		/*
		Event newEv = optEv.next(this.shop).t();
		PQ newpq = pq.poll().u().add(newEv);
		Shop newShop = optEv.next(this.shop).u();
		return new State(newpq, newShop, optEv.toString());
		*
		*Optional pipeline; mapping, unwrap only at the end.
		*/
		State nextState = optEv.map(x -> new State(this.pq.poll().u().add(optEv.next(this.shop).t()), optEv.next(this.shop).u(), optEv.toString())
				.orElse(this) //when pq has nothing or is a LeaveEvent/DoneEvent
		return nextState; 

	}
	public String toString() {
		return latestState;
	}
	
}
