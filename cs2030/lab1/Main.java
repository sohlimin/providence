import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;
void main() {}

/*
 * The method takes in an integer n
 * returns an IntStream comprising of distinct twin primes from 2 to n
 *
 * Lab 1 Task 1
 */

boolean isPrime(int n) {
        return n > 1 && IntStream.range(2,n).noneMatch(x -> n % x == 0);
}

IntStream twinPrimes(int n) {
        return IntStream.range(2,n+2)
                .filter(x -> (isPrime(x) && isPrime(x+2)) || (isPrime(x) && isPrime(x-2)))
                .filter(x -> x <= n);
}

/*
 * Takes in a string, returns the reverse of string
 * 
 * Lab 1 Task 2
 */

String reverse(String str) {
        return IntStream.iterate(str.length(), x -> x > 0, x -> x - 1)
                .mapToObj(x -> str.substring(x - 1, x))
                .reduce("", (x,y) -> x + y);

/*
 * Takes in a list of int digits (0-9)
 * returns no of consecutively repeated digits
 *
 * Lab 1 Task 3
 */
int countRepeats(List<Integer> list) {
        return IntStream.range(0,list.size()-1)
                .allMatch(x -> list.get(x).equals(list.get(x+1))) ? 1 : (list.get(0).equals(list.get(1)) ? abb(list)+1 : abb(list));
}

int abb(List<Integer> list) {
        return IntStream.range(1,list.size()-1)
                .filter(x -> list.get(x) == list.get(x+1) && list.get(x) != list.get(x-1))
                .map(x->1)
                .sum();
}
