class State {
	private final Shop shop;
	private final String history;
	//simulator has a run() that returns a State
	//init is a State
	//each id-arrTime pair in inflist is mapped into a new customer, and reduced to a final state after repeatedly putting customers into the next() of the new state it returned, beginning with init.
	//next() also accumulates the intermediate state descriptions, so when the final state is printed, it contains all history too 
	
	State(Shop shop) {
		this.shop = shop;
		this.history = "";
	}

	State(Shop shop, String h) {
		this.shop = shop;
		this.history = h;
	}
	
	public State next(Customer c) {
		/*
		Maybe<Server> maybeServer = this.shop.findServer(c); 
		
		String latestDescription  = maybeServer.map(x -> "\n" + c + " arrives\n" +  c + " served by " + x)
						.orElse("\n" + c + " arrives\n" + c + " leaves");
		
		Shop latestShop = maybeServer.map(x -> this.shop.update(x.serve(c, 1.0)))
						.orElse(this.shop);

		return new State(latestShop, history  + latestDescription);
		*/

		return this.shop.findServer(c).map(x -> new State(this.shop.update(x.serve(c, 1.0)), history + "\n" + c + " arrives\n" + c + " served by " + x))
						.orElse( new State(this.shop, history + "\n" + c + " arrives\n" + c + " leaves"));	
	}

	public String toString() {
		return this.history; 
	}


}
