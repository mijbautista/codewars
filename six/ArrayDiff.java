package codewars.six;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

/*
 * DESCRIPTION:
 * Your goal in this kata is to implement a difference function, which subtracts one list from another and returns the result.
 * 
 * It should remove all values from list a, which are present in list b keeping their order.
 * 
 * Kata.arrayDiff(new int[] {1, 2}, new int[] {1}) => new int[] {2}
 * If a value is present in b, all of its occurrences must be removed from the other:
 * 
 * Kata.arrayDiff(new int[] {1, 2, 2, 2, 3}, new int[] {2}) => new int[] {1, 3}
 * 
 */

public class ArrayDiff {

	public static int[] arrayDiff(int[] a, int[] b) {
		List<Integer> aList = Arrays.stream(a).boxed().collect(Collectors.toList());
		List<Integer> bList = Arrays.stream(b).boxed().collect(Collectors.toList());
		return aList.stream().filter(x -> !bList.contains(x)).mapToInt(x -> x).toArray();
	}

	@Test
	public void sampleTests() {
		assertArrayEquals(new int[] { 2 }, arrayDiff(new int[] { 1, 2 }, new int[] { 1 }));
		assertArrayEquals(new int[] { 2, 2 }, arrayDiff(new int[] { 1, 2, 2 }, new int[] { 1 }));
		assertArrayEquals(new int[] { 1 }, arrayDiff(new int[] { 1, 2, 2 }, new int[] { 2 }));
		assertArrayEquals(new int[] { 1, 2, 2 }, arrayDiff(new int[] { 1, 2, 2 }, new int[] {}));
		assertArrayEquals(new int[] {}, arrayDiff(new int[] {}, new int[] { 1, 2 }));
	}
}
