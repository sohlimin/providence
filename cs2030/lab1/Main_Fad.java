import java.util.List;
import java.util.stream.Stream;
import java.util.stream.IntStream;

void main() {}
    
IntStream twinPrimes(int n) {
    return IntStream.rangeClosed(2, n)
        .filter(x -> isPrime(x) && (isPrime(x + 2) || isPrime(x - 2)));
}

boolean isPrime(int n) {
    return n > 1 && IntStream.rangeClosed(2, n / 2).noneMatch(i -> n % i == 0);
}

String reverse(String str) {
    return Stream.<String>of(str.split(""))
        .reduce((a,b) -> b + a).orElse("");
}

int countRepeats(List<Integer> list) {
    return IntStream.range(0, list.size() - 1)
        .filter(x -> list.get(x) == list.get(x + 1))
        .filter(x -> x == 0 || list.get(x) != list.get(x - 1))
        .map(x -> 1)
        .sum();
}
