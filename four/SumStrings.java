package codewars.four;

import org.junit.Assert;

import org.junit.Test;

/*
 * DESCRIPTION:
 * Given the string representations of two integers, return the string representation of the sum of those integers.
 * 
 * For example:
 * 
 * sumStrings('1','2') // => '3'
 * A string representation of an integer will contain no characters besides the ten numerals "0" to "9".
 * 
 * I have removed the use of BigInteger and BigDecimal in java
 * 
 */
public class SumStrings {
	
	public static String sumStrings(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int x = 0;
		int i = 0;
		int n = Math.max(a.length(), b.length());
		while (i < n || x > 0) {
			if (i < a.length())
				x += a.charAt(a.length() - 1 - i) - '0';
			if (i < b.length())
				x += b.charAt(b.length() - 1 - i) - '0';
			sb.append(x % 10);
			x = x / 10;
			i++;
		}
		String f = sb.reverse().toString();
        return removeLeadingZeroes(f);
  }
  
	public static String removeLeadingZeroes(String a) {
		while (a.charAt(0) == '0' && a.length() > 1) {
			a = a.substring(1, a.length());
		}
		return a;
	}

	@Test
	public void test() {
		String expected = "579";
		String actual = sumStrings("123", "456");
		Assert.assertEquals(expected, actual);
		expected = "2165024373399433734517510";
		actual = sumStrings("0681652352232265054215453","1483372021167168680302057");
		Assert.assertEquals(expected, actual);
		expected = "2165024373399433734517510";
		actual = sumStrings("0000000681652352232265054215453","1483372021167168680302057");
		Assert.assertEquals(expected, actual);
	}
}
