class Customer {
	private final int id;
	private final double arrivalTime;
	private final double svcTime;

	Customer(int id, double arrivalTime){
		this.id = id;
		this.arrivalTime = arrivalTime;
		this.svcTime = 0.0;
	}

	Customer(int id, double arrivalTime, double serviceTime){
		this.id = id;
		this.arrivalTime = arrivalTime;
		this.svcTime = serviceTime;	
	}
	@Override
	public String toString(){
		return this.arrivalTime + " customer " + this.id;
	}
	
	public boolean canBeServed(double time) {
		return this.arrivalTime >= time;
	}

	/* lab 2
	public double serveTill(double serviceTime){
		return this.arrivalTime + serviceTime;
	}
	*/

	public double serveTill(){
		return this.arrivalTime + svcTime;

	}
}
