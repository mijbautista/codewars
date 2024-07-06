package codewars.five;

import org.junit.Assert;
import org.junit.Test;

/*
 * DESCRIPTION:
 * The rgb function is incomplete. Complete it so that passing in RGB decimal values will result in a hexadecimal representation being returned. Valid decimal values for RGB are 0 - 255. Any values that fall out of that range must be rounded to the closest valid value.
 * 
 * Note: Your answer should always be 6 characters long, the shorthand with 3 will not work here.
 * 
 * Examples (input --> output):
 * 255, 255, 255 --> "FFFFFF"
 * 255, 255, 300 --> "FFFFFF"
 * 0, 0, 0       --> "000000"
 * 148, 0, 211   --> "9400D3"
 * 
 */

public class RGBToHex {

	public static String rgb(int r, int g, int b) {
		r = roundForHex(r);
		g = roundForHex(g);
		b = roundForHex(b);
		return formatHex(Integer.toHexString(r)) + formatHex(Integer.toHexString(g))
				+ formatHex(Integer.toHexString(b));
	}

	public static int roundForHex(int i) {
		if (i < 0) {
			return 0;
		}
		if (i > 255) {
			return 255;
		}
		return i;
	}

	public static String formatHex(String s) {
		if (s.length() == 1) {
			s = "0" + s;
		}
		return s.toUpperCase();
	}
	
	@Test
	public void test() {
		Assert.assertEquals("FFFFFF", rgb(255, 255, 255));
		Assert.assertEquals("FFFFFF", rgb(255, 255, 300));
		Assert.assertEquals("000000", rgb(0, 0, 0));
		Assert.assertEquals("9400D3", rgb(148, 0, 211));
	}
}
