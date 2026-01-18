class Init extends Transaction {
    Init(Seating seating) {
        super(seating, "Initializing");
    }

    public String toString() {
        return String.format("INIT:\n%s", super.toString());
    }
}
