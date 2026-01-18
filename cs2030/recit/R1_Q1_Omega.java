/*
 * CS2030 Programming Methodology Sem 2 2024/2025
 * Week of 27 - 31 January 2025
 * Declarative Programming with Java Streams
 * 
 * Omega number of i = No of DISTINCT prime factors of i.
 * 
 * Takes in a positive int n, returns an IntStream of the omega numbers of 0 to n. 
 *
 * Soh Li Min
 */

import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;

void main() {}

boolean isPrime(int n) {
	return n > 1 && 
		IntStream.range(2,n).noneMatch(x -> n % x == 0);
}

int distinctPfs(int n) {
	return IntStream.rangeClosed(2,n)
		.filter(x -> isPrime(x))
		.filter(x -> n % x == 0)
		.map(x -> 1)
		.reduce(0, (x,y) -> x + y);	
}

IntStream omega(int n) {
	return IntStream.rangeClosed(1,n)
		.map(x -> distinctPfs(x));
}
