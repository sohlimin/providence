import java.util.Optional;

class Server {
	
	private final int id;
	private final double timeAvailableAgain;

	Server(int id, double timeAvailableAgain) {
		this.id = id;
		this.timeAvailableAgain = timeAvailableAgain;
	}
	
	Server(int id) {
		this.id = id;
		this.timeAvailableAgain = 0.0;
	}

	@Override
	public String toString() {
		return "server " + this.id;
	}
	
	public Server serve(Customer customer, double serviceTime) {
		return new Server(this.id, customer.serveTill(serviceTime));
	}

	public boolean canServe(Customer nextCustomer) {
		return nextCustomer.canBeServed(this.timeAvailableAgain);
	}

	public boolean sameServer(Server server) {
		return this.id == server.id;
	}
}
