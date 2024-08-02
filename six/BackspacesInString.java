package codewars.six;

import static org.junit.Assert.assertEquals;

import java.util.Stack;
import java.util.stream.Collectors;

import org.junit.Test;

/*
 * Assume "#" is like a backspace in string. This means that string "a#bc#d" actually is "bd"
 * 
 * Your task is to process a string with "#" symbols.
 * 
 * Examples
 * "abc#d##c"      ==>  "ac"
 * "abc##d######"  ==>  ""
 * "#######"       ==>  ""
 * ""              ==>  ""
 * 
 */

public class BackspacesInString {
	
	public String cleanString(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '#') {
		        if (!stack.isEmpty())
						  stack.pop();
			} else {
				stack.push(c);
			}
		}
		return stack.stream().map(String::valueOf).collect(Collectors.joining());
	}
	
    @Test
    public void testCleanString() {
        final BackspacesInString bis = new BackspacesInString();
        assertEquals("ac", bis.cleanString("abc#d##c"));
        assertEquals("", bis.cleanString("abc####d##c#"));
    }
}
