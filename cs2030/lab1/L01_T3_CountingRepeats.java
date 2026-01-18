/*
 * Takes in a list of int digits (0-9) 
 * returns no of consecutively repeated digits
 * 
 * if aab, next can check for aab or abb. But if abb, next can only check for abb.
 * 
 * Soh Li Min
 */
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;
void main() {}


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
/*
int aab(List<Integer> list) {
	return IntStream.range(1,list.size()-1)
		.filter(x -> (list.get(x) == list.get(x-1) && list.get(x) != list.get(x+1)) || (list.get(x) == list.get(x+1) && list.get(x) != list.get(x-1)))
		.map(x->1)
		.sum();
}
*/

