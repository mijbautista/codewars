package codewars.four;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

/*
 * Task
 * Given a positive integral number n, return a strictly increasing sequence (list/array/string depending on the language) of numbers, so that the sum of the squares is equal to n².
 * 
 * If there are multiple solutions (and there will be), return as far as possible the result with the largest possible values:
 * 
 * Examples
 * decompose(11) must return [1,2,4,10]. Note that there are actually two ways to decompose 11², 11² = 121 = 1 + 4 + 16 + 100 = 1² + 2² + 4² + 10² but don't return [2,6,9], since 9 is smaller than 10.
 * 
 * For decompose(50) don't return [1, 1, 4, 9, 49] but [1, 3, 5, 8, 49] since [1, 1, 4, 9, 49] doesn't form a strictly increasing sequence.
 * 
 * Note
 * Neither [n] nor [1,1,1,…,1] are valid solutions. If no valid solution exists, return nil, null, Nothing, None (depending on the language) or "[]" (C) ,{} (C++), [] (Swift, Go).
 * 
 * The function "decompose" will take a positive integer n and return the decomposition of N = n² as:
 * 
 * [x1 ... xk] or
 * "x1 ... xk" or
 * Just [x1 ... xk] or
 * Some [x1 ... xk] or
 * {x1 ... xk} or
 * "[x1,x2, ... ,xk]"
 * depending on the language (see "Sample tests")
 * 
 * Note for Bash
 * decompose 50 returns "1,3,5,8,49"
 * decompose 4  returns "Nothing"
 * Hint
 * Very often xk will be n-1.
 * 
 */

public class Decompose {
	
	public String decompose(long n) {
		Set<Long> set = decompose(n, n * n);
		return set == null || set.size() < 2 ? null : set.stream().sorted().map(String::valueOf).collect(Collectors.joining(" "));
	}

	public Set<Long> decompose(long curr, long val) {
		Set<Long> set = new HashSet<Long>();
		if (val == 0) {
			set.add(curr);
			return set;
		}
		for (long i = curr - 1; i > 0; i--) {
			long currSq = i * i;
			if ((val - currSq) >= 0) {
				set = decompose(i, (val - currSq));
				if (set != null) {
					set.add(i);
					return set;
				}
			}
		}
		return null;
	}

	@Test
	public void test1() {
		Decompose d = new Decompose();
		long n = 11;
		assertEquals("1 2 4 10", d.decompose(n));
		assertEquals("6 10 139 9728", d.decompose(9729));
	}

}
