class State {
    private final String history;
    private final Shop shop;

    State(Shop shop) {
        this.shop = shop;
        history = "";
    }

    private State(Shop shop, String history) {
        this.shop = shop;
        this.history = history;
    }
    
    public State next(Customer customer) {
        return shop
            .findServer(customer)
            .map(x -> new State(shop.update(x.serve(customer, 1.0)), 
                        String.format("%s\n%s arrives\n%s served by %s", history,
                            customer.toString(), customer.toString(), x.toString())))
            .orElse(new State(shop, 
                        String.format("%s\n%s arrives\n%s leaves", history, 
                            customer.toString(), customer.toString()))); 
    }

    public String toString() {
        return history;
    }

}
