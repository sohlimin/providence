/*
 * CS2030 Programming Methodology Sem 2 2024/2025
 * Week of 27 - 31 Jan 2025
 * Declarative Programming with Java Streams
 * 
 * Returns the first n Fibonacci numbers as a Stream<Integer>
 * Soh Li Min
 */

import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;

void main() {}

record IntPair(int fst, int snd) {}

Stream<Integer> Fibonacci(int n) {
	return Stream.iterate(new IntPair(0,1), x -> new IntPair(x.snd(), x.fst()+x.snd())).map(x -> x.fst()).limit(n+1);
}
