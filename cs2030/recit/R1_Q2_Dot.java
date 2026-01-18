/*
 * CS2030 Programming Methodology Sem 2 2024/2025
 * Week of 27 - 31 Jan 2025
 * Declarative Programming with Java Streams
 * 
 * Soh Li Min
 */

import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;

void main() {}

IntStream dot(int a, int b) {
	return IntStream.rangeClosed(a,b).flatMap(x -> IntStream.rangeClosed(a,b).map(y -> x * y));
}

record IntPair(int fst, int snd) {}

IntStream product(int a, int b) {
	return IntStream.rangeClosed(a,b).boxed().flatMap(x -> IntStream.rangeClosed(a,b).mapToObj(y -> new IntPair(x, y)));
}

