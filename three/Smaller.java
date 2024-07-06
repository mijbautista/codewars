package codewars.three;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/*
 * DESCRIPTION:
 * This is a hard version of How many are smaller than me?. If you have troubles solving this one, have a look at the easier kata first.
 * 
 * Write
 * 
 * function smaller(arr)
 * that given an array arr, you have to return the amount of numbers that are smaller than arr[i] to the right.
 * 
 * For example:
 * 
 * smaller([5, 4, 3, 2, 1]) === [4, 3, 2, 1, 0]
 * smaller([1, 2, 0]) === [1, 1, 0]
 * 
 */

public class Smaller {
	
	public static int[] smaller(int[] unsorted) {
		int n = unsorted.length;
		int[] counts = new int[n];
		int min = Arrays.stream(unsorted).min().orElse(Integer.MIN_VALUE);
		int max = Arrays.stream(unsorted).max().orElse(Integer.MAX_VALUE);
		int[] count = new int[max - min + 1];
		for (int i = n - 1; i >= 0; i--) {
			int curr = unsorted[i] - min;
			for (int j = curr - 1; j >= 0; j--) {
				counts[i] += count[j];
			}
			count[curr]++;
		}
		return counts;
	}

	@Test
	public void testSmaller() {
		int[][] expected = new int[][] {new int[] {4, 3, 2, 1, 0}, new int[] {1,1,0}};
		int[][] actual = new int[][] {smaller(new int[] {5, 4, 3, 2, 1}), smaller(new int[] {1, 2, 0})};
		Assert.assertArrayEquals(expected, actual);
	}
}
