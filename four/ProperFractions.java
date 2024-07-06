package codewars.four;

import org.junit.Test;
import org.junit.Assert;

/*
 * DESCRIPTION:
 * If n is the numerator and d the denominator of a fraction, that fraction is defined a (reduced) proper fraction if and only if GCD(n,d)==1.
 * 
 * For example 5/16 is a proper fraction, while 6/16 is not, as both 6 and 16 are divisible by 2, thus the fraction can be reduced to 3/8.
 * 
 * Now, if you consider a given number d, how many proper fractions can be built using d as a denominator?
 * 
 * For example, let's assume that d is 15: you can build a total of 8 different proper fractions between 0 and 1 with it: 1/15, 2/15, 4/15, 7/15, 8/15, 11/15, 13/15 and 14/15.
 * 
 * You are to build a function that computes how many proper fractions you can build with a given denominator:
 * 
 * proper_fractions(1)==0
 * proper_fractions(2)==1
 * proper_fractions(5)==4
 * proper_fractions(15)==8
 * proper_fractions(25)==20
 * Be ready to handle big numbers.
 * 
 * Edit: to be extra precise, the term should be "reduced" fractions, thanks to girianshiido for pointing this out and sorry for the use of an improper word :)
 * 
 */

public class ProperFractions {
	
	public static long properFractions(long n) {
		if (n == 1) {
			return 0;
		}
		if (isPrime(n)) {
			return n - 1;
		}
		long tot = n;
		for (int p = 2; p * p <= n; p++) {
			if (n % p == 0) {
				tot /= p;
				tot *= (p - 1);
				while (n % p == 0) {
					n /= p;
				}
			}
		}
		if (n > 1) {
			tot /= n;
			tot *= (n - 1);
		}
		return tot;
	}

	public static boolean isPrime(long num) {
		if (num > 2 && num % 2 == 0) {
			return false;
		}
		long top = (long) Math.sqrt(num) + 1;
		for (long i = 3; i < top; i += 2) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	@Test
	public void test() {
		long expected = 0;
		long actual = properFractions(1);
		Assert.assertEquals(expected, actual);
		expected = 20;
		actual = properFractions(25);
		Assert.assertEquals(expected, actual);
	}

}
