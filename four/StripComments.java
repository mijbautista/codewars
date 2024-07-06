package codewars.four;

import org.junit.Test;
import org.junit.Assert;

/*
 * DESCRIPTION:
 * Complete the solution so that it strips all text that follows any of a set of comment markers passed in. Any whitespace at the end of the line should also be stripped out.
 * 
 * Example:
 * 
 * Given an input string of:
 * 
 * apples, pears # and bananas
 * grapes
 * bananas !apples
 * The output expected would be:
 * 
 * apples, pears
 * grapes
 * bananas
 * The code would be called like so:
 * 
 * var result = solution("apples, pears # and bananas\ngrapes\nbananas !apples", ["#", "!"])
 * // result should == "apples, pears\ngrapes\nbananas"
 * 
 */

public class StripComments {
	
	public static String stripComments(String text, String[] commentSymbols) {
		String[] arr = text.split("\\n");
		String result = "";
		for (String s : arr) {
			boolean modified = false;
			for (String t : commentSymbols) {
				if (s.indexOf(t) > -1) {
					result += s.substring(0, s.indexOf(t)).replaceAll("\\s+$", "") + "\n";
					modified = true;
				}
			}
			if (!modified) {
				result += s.replaceAll("\\s+$", "") + "\n";
			}
		}
		return result.substring(0, result.length() - 1);
	}
	
	@Test
	public void test() {
		String expected = "apples, pears\ngrapes\nbananas";
		String actual = stripComments("apples, pears # and bananas\ngrapes\nbananas !apples", new String[]{"#", "!"});
		Assert.assertEquals(expected, actual);
	}

}
