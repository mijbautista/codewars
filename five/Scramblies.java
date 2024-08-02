package codewars.five;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.junit.Test;

/*
 * Complete the function scramble(str1, str2) that returns true if a portion of str1 characters can be rearranged to match str2, otherwise returns false.
 * 
 * Notes:
 * 
 * Only lower case letters will be used (a-z). No punctuation or digits will be included.
 * Performance needs to be considered.
 * Examples
 * scramble('rkqodlw', 'world') ==> True
 * scramble('cedewaraaossoqqyt', 'codewars') ==> True
 * scramble('katas', 'steak') ==> False
 * 
 */

public class Scramblies {

	public static boolean scramble(String str1, String str2) {
		if (str1.equals(str2)) return true;
		str1 = Arrays.stream(str1.split("")).sorted().collect(Collectors.joining());
		Map<String,Integer> str2Map = new HashMap<>();
		for (String s : str2.split("")) {
			str2Map.put(s, str2Map.getOrDefault(s, 0) + 1);
		}
		for (Entry<String, Integer> entry : str2Map.entrySet()) {
			if (str1.indexOf(entry.getKey().repeat(entry.getValue())) == -1) {
				return false;
			}
		}
		return true;
	}
	
	private static void testing(boolean actual, boolean expected) {
		assertEquals(expected, actual);
	}

	@Test
	public void sampleTests() {
		testing(Scramblies.scramble("rkqodlw", "world"), true);
		testing(Scramblies.scramble("cedewaraaossoqqyt", "codewars"), true);
		testing(Scramblies.scramble("katas", "steak"), false);
		testing(Scramblies.scramble("scriptjavx", "javascript"), false);
		testing(Scramblies.scramble("scriptingjava", "javascript"), true);
		testing(Scramblies.scramble("scriptsjava", "javascripts"), true);
		testing(Scramblies.scramble("javscripts", "javascript"), false);
		testing(Scramblies.scramble("aabbcamaomsccdd", "commas"), true);
		testing(Scramblies.scramble("commas", "commas"), true);
		testing(Scramblies.scramble("sammoc", "commas"), true);
	}

	@Test
	public void largeTest() {

		String s1 = "abcdefghijklmnopqrstuvwxyz".repeat(10_000);
		String s2 = "zyxcba".repeat(9_000);

		testing(Scramblies.scramble(s1, s2), true);
	}
}
