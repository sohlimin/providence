class Server {
	private final int id;
	private final double avlTime;

	Server(int id) {
		this.id = id;
		this.avlTime = 0.0;
	}

	Server(int id, double avlTime) {
		this.id = id;
		this.avlTime = avlTime;
	}
	
	public double avlTime() { //new
		return this.avlTime;
	}
	public int id() { //new
		return this.id;
	}
	/*
	 public Server serve(Customer c, double svcTime) {
		return new Server(this.id, c.serveTill(svcTime));
	}
	*/
	
	public Server serve(Customer c) { //new
		return new Server(this.id, c.serveTill());
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
