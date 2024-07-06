package codewars.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

/*
 * DESCRIPTION:
 * Given two strings s1 and s2, we want to visualize how different the two strings are. We will only take into account the lowercase letters (a to z). First let us count the frequency of each lowercase letters in s1 and s2.
 * 
 * s1 = "A aaaa bb c"
 * 
 * s2 = "& aaa bbb c d"
 * 
 * s1 has 4 'a', 2 'b', 1 'c'
 * 
 * s2 has 3 'a', 3 'b', 1 'c', 1 'd'
 * 
 * So the maximum for 'a' in s1 and s2 is 4 from s1; the maximum for 'b' is 3 from s2. In the following we will not consider letters when the maximum of their occurrences is less than or equal to 1.
 * 
 * We can resume the differences between s1 and s2 in the following string: "1:aaaa/2:bbb" where 1 in 1:aaaa stands for string s1 and aaaa because the maximum for a is 4. In the same manner 2:bbb stands for string s2 and bbb because the maximum for b is 3.
 * 
 * The task is to produce a string in which each lowercase letters of s1 or s2 appears as many times as its maximum if this maximum is strictly greater than 1; these letters will be prefixed by the number of the string where they appear with their maximum value and :. If the maximum is in s1 as well as in s2 the prefix is =:.
 * 
 * In the result, substrings (a substring is for example 2:nnnnn or 1:hhh; it contains the prefix) will be in decreasing order of their length and when they have the same length sorted in ascending lexicographic order (letters and digits - more precisely sorted by codepoint); the different groups will be separated by '/'. See examples and "Example Tests".
 * 
 * Hopefully other examples can make this clearer.
 * 
 * s1 = "my&friend&Paul has heavy hats! &"
 * s2 = "my friend John has many many friends &"
 * mix(s1, s2) --> "2:nnnnn/1:aaaa/1:hhh/2:mmm/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss"
 * 
 * s1 = "mmmmm m nnnnn y&friend&Paul has heavy hats! &"
 * s2 = "my frie n d Joh n has ma n y ma n y frie n ds n&"
 * mix(s1, s2) --> "1:mmmmmm/=:nnnnnn/1:aaaa/1:hhh/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss"
 * 
 * s1="Are the kids at home? aaaaa fffff"
 * s2="Yes they are here! aaaaa fffff"
 * mix(s1, s2) --> "=:aaaaaa/2:eeeee/=:fffff/1:tt/2:rr/=:hh"
 * Note for Swift, R, PowerShell
 * The prefix =: is replaced by E:
 * 
 * s1 = "mmmmm m nnnnn y&friend&Paul has heavy hats! &"
 * s2 = "my frie n d Joh n has ma n y ma n y frie n ds n&"
 * mix(s1, s2) --> "1:mmmmmm/E:nnnnnn/1:aaaa/1:hhh/2:yyy/2:dd/2:ff/2:ii/2:rr/E:ee/E:ss"
 *  
 */

public class StringsMix {
	
	public static String mix(String s1, String s2) {
		List<String> result = new ArrayList<>();
		Map<String, Integer> map1 = new HashMap<>();
		Map<String, Integer> map2 = new HashMap<>();
		Set<String> mixed = new HashSet<>();
		Arrays.stream(s1.split("")).filter(x -> Character.isLowerCase(x.charAt(0)))
				.forEach(x -> map1.put(x, map1.computeIfAbsent(x, v -> 0) + 1));
		Arrays.stream(s2.split("")).filter(x -> Character.isLowerCase(x.charAt(0)))
				.forEach(x -> map2.put(x, map2.computeIfAbsent(x, v -> 0) + 1));
		mixed.addAll(map1.keySet());
		mixed.addAll(map2.keySet());
		for (String s : mixed) {
			int a = map1.getOrDefault(s, 0);
			int b = map2.getOrDefault(s, 0);
			if (Math.max(a, b) > 1) {
				result.add((a > b ? "1" : a < b ? "2" : "=") + ":" + s.repeat(Math.max(a, b)));
			}
		}
		result.sort(Comparator.comparing(String::length).reversed().thenComparing(s -> s.charAt(0))
				.thenComparing(String::valueOf));
		return result.stream().collect(Collectors.joining("/"));
	}
	
	@Test
	public void testMix() {
		String s1 = "my&friend&Paul has heavy hats! &";
		String s2 = "my friend John has many many friends &";
		String s3 = "Are the kids at home? aaaaa fffff";
		String s4 = "Yes they are here! aaaaa fffff";
		String[] expected = new String[] {"2:nnnnn/1:aaaa/1:hhh/2:mmm/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss", "=:aaaaaa/2:eeeee/=:fffff/1:tt/2:rr/=:hh"};
		String[] actual = new String[] {mix(s1, s2), mix(s3,s4)};
		Assert.assertArrayEquals(expected, actual);
	}
}
