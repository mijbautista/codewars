package codewars.six;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

/*
 * Longest Palindrome
 * Find the length of the longest substring in the given string s that is the same in reverse.
 * 
 * As an example, if the input was “I like racecars that go fast”, the substring (racecar) length would be 7.
 * 
 * If the length of the input string is 0, the return value must be 0.
 * 
 * Example:
 * "a" -> 1 
 * "aab" -> 2  
 * "abcde" -> 1
 * "zzbaabcd" -> 4
 * "" -> 0
 * 
 */

public class LongestPalindrome {
	
    public static int longestPalindrome(final String s) {
    	if (s == null) {
    		throw new IllegalArgumentException("s cannot be null");
    	}
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
        	for (int j = i; j <= len; j++) {
        		String sub = s.substring(i,j);
        		if (new StringBuilder(sub).reverse().toString().equals(sub)) {
        			max = Math.max(max, sub.length());
        		}
        	}
        }
        return max;
    }
    
    @Test
    public void basicTests() {
        doTest("a", 1);
        doTest("aa", 2);
        doTest("baa", 2);
        doTest("aab", 2);
        doTest("zyabyz", 1);
        doTest("baabcd", 4);
        doTest("baablkj12345432133d", 9);
        testException(null);
    }
    private void doTest(final String s, int expected) {
        assertEquals(expected, longestPalindrome(s));
    }
    
    public void testException(final String s) {
        assertThrows(IllegalArgumentException.class, () -> longestPalindrome(s));
    }

}
