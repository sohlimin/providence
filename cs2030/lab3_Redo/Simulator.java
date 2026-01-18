class Simulator {
    private final int numOfServers;
    private final int numOfCustomers;
    private final InfList<Pair<Integer,Pair<Double,Double>>> arrivals;

    Simulator(int numOfServers, int numOfCustomers, InfList<Pair<Integer,Pair<Double,Double>>> arrivals) {
        this.numOfServers = numOfServers;
        this.numOfCustomers = numOfCustomers;
        this.arrivals = arrivals; // Customer(identifier, arrivalTime,
                                  // serviceTime)
    }

    private PQ<Event> convert() {
            return arrivals
                .map(x -> new ArriveEvent(new Customer(x.t(),x.u().t(), x.u().u()), x.u().t()))
                .reduce(new PQ<Event>(), (x,y) -> x.add(y)); 
    }
    
    //add new ArriveEvents into PQ<Event> pq 
    public Maybe<String> run() {
        return InfList.iterate(new State(convert(), new Shop(numOfServers)), state -> state.next())
            .takeWhile(state -> !state.isEmpty())
            .map(state -> state.toString())
            .reduce((x,y) -> y);
    }
}
