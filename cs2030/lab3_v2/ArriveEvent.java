import java.util.Optional;

class ArriveEvent extends Event {
    

    ArriveEvent(Customer customer, double eventTime) {
        super(eventTime, customer);
    }

    public String toString() {
        return super.eventTime() + " " + this.customer.toString() + " arrives";
    }
    
    public Pair<Event,Shop> next(Shop shop) {
        
        Pair<Event, Shop> maybePair = shop.findServer(this.customer)
            .map(x -> new Pair<Event,Shop>(new ServeEvent(this.customer, x.id(), super.eventTime()),
                        shop.update(x.serve(this.customer))))
            .orElse(new Pair<Event,Shop>(new LeaveEvent(super.eventTime(), super.customer()),shop));

        return maybePair;
        
        

    }
    
}
