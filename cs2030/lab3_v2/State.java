class State {
    private final Shop shop;
    private final String history;
    private final PQ<Event> pq; 
    
    State(PQ<Event> pq, Shop shop) {
        this.pq = pq;
        this.shop = shop;
        this.history = "";
    }
    
    State(PQ<Event> pq, Shop shop, String history) {
        this.pq = pq;
        this.shop = shop;
        this.history = history;
    }
    
    
    //next() is like poll but it returns a State
    //PQ's poll() returns Pair<Maybe of the head of this queue, and 
    //the resulting priority queue after removal> Pair<T, U>
    public State next() {        
        //concat the event's toString() with history
        
        //any event's next() takes in shop, returns Pair<Event,Shop>
        //for the first param, we cant just use the resultant pq after the removal of the head, 
        //we need to do one more thing: the head is the cause, the new event we add (from 
        //the pair returned from calling the head event's next() with input of current shop) 
        //is the effect to be added to the pq. 
        //for the second param, we use the updated shop(effect).
        Pair<Maybe<Event>,PQ<Event>> mbEvPQPair = this.pq.poll();
        
        Maybe<Event> maybeHead = mbEvPQPair.t();
        
        State nuState = maybeHead.map(x -> {
                Pair<Event,Shop> evShopPair = x.next(this.shop); 
                Shop nuShop = evShopPair.u();
                Event effect = evShopPair.t();
                PQ<Event> nuPQ = mbEvPQPair.u();
                if (effect != x) {
                    nuPQ = intermedPQ.add(effect);
            }
                            
                return new State(nuPQ, nuShop, this.history + "\n" + x.toString());

            }
         ).orElse(new State(this.pq, this.shop));
        
        return nuState;
    }

    public boolean isEmpty() {
        return this.pq.isEmpty() && history.isEmpty();
    }

    public String toString() {
        return this.history; 
    }

}
