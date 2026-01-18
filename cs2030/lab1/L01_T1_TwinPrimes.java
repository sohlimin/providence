/*
 * The method takes in an integer n
 * returns an IntStream comprising of distinct twin primes from 2 to n
 * 
 * Soh Li Min
 */

import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;

void main() {}

boolean isPrime(int n) {
	return n > 1 && IntStream.range(2,n).noneMatch(x -> n % x == 0);
}

IntStream twinPrimes(int n) {
	return IntStream.range(2,n+2)
		.filter(x -> (isPrime(x) && isPrime(x+2)) || (isPrime(x) && isPrime(x-2)))
		.filter(x -> x <= n);
}
