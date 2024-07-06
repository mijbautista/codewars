package codewars.six;

import org.junit.Assert;
import org.junit.Test;

/*
 * DESCRIPTION:
 * Write Number in Expanded Form
 * You will be given a number and you will need to return it as a string in Expanded Form. For example:
 * 
 * Kata.expandedForm(12); # Should return "10 + 2"
 * Kata.expandedForm(42); # Should return "40 + 2"
 * Kata.expandedForm(70304); # Should return "70000 + 300 + 4"
 * NOTE: All numbers will be whole numbers greater than 0.
 * 
 */

public class ExpandedForm {
	
	public static String expandedForm(int num) {
		String strNum = String.valueOf(num);
		if (strNum.replaceAll("0", "").length() < 2) {
			return strNum;
		}
		if (num > 9) {
			String result = strNum.substring(0, 1);
			String temp = strNum.substring(1, strNum.length());
			return result + "0".repeat(temp.length()) + " + " + expandedForm(Integer.parseInt(temp));
		} else {
			return strNum;
		}
	}
	
	@Test
	public void testExpandedForm() {
		String[] expected = new String[] {"10 + 2", "40 + 2", "70000 + 300 + 4", "1000"};
		String[] actual = new String[] {expandedForm(12), expandedForm(42), expandedForm(70304), expandedForm(1000)};
		Assert.assertArrayEquals(expected, actual);
	}
}
