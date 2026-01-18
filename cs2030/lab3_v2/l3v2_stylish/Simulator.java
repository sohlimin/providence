class Simulator {
    private final int numServer;
    private final int numCustomer;
    private final InfList<Pair<Integer,Pair<Double,Double>>> arrivals;
    
    Simulator(int numServer, int numCustomer, InfList<Pair<Integer,Pair<Double,Double>>> arrivals) {
        this.numServer = numServer;
        this.numCustomer = numCustomer;
        this.arrivals = arrivals;
    }
    
    public Maybe<String> run() {
        PQ<Event> pq =  arrivals
            .map(x -> new ArriveEvent(new Customer(x.t(), x.u().t(), x.u().u()), x.u().t()))
                    .reduce(new PQ<Event>(), (x,y) -> x.add(y));
                            
                            

        return InfList.iterate(new State(pq, new Shop(this.numServer)), state -> state.next())
            
            .takeWhile(state -> !state.isEmpty())
            
            .map(state -> state.toString())
            
            .reduce((x,y) -> y);
    }    
}
