package codewars.five;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Random;
import static java.lang.Math.log;

import org.junit.Test;

/*
 * A perfect power is a classification of positive integers:
 * 
 * In mathematics, a perfect power is a positive integer that can be expressed as an integer power of another positive integer. More formally, n is a perfect power if there exist natural numbers m > 1, and k > 1 such that mk = n.
 * 
 * Your task is to check wheter a given integer is a perfect power. If it is a perfect power, return a pair m and k with mk = n as a proof. Otherwise return Nothing, Nil, null, NULL, None or your language's equivalent.
 * 
 * Note: For a perfect power, there might be several pairs. For example 81 = 3^4 = 9^2, so (3,4) and (9,2) are valid solutions. However, the tests take care of this, so if a number is a perfect power, return any pair that proves it.
 * 
 * Examples
 * isPerfectPower(4) => new int[]{2,2}
 * isPerfectPower(5) => null
 * isPerfectPower(8) => new int[]{2,3}
 * isPerfectPower(9) => new int[]{3,2}
 * 
 */

public class PerfectPower {
	
	public static int[] isPerfectPower(int n) {
		for (int i = 2; i * i <= n; i++) {
			for (int j = 2; Math.pow(i, j) <= n; j++) {
				if (Math.pow(i, j) == n) {
					return new int[] {i,j};
				}
			}
		}
		return null;
	}

	@Test
	public void test0() {
		assertNull("0 is not a perfect number", PerfectPower.isPerfectPower(0));
	}

	@Test
	public void test1() {
		assertNull("1 is not a perfect number", PerfectPower.isPerfectPower(1));
	}

	@Test
	public void test2() {
		assertNull("2 is not a perfect number", PerfectPower.isPerfectPower(2));
	}

	@Test
	public void test3() {
		assertNull("3 is not a perfect number", PerfectPower.isPerfectPower(3));
	}

	@Test
	public void test4() {
		assertArrayEquals("4 = 2^2", new int[] { 2, 2 }, PerfectPower.isPerfectPower(4));
	}

	@Test
	public void test5() {
		assertNull("5 is not a perfect power", PerfectPower.isPerfectPower(5));
	}

	@Test
	public void test8() {
		assertArrayEquals("8 = 2^3", new int[] { 2, 3 }, PerfectPower.isPerfectPower(8));
	}

	@Test
	public void test9() {
		assertArrayEquals("9 = 3^2", new int[] { 3, 2 }, PerfectPower.isPerfectPower(9));
	}

	@Test
	public void testUpTo500() {
		int[] pp = { 4, 8, 9, 16, 25, 27, 32, 36, 49, 64, 81, 100, 121, 125, 128, 144, 169, 196, 216, 225, 243, 256,
				289, 324, 343, 361, 400, 441, 484 };
		for (int i : pp)
			assertNotNull(i + " is a perfect power", PerfectPower.isPerfectPower(i));
	}

	@Test
	public void testRandomPerfectPowers() {
		Random rnd = new Random();
		for (int i = 0; i < 100; i++) {
			int m = rnd.nextInt(254) + 2;
			int k = (int) (rnd.nextDouble() * (log(Integer.MAX_VALUE) / log(m) - 2.0) + 2.0);
			int l = ipow(m, k);
			int[] r = PerfectPower.isPerfectPower(l);
			assertNotNull(l + " is a perfect power", r);
			assertEquals(r[0] + "^" + r[1] + "!=" + l, l, ipow(r[0], r[1]));
		}
	}

	@Test
	public void testRandomNumbers() {
		Random rnd = new Random();
		for (int i = 0; i < 100; i++) {
			int l = rnd.nextInt(Integer.MAX_VALUE);
			int[] r = PerfectPower.isPerfectPower(l);
			if (r != null)
				assertEquals(r[0] + "^" + r[1] + "!=" + l, l, ipow(r[0], r[1]));
		}
	}

	private static int ipow(int b, int e) {
		int p = 1;
		for (; e > 0; e >>= 1) {
			if ((e & 1) == 1)
				p *= b;
			b *= b;
		}
		return p;
	}

}
