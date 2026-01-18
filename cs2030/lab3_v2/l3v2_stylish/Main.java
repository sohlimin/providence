import java.util.List;
import java.util.Scanner;

static final double SERVICE_TIME = 1.0;

void main() {
    Scanner sc = new Scanner(System.in);
    int numOfServers = sc.nextInt();
    int numOfCustomers = sc.nextInt();

    sc.nextLine(); // removes trailing newline
    InfList<Pair<Integer,Pair<Double,Double>>> arrivals = InfList.iterate(1, x -> x + 1)
        .limit(numOfCustomers)
        .map(x -> new Pair<>(sc.nextInt(), new Pair<>(sc.nextDouble(), sc.nextDouble())));

    new Simulator(numOfServers, numOfCustomers, arrivals)
        .run().ifPresent(x -> System.out.println(x));
}
