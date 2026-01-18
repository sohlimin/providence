abstract class Event implements Comparable<Event>{
    protected final double eventTime;
    protected final Customer c;

    Event(double eventTime, Customer c) {
        this.eventTime = eventTime;
        this.c = c;
    }

    protected double eventTime() {
        return this.eventTime;
    }

    protected Customer c() {
        return this.c;
    }

    @Override
    public int compareTo(Event other) {
        return Double.compare(this.eventTime, other.eventTime);
    }
    
    public abstract Pair<Event,Shop> next(Shop shop);
	
}
