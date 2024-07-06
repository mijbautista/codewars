package codewars.six;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

/*
 * DESCRIPTION:
 * Complete the solution so that the function will break up camel casing, using a space between words.
 * 
 * Example
 * "camelCasing"  =>  "camel Casing"
 * "identifier"   =>  "identifier"
 * ""             =>  ""
 */
public class CamelCase {

	public static String camelCase(String input) {
		if (input == null || input.isEmpty())
			return input;
		String[] arr = input.split("");
		for (int i = 0; i < arr.length; i++) {
			if (Character.isUpperCase(arr[i].charAt(0))) {
				arr[i] = " " + arr[i];
			}
		}
		return Stream.of(arr).collect(Collectors.joining(""));
	}
	
	@Test
	public void testCamelCase() {
		String[] expected = new String[] {"camel Casing","identifier",""};
		String[] actual = new String[] {camelCase("camelCasing"), camelCase("identifier"), camelCase("")};
		Assert.assertArrayEquals(expected, actual);
	}

}
