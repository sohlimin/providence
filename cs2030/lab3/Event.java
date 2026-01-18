abstract class Event implements Comparable<Event>{
	protected final double eventTime;
	protected final Customer customer;

	Event(double eventTime, Customer cus) {
		this.eventTime = eventTime;
		this.customer = cus;
	}
	
	protected double eventTime() {
		return this.eventTime;
	}
	
	protected Customer customer() {
		return this.customer;
	}

	@Override
	public int compareTo(Event other) {
		return Double.compare(this.eventTime, other.eventTime);
	}

	public abstract Pair<Event,Shop> next(Shop shop);
}
