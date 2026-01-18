/*
 * Takes in a string, returns the reverse of string 
 * Soh Li Min
 */

import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;
void main() {}

String reverse(String str) {
	return IntStream.iterate(str.length(), x -> x > 0, x -> x - 1)
		.mapToObj(x -> str.substring(x - 1, x))
		.reduce("", (x,y) -> x + y);
}
