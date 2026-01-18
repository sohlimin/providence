import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;

class Seating {
    private final List<Seat> name;
    
    Seating(int capacity) {
        name = IntStream.range(0, capacity)
            .<Seat>mapToObj(x -> new Available())
            .toList();
    }

    Seating(List<Seat> listOfSeat) {
        this.name = listOfSeat;
    }
    
    public boolean isAvailable(Pair<Integer,Integer> rowOfSeats) {
        return isValid(rowOfSeats) ? name
            .subList(first(rowOfSeats),last(rowOfSeats))
            .stream()
            .noneMatch(x -> x.isBooked()) : false;
    }

    private int first(Pair<Integer,Integer> rowOfSeats) {
        return rowOfSeats.t();
    }

    private int last(Pair<Integer,Integer> rowOfSeats) {
        return rowOfSeats.t() + rowOfSeats.u() - 1;
    }

    public Seating book(Pair<Integer,Integer> rowOfSeats) {
        if (isAvailable(rowOfSeats)) {
            return new Seating(IntStream
                .range(0,name.size())
                .<Seat>mapToObj(x -> x >= first(rowOfSeats) && x <= last(rowOfSeats)?
                        new Booked() : name.get(x))
                .toList());
        }
        return this;
    }

    private boolean isValid(Pair<Integer,Integer> rowOfSeats) {
        return first(rowOfSeats) >= 0 && last(rowOfSeats) <= name.size() - 1;
    }
    
    public String toString() {
        return name.stream().map(x -> x.toString()).reduce("", (x,y) -> x + y);
    }

}
