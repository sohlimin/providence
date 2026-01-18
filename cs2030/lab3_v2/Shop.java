class Shop {
    
    private final InfList<Server> ppl;

    Shop(int noOfServers) {
        this.ppl = InfList.iterate(1, x -> x + 1).limit(noOfServers).map(x -> new Server(x));
    }

    Shop(InfList<Server> p) {
        this.ppl = p;
    }
    
    public String toString() {
        return "Shop:" + this.ppl.map(x -> "<" + x + ">").reduce("", (x, y) -> x + y);
    }
    
    public InfList<Server> ppl() {
        return this.ppl;
    }    

    public Maybe<Server> findServer(Customer c) {
        return this.ppl.filter(x -> x.canServe(c)).findFirst();
    }

    public Shop update(Server server) {
        InfList<Server> latestppl = this.ppl.map(x -> x.sameServer(server) ? server : x);
        return new Shop(latestppl);
    }
}
