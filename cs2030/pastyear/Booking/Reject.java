class Reject extends Transaction {
    Reject(Seating seating, String log) {
        super(seating, log);
    }

    public String toString() {
        return String.format("REJECTED:\n%s", super.toString());
    }
}
