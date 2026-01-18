import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;
import java.util.Optional;

class Shop {
	
	private final List<Server> staff;

	Shop(int noOfServers) {
		
		this.staff = IntStream.rangeClosed(1,noOfServers).mapToObj(x -> new Server(x)).toList();
	}
	

	Shop(List<Server> staff) {
		this.staff = staff;
		
	}

	public String toString() {
		return this.staff.toString();
	}
	
	public Optional<Server> findServer(Customer customer) {
		return this.staff.stream().filter(x -> x.canServe(customer)).findFirst();
	}
		
	public Shop update(Server server) {
		return new Shop(staff.stream().map(x -> (x.sameServer(server)) ? server : x).toList()); 
	}
	
}
