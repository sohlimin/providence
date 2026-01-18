class Server {
    private final int identifier;
    private final double timeAvailable;

    Server(int identifier) {
        this.identifier = identifier;
        timeAvailable = 0.0; 
    }

    Server(int identifier, double timeAvailable) {
        this.identifier = identifier;
        this.timeAvailable = timeAvailable;
    }
    
    public Server serve(Customer customer, double serviceTime) {
        return new Server(identifier, customer.serveTill(serviceTime));
    }
    
    public boolean canServe(Customer customer) {
        return customer.canBeServed(timeAvailable);
    }
    
    public boolean sameServer(Server server) {
        return server.identifier == identifier;
    }

    public String toString() {
        return String.format("server %d", identifier);
    }

}
