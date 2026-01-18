class State {
    private final String history;
    private final Shop shop;
    private final PQ<Event> pq;
    /*
    State(Shop shop) {
        this.shop = shop;
        history = "";
    }
    */
    private State(PQ<Event> pq, Shop shop, String history) {
        this.pq = pq;
        this.shop = shop;
        this.history = history;
    }
    
    State(PQ<Event> pq, Shop shop) {
        this.pq = pq;
        this.shop = shop;
        history = "";        
    }
    /*
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
    */
    
    //lab3
    public State next() {
        //FYI:
        //PQ's poll() return type is Pair<Maybe<Event>, PQ of remaining Events>
        //Event's next() return type is Pair<Event,Shop>
        
        //remove the head of the pq
        Maybe<Event> maybeHead = pq.poll().t();
        return maybeHead.map(x -> {
                                //if said event is the same as the polled event, don't add it into the pq (LeaveEvent, DoneEvent do not generate further events)
                                if (x.equals(x.next(shop).t())) {
                                    return new State(pq.poll().u(), shop, history + "\n" + x.toString()); 
                                }
                                //add the next event of the polled event into the PQ of remaining Events
                                //add maybeHead's description to the history log
                                return new State(pq.poll().u().add(x.next(shop).t()), x.next(shop).u(), history + "\n" + x.toString());

                                }
                                //in the case where there is no head
                                //unfortunately, the last event's toString() is NOT called because of sample run's checking isEmpty() before the fact. 
                                //technically, this means that while the code in orElse() is needed to unwrap the Maybe wrapper, it itself is never executed. 
                            ).orElse(new State(new PQ<Event>(), shop, ""));

    }
    
    public boolean isEmpty() {
        return pq.isEmpty() && history.isEmpty();
    }

    public String toString() {
        return history;
    }

}
