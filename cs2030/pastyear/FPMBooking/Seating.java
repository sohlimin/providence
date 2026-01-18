import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Seating {
    private final List<Seat> seatingPlan;
    
    Seating(int capacity) {
        this.seatingPlan = IntStream.range(0, capacity).<Seat>mapToObj(x -> new Available()).toList();
    }

    Seating(List<Seat> seatingPlan) {
        this.seatingPlan = seatingPlan;
    }

    public boolean isAvailable(Pair<Integer,Integer> rowOfSeats) {
        //checks if ALL seats in rowOfSeats are available
        return isValid(rowOfSeats) && seatingPlan
            .subList(firstSeatIndex(rowOfSeats), lastSeatIndex(rowOfSeats))
            .stream()
            .noneMatch(x -> x.isBooked());
    }
    
    public Seating book(Pair<Integer,Integer> rowOfSeats) {
        if (isAvailable(rowOfSeats)) {
            return new Seating(
                    IntStream
                    .range(0, this.seatingPlan.size())
                    .mapToObj(x -> x >= firstSeatIndex(rowOfSeats) && x <= lastSeatIndex(rowOfSeats) ?
                            new Booked() : this.seatingPlan.get(x))
                    .toList()
                    );
        } else {
            return this;
        }
    }
    
    private boolean isValid(Pair<Integer,Integer> rowOfSeats) {
        int maxIndex = seatingPlan.size() - 1;
        return !(lastSeatIndex(rowOfSeats) > maxIndex || firstSeatIndex(rowOfSeats) < 0);
    }

    private int lastSeatIndex(Pair<Integer,Integer> rowOfSeats) {
        return rowOfSeats.t() + rowOfSeats.u() - 1;
    }

    private int firstSeatIndex(Pair<Integer,Integer> rowOfSeats) {
        return rowOfSeats.t();
    }

    public String toString() {
        return seatingPlan
            .stream()
            .reduce("", (x,y) -> x + y.toString(), (a, b) -> a + b);
    }
}
