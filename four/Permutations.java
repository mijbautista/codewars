package codewars.four;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

/*
 * DESCRIPTION:
 * In this kata, your task is to create all permutations of a non-empty input string and remove duplicates, if present.
 * 
 * Create as many "shufflings" as you can!
 * 
 * Examples:
 * 
 * With input 'a':
 * Your function should return: ['a']
 * 
 * With input 'ab':
 * Your function should return ['ab', 'ba']
 * 
 * With input 'abc':
 * Your function should return ['abc','acb','bac','bca','cab','cba']
 * 
 * With input 'aabb':
 * Your function should return ['aabb', 'abab', 'abba', 'baab', 'baba', 'bbaa']
 * Note: The order of the permutations doesn't matter.
 */
public class Permutations {
	
    public static List<String> singlePermutations(String s) {
		List<String> list = new ArrayList<>();
		perm(s, "", list);
		return list.stream().sorted(Comparator.comparing(String::valueOf)).distinct().collect(Collectors.toList());
    }
	
	public static void perm(String str, String temp, List<String> list) {
		if (str.length() == 0) {
			list.add(temp);
		} else {
			for (int i = 0; i < str.length(); i++) {
				String sub = str.substring(0,i) + str.substring(i + 1);
				char c = str.charAt(i);
				perm(sub, temp + c, list);
			}
		}
	}
	
	@Test
	public void testPermutations() {
		List<String> expected = List.of("ab","ba");
		List<String> actual = singlePermutations("ab");
		Assert.assertEquals(expected, actual);
		expected = List.of("aabb", "abab", "abba", "baab", "baba", "bbaa");
		actual = singlePermutations("aabb");
		Assert.assertEquals(expected, actual);
		
	}

}
