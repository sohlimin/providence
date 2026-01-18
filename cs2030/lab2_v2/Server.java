class Server {
	private final int id;
	private final double avlTime;

	Server(int id) {
		this.id = id;
		avlTime = 0.0;
	}

	Server(int id, double avlTime) {
		this.id = id;
		this.avlTime = avlTime;
	}

	public Server serve(Customer c, double svcTime) {
		return new Server(this.id, c.serveTill(svcTime));
	}

	public boolean canServe(Customer c) {
		return c.canBeServed(this.avlTime);
	}

	public boolean sameServer(Server server) {
		return this.id == server.id;
	}

	public String toString() {
		return "server " + this.id;
	}	
}
