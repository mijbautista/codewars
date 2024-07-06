package codewars.four;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

/*
 * DESCRIPTION:
 * Create a function that takes a positive integer and returns the next bigger number that can be formed by rearranging its digits. For example:
 * 
 *   12 ==> 21
 *  513 ==> 531
 * 2017 ==> 2071
 * If the digits can't be rearranged to form a bigger number, return -1 (or nil in Swift, None in Rust):
 * 
 *   9 ==> -1
 * 111 ==> -1
 * 531 ==> -1
 * 
 */

public class NextBigger {
	
	public static long nextBiggerNumber(long n) {
		String nStr = String.valueOf(n);
		char[] arr = nStr.toCharArray();
		String first = "";
		String last = "";
		boolean changed = false;
		for (int i = arr.length - 1; i > 0; i--) {
			if (Character.getNumericValue(arr[i]) > Character.getNumericValue(arr[i - 1])) {
				first = nStr.substring(0, i - 1);
				last = reorder(nStr.charAt(i - 1), nStr.substring(i, nStr.length()));
				changed = true;
				break;
			}
		}
		return changed ? Long.valueOf(first + last) : -1;
	}

	public static String reorder(char c, String s) {
		int min = Integer.MAX_VALUE;
		for (char x : s.toCharArray()) {
			if (Character.getNumericValue(x) > Character.getNumericValue(c)) {
				min = Math.min(min, Character.getNumericValue(x));
			}
		}
		return min + Stream.of(s.replaceFirst(String.valueOf(min), String.valueOf(c)).split("")).sorted()
				.collect(Collectors.joining());
	}

	@Test
	public void test() {
		long expected = 21;
		long actual = nextBiggerNumber(12);
		Assert.assertEquals(expected, actual);
		expected = 531;
		actual = nextBiggerNumber(513);
		Assert.assertEquals(expected, actual);
		expected = 2071;
		actual = nextBiggerNumber(2017);
		Assert.assertEquals(expected, actual);
		expected = -1;
		actual = nextBiggerNumber(9);
		Assert.assertEquals(expected, actual);
	}
	
}
