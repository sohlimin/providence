class Init extends Transaction {
    
    Init(Seating seating) {
        super(seating);
    }
    
    public String toString() {
         return String.format("INIT:\n%s", "Initializing\n" + super.toString());
    } 
}
