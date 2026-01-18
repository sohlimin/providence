abstract class Event implements Comparable<Event> {
    protected final double eventTime;
    protected final Customer customer;

    Event(double eventTime, Customer customer) {
        this.eventTime = eventTime;
        this.customer = customer;
    }
    
    protected double eventTime() {
        return this.eventTime;
    }
    
    protected Customer customer() {
        return this.customer;
    }

    @Override
    public int compareTo(Event other) {
        if (Double.compare(this.eventTime,other.eventTime) == 0) {
            return customer.compareTo(other.customer);
        }
        return Double.compare(this.eventTime, other.eventTime);

    }
    
    public abstract Pair<Event,Shop> next(Shop shop);
    
}
