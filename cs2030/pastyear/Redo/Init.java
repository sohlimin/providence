class Init extends Transaction{
    Init(Seating seating) {
        super(seating, "\nInitializing\n");
    }


    public String toString() {
        return String.format("INIT:%s", super.toString());
    }
}
