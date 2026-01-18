class Customer {
	private final int id;
	private final double arrTime;
	
	Customer(int id, double time){
		this.id = id;
		this.arrTime = time;
	}

	public String toString() {
		return "customer " + this.id;
	}

	public boolean canBeServed(double serverAvlTime) {
		return this.arrTime >= serverAvlTime;
	}
	
	public double serveTill(double svcTime) {
		return this.arrTime + svcTime;
	}
}
