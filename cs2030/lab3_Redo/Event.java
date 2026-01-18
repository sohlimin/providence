abstract class Event implements Comparable<Event> {

    private final Customer customer;
    private final double eventTime;

    Event(Customer customer, double time) {
        this.customer = customer;
        eventTime = time;
    }
    
    public int compareTo(Event otherEvent) {
        int num = Double.compare(this.eventTime, otherEvent.eventTime); 
        if (num == 0) {
            return customer.compareTo(otherEvent.customer());
        } else {
            return num;
        }
    }
    
    public Customer customer() {
        return customer;
    }
    
    public double eventTime() {
        return eventTime;
    }
    
    public double doneTime() {
        return eventTime + customer.serviceTime();
    }
    
    abstract public Pair<Event,Shop> next(Shop shop);
    
    @Override 
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        } 

        if (object instanceof Event event) {
            return this.toString().equals(event.toString());
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%.1f %s", eventTime, customer.toString());
    }
}
