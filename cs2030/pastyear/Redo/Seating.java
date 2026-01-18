import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.List;

class Seating {
    private final List<Seat> seats;
    Seating(int capacity) {
        seats = IntStream.range(0,capacity).<Seat>mapToObj(x -> new Available()).toList();
    }
    private Seating(List<Seat> seats) {
        this.seats = seats;
    }

    boolean isAvailable(Pair<Integer,Integer> rowOfSeats) {
        return isValid(rowOfSeats) ?
        seats.subList(firstIndex(rowOfSeats),lastIndex(rowOfSeats)).stream().noneMatch(x -> x.isBooked()) : false;
    }

    boolean isValid(Pair<Integer,Integer> rowOfSeats) {
        return firstIndex(rowOfSeats) >= 0 && lastIndex(rowOfSeats) <= seats.size() - 1;
    }

    private int firstIndex(Pair<Integer,Integer> rowOfSeats) {
        return rowOfSeats.t();
    }

    private int lastIndex(Pair<Integer,Integer> rowOfSeats) {
        return rowOfSeats.t() + rowOfSeats.u() -1;
    }

    Seating book(Pair<Integer,Integer> rowOfSeats) {
        if(isAvailable(rowOfSeats)) {
            return new Seating(IntStream.range(0, seats.size()).<Seat>mapToObj(x -> x >= firstIndex(rowOfSeats) && x <= lastIndex(rowOfSeats)? new Booked() : seats.get(x)).toList());
        } else {
            return new Seating(seats);
        }
    }

    public String toString() {
        return seats.stream().map(x -> x.toString()).reduce("",(x,y) -> x + y);
    }


}
