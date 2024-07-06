package codewars.six;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;

/*
 * DESCRIPTION:
 * Given an array of integers, find the one that appears an odd number of times.
 * 
 * There will always be only one integer that appears an odd number of times.
 * 
 * Examples
 * [7] should return 7, because it occurs 1 time (which is odd).
 * [0] should return 0, because it occurs 1 time (which is odd).
 * [1,1,2] should return 2, because it occurs 1 time (which is odd).
 * [0,1,0,1,0] should return 0, because it occurs 3 times (which is odd).
 * [1,2,2,3,3,3,4,3,3,3,2,2,1] should return 4, because it appears 1 time (which is odd).
 */
public class FindOdd {
	
	public static int findIt(int[] a) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Arrays.stream(a).forEach(x -> map.put(x, map.computeIfAbsent(x, s -> 0) + 1));
		for (Entry<Integer, Integer> e : map.entrySet()) {
			if (e.getValue() % 2 == 1) {
				return e.getKey();
			}
		}
		return -1;
	}
	
	@Test
	public void testFindIt() {
		  int[] expected = new int[] {0, 4};
		  int[] actual = new int[] {findIt(new int[] {0,1,0,1,0}), findIt(new int[] {1,2,2,3,3,3,4,3,3,3,2,2,1})};
		  Assert.assertArrayEquals(expected, actual);
	}

}
