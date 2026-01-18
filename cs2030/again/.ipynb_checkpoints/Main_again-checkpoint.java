import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;
void main() {}

IntStream twinPrimes(int n) {
	return IntStream.rangeClosed(2,n).filter(x -> isPrime(x) && isPrime(x+2) || isPrime(x) && isPrime(x-2);
}
boolean isPrime(int n) {
	return n > 1 && IntStream.range(2,n).noneMatch(x -> n % x == 0);
}

String reverse(String str) {
	return Stream.iterate(str.length()-1, x -> x >= 0, x -> x - 1).map(x -> str.substring(x, x + 1).reduce((x,y) -> x + y).orElse("");

}

int countRepeats(List<Integer> list) {
        return IntStream.range(1, list.size())
                .filter(x-> list.get(x) == list.get(x - 1))
                .filter(x -> x == list.size() - 1 || list.get(x) != list.get(x + 1))
                .map(x -> 1)
                .reduce(0, (x,y) -> x + y);
}

