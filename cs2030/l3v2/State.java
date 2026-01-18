class State {
	private final Shop shop;
	private final String history;
	private final PQ<Event> pq; 
	
	//simulator has a run() that returns a State
	//init is a State
	//each id-arrTime pair in inflist is mapped into a new customer, and reduced to a final state after repeatedly putting customers into the next() of the new state it returned, beginning with init.
	//next() also accumulates the intermediate state descriptions, so when the final state is printed, it contains all history too 
	
	/*
	 *old - lab2_v2, no pq
	 *
	State(Shop shop) {
		this.shop = shop;
		this.history = "";
	}

	State(Shop shop, String h) {
		this.shop = shop;
		this.history = h;
		
	} 
	 */
	
	State(PQ<Event> pq, Shop shop) {
		this.pq = pq;
		this.shop = shop;
		this.history = "";
	}
		
	//next() is like poll but it returns a State
	//PQ's poll() returns Pair<Maybe of the head of this queue, and the resulting priority queue after removal> Pair<T, U>
	public State next() {		
		//concat the event's toString() with history
		
		//any event's next() takes in shop, returns Pair<Event,Shop>
		//for the first param, we cant just use the resultant pq after the removal of the head, we need to do one more thing: the head is the cause, the new event we add (from the pair returned from calling the head event's next() with input of current shop) is the effect to be added to the pq. 
		//for the second param, we use the updated shop(effect).
		Pair<Maybe<Event>,PQ<Event>> mbEvPQPair = this.pq.poll();
		
		Maybe<Event> maybeHead = mbEvPQPair.t();
		
		State nuState = maybeHead.map(x -> 
							{
								Pair<Event,Shop> EvShopPair = x.next(this.shop); 
								Shop nuShop = EvShopPair.u();
								Event effect = EvShopPair.t();
								PQ<Event> intermedPQ = mbEvPQPair.u();
								PQ<Event> nuPQ = intermedPQ.add(effect);
								return new State(nuPQ, nuShop);

							}
						).orElse(new State(this.pq, this.shop));
		
		return nuState;
	}
/*
	public boolean isEmpty() {
		return ;
	}
*/
	public String toString() {
		return this.history; 
	}


}
