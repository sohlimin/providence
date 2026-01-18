class Shop {
    private final InfList<Server> listOfServers;
    
    Shop(int noOfServers) {
        listOfServers = InfList
            .iterate(1, x -> x + 1)
            .limit(noOfServers)
            .<Server>map(x -> new Server(x));
    }

    Shop(InfList<Server> listOfServers) {
        this.listOfServers = listOfServers;
    }

    public Maybe<Server> findServer(Customer customer) {
        return listOfServers.filter(x -> x.canServe(customer)).findFirst();
    }
    
    public Shop update(Server server) {
        return new Shop(listOfServers.map(x -> x.sameServer(server)? server : x));
    }

    public String toString() {
        return String.format("Shop:%s", listOfServers.map(x -> "<" + x.toString()+ ">").reduce("", (x,y) -> x + y));
        
    }
    

}
