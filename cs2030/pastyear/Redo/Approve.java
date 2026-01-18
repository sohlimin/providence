class Approve extends Transaction {
    Approve(Seating seating, String log) {
        super(seating, log);
    }

    public String toString() {
        return String.format("APPROVED:%s", super.toString());
    }
}
