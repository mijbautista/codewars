package codewars.six;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

/*
 * DESCRIPTION:
 * Jamie is a programmer, and James' girlfriend. She likes diamonds, and wants a diamond string from James. Since James doesn't know how to make this happen, he needs your help.
 * 
 * Task
 * You need to return a string that looks like a diamond shape when printed on the screen, using asterisk (*) characters. Trailing spaces should be removed, and every line must be terminated with a newline character (\n).
 * 
 * Return null/nil/None/... if the input is an even number or negative, as it is not possible to print a diamond of even or negative size.
 * 
 * Examples
 * A size 3 diamond:
 * 
 *  *
 * ***
 *  *
 * ...which would appear as a string of " *\n***\n *\n"
 * 
 * A size 5 diamond:
 * 
 *   *
 *  ***
 * *****
 *  ***
 *   *
 * ...that is:
 * 
 * "  *\n ***\n*****\n ***\n  *\n"
 * 
 */
public class Diamond {
	
	public static String print(int n) {
		if (n < 1 || n % 2 == 0)
			return null;
		String[] ends = new String[n];
		for (int i = 0; i < n / 2; i++) {
			ends[i] = " ".repeat((n / 2) - i) + "*".repeat(i * 2 + 1) + "\n";
			ends[n - i - 1] = ends[i];
		}
		ends[n / 2] = "*".repeat(n) + "\n";
		return Stream.of(ends).collect(Collectors.joining(""));
	}
	
	@Test
	public void testPrint() {
		String[] expected = new String[] {"  *\n ***\n*****\n ***\n  *\n", " *\n***\n *\n"};
		String[] actual = new String[] {print(5), print(3)};
		Assert.assertArrayEquals(expected, actual);
	}

}
