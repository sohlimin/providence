import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;
void main() {}

int countRepeats(List<Integer> list) {
	return IntStream.range(1, list.size())
		.filter(x-> list.get(x) == list.get(x - 1))
		.filter(x -> x == list.size() - 1 || list.get(x) != list.get(x + 1))
		.map(x -> 1)
		.reduce(0, (x,y) -> x + y);
}


