package codewars.five;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.Arrays;

import org.junit.Test;

/*
 * DESCRIPTION:
 * Define a function that takes in two non-negative integers a and b and returns the last decimal digit of a^b Note that a and b may be very large!
 * 
 * For example, the last decimal digit of 9^7 is 9 since 9^7 = 4782969
 * The last decimal digit of (2^200)^2^300, which has over 10^92 decimal digits, is 6. Also, please take 0^0 to be 1.
 * 
 * You may assume that the input will always be valid.
 * 
 * Examples
 * lastDigit(new BigInteger("4"), new BigInteger("1")) // returns 4
 * lastDigit(new BigInteger("4"), new BigInteger("2")) // returns 6
 * lastDigit(new BigInteger("9"), new BigInteger("7")) // returns 9
 * lastDigit(new BigInteger("10"), new BigInteger("10000000000")) // returns 0
 * 
 */
public class LastDigit {
	
	public static int lastDigit(BigInteger n1, BigInteger n2) {
		if (n1.equals(BigInteger.ZERO) && n2.equals(BigInteger.ZERO)) {
			return 1;
		}
		if (n1.equals(BigInteger.ZERO)) {
			return 0;
		}
		if (n2.equals(BigInteger.ZERO)) {
			return 1;
		}
		if (n1.compareTo(BigInteger.TEN) == -1) {
			return Integer.valueOf(n1.pow(n2.intValue()).mod(BigInteger.TEN).toString());
		}
		BigInteger FOUR = new BigInteger("4");
		BigInteger TWO = new BigInteger("2");
		String s1 = n1.mod(BigInteger.TEN).toString();
		String s2 = n2.mod(BigInteger.TEN).toString();
		if (s1.equals("0") && s2.equals("0")) {
			return 0;
		}
		if (s1.equals("1")) {
			return 1;
		}
		if (s1.equals("2")) {
			return Arrays.asList(6, 2, 4, 8).get(n2.mod(FOUR).intValue());
		}
		if (s1.equals("3")) {
			return Arrays.asList(1, 3, 9, 7).get(n2.mod(FOUR).intValue());
		}
		if (s1.equals("4")) {
			return Arrays.asList(6, 4).get(n2.mod(TWO).intValue());
		}
		if (s1.equals("5")) {
			return 5;
		}
		if (s1.equals("6")) {
			return 6;
		}
		if (s1.equals("7")) {
			return Arrays.asList(1, 7, 9, 3).get(n2.mod(FOUR).intValue());
		}
		if (s1.equals("8")) {
			return Arrays.asList(6, 8, 4, 2).get(n2.mod(FOUR).intValue());
		}
		if (s1.equals("9")) {
			return Arrays.asList(1, 9).get(n2.mod(TWO).intValue());
		}
		if (s1.equals("0")) {
			return 0;
		}
		if (s2.equals("0")) {
			return 1;
		}
		return -1;
	}
	
    @Test
    public void testSomething() {
      assertEquals(8, lastDigit(new BigInteger("2"), new BigInteger("7")));
      assertEquals(4, lastDigit(new BigInteger("4"), new BigInteger("1")));
      assertEquals(6, lastDigit(new BigInteger("4"), new BigInteger("2")));
      assertEquals(9, lastDigit(new BigInteger("9"), new BigInteger("7")));
      assertEquals(0, lastDigit(new BigInteger("277729583566145685629813978781857676140593156138279381000702637768739028979561947998275050"), new BigInteger("1720857398812566279724116746450762425453811509734843166926584830207219423684503414566799689")));
      assertEquals(8, lastDigit(new BigInteger("575331109893107440057961954682714499307562233520418991229536905304924880713881046235391882"), new BigInteger("1591137811292633156847161859742884806627333327860415221461508577023150165745809972686678795")));
    }

}
