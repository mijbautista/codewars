package codewars.four;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*
 * DESCRIPTION:
 * We need to sum big numbers and we require your help.
 * 
 * Write a function that returns the sum of two numbers. The input numbers are strings and the function must return a string.
 * 
 * Example
 * add("123", "321"); -> "444"
 * add("11", "99");   -> "110"
 * Notes
 * The input numbers are big.
 * The input is a string of only digits
 * The numbers are positives
 */

public class BigNumbers {
	
	public static String add(String a, String b) {
		if (a.length() > b.length()) {
			b = pad(b, a.length());
		} else if (b.length() > a.length()) {
			a = pad(a, b.length());
		}
		String result = "";
		char[] arra = a.toCharArray();
		char[] arrb = b.toCharArray();
		for (int i = 0; i < arra.length; i++) {
			int x = Integer.parseInt(String.valueOf(arra[i])) + Integer.parseInt(String.valueOf(arrb[i]));
			if (x > 9) {
        if (result.isEmpty()) {
          result = String.valueOf(x);
        } else {
				  result = increment(result) + (x%10);
        }
			} else {
				result += x;
			}
		}
		return removePad(result);
	}
	
	public static String increment(String a) {
		if (a.endsWith("9")) {
			return increment(a.substring(0,a.length()-1)) + 0;
		} else {
			return a.substring(0,a.length()-1) + (Integer.valueOf(String.valueOf(a.charAt(a.length()-1))) + 1);
		}
	}
	
	public static String pad(String a, int n) {
		while (a.length() < n) {
			a = "0" + a;
		}
		return a;
	}
	
	public static String removePad(String a) {
		while (a.startsWith("0")) {
			a = a.substring(1);
		}
		return a;
	}
	
	@Test
	public void test() {
		assertEquals("579", add("123","456"));
		assertEquals("1441", add("1372","69"));
		assertEquals("91002328220491911630239667963", add("63829983432984289347293874","90938498237058927340892374089"));
	}

}
