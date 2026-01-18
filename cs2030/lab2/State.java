class State {
	
	private final Shop shop;
		
	private final String latestState;

	State(Shop shop) {
		this.shop = shop;
		this.latestState = "";
	}

	State(Shop shop, String latestState) {
		this.shop = shop;
		this.latestState = latestState;
	}

	public State next(Customer customer) {
		return shop.findServer(customer).map(x -> new State(shop.update(x.serve(customer, 1.0)), customer + " arrives\n" + customer + " served by " + x))
				.orElse(new State(shop, customer + " arrives\n" + customer + " leaves"));
	}	

	public String toString() {
		return latestState;
	}
}
