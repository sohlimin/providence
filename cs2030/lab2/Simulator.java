import java.util.List;
import java.util.Iterator;
import java.util.stream.Stream;

class Simulator {
	private final int numOfServers;
	private final int numOfCustomers;
	private final List<Pair<Integer,Double>> arrivals;
	private final double serviceTime;

	Simulator(int numOfServers, int numOfCustomers, List<Pair<Integer,Double>> arrivals, double serviceTime) {
		this.numOfServers = numOfServers;
		this.numOfCustomers = numOfCustomers;
		this.arrivals = arrivals;
		this.serviceTime = serviceTime;
	}

	String run() {
		State init = new State(new Shop(numOfServers));
		List<Customer> customers = arrivals.stream()
						.map(x -> new Customer(x.t(), x.u())).toList();
		
		Iterator<Customer> iter = customers.iterator();
		
		return Stream.<State>iterate(init, state -> state.next(iter.next()))
			.limit(numOfCustomers + 1) // including start state
			.map(state -> state.toString())
			.filter(state -> !state.isEmpty()) // ignore state with no simulation output, e.g. init state
			.reduce("", (x, y) -> x + y + "\n");
	}
}

