package codewars.five;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/*
 * DESCRIPTION:
 * The maximum sum subarray problem consists in finding the maximum sum of a contiguous subsequence in an array or list of integers:
 * 
 * Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
 * // should be 6: {4, -1, 2, 1}
 * Easy case is when the list is made up of only positive numbers and the maximum sum is the sum of the whole array. If the list is made up of only negative numbers, return 0 instead.
 * 
 * Empty list is considered to have zero greatest sum. Note that the empty list or array is also a valid sublist/subarray.
 */

public class MaxSubarray {

	public static int sequence(int[] arr) {
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length + 1; i++) {
			for (int j = i; j < arr.length + 1; j++) {
				result = Math.max(result, Arrays.stream(Arrays.copyOfRange(arr, i, j)).sum());
			}
		}
		return arr.length == 0 ? 0 : result;
	}
	
	@Test
	public void testSequence() {
		int[] expected = new int[] {6, 0, 0};
		int[] actual = new int[] {sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}), sequence(new int[]{-1, -2, -3, -4}), sequence(new int[0])};
		Assert.assertArrayEquals(expected, actual);
	}
}
