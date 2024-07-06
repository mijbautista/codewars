package codewars.six;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/*
 * DESCRIPTION:
 * Given two arrays of strings a1 and a2 return a sorted array r in lexicographical order of the strings of a1 which are substrings of strings of a2.
 * 
 * Example 1:
 * a1 = ["arp", "live", "strong"]
 * 
 * a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
 * 
 * returns ["arp", "live", "strong"]
 * 
 * Example 2:
 * a1 = ["tarp", "mice", "bull"]
 * 
 * a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
 * 
 * returns []
 * 
 */

public class WhichAreIn {
	
	public static String[] inArray(String[] array1, String[] array2) {
		List<String> list = new ArrayList<String>();
		Arrays.sort(array1, String.CASE_INSENSITIVE_ORDER);
		for (String s : array1) {
			for (String r : array2) {
				if (r.indexOf(s) >= 0) {
					list.add(s);
					break;
				}
			}
		}
		return list.size() == 0 ? new String[] {} : list.toArray(new String[list.size()]);
	}
	
	@Test
	public void test() {
		String[] a1 = new String[] { "arp", "live", "strong" };
		String[] a2 = new String[] { "lively", "alive", "harp", "sharp", "armstrong" };
		String[] e1 = new String[] { "arp", "live", "strong" };
		Assert.assertArrayEquals(e1, inArray(a1, a2));
		String[] a3 = new String[] { "tarp", "mice", "bull" };
		String[] a4 = new String[] { "lively", "alive", "harp", "sharp", "armstrong" };
		String[] e2 = new String[] {};
		Assert.assertArrayEquals(e2, inArray(a3, a4));
	}

}
