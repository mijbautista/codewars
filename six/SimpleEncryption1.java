package codewars.six;

import org.junit.Assert;
import org.junit.Test;

/*
 * DESCRIPTION:
 * Implement a pseudo-encryption algorithm which given a string S and an integer N concatenates all the odd-indexed characters of S with all the even-indexed characters of S, this process should be repeated N times.
 * 
 * Examples:
 * 
 * encrypt("012345", 1)  =>  "135024"
 * encrypt("012345", 2)  =>  "135024"  ->  "304152"
 * encrypt("012345", 3)  =>  "135024"  ->  "304152"  ->  "012345"
 * 
 * encrypt("01234", 1)  =>  "13024"
 * encrypt("01234", 2)  =>  "13024"  ->  "32104"
 * encrypt("01234", 3)  =>  "13024"  ->  "32104"  ->  "20314"
 * Together with the encryption function, you should also implement a decryption function which reverses the process.
 * 
 * If the string S is an empty value or the integer N is not positive, return the first argument without changes.
 */

public class SimpleEncryption1 {
	
	public static String encrypt(final String text, final int n) {
		if (n <= 0) {
			return text;
		}

		String odd = "";
		String even = "";
		for (int i = 0; i < text.length(); i++) {
			if (i % 2 == 0) {
				even += text.charAt(i);
			} else {
				odd += text.charAt(i);
			}
		}

		return encrypt(odd + even, n - 1);
	}

	public static String decrypt(final String encryptedText, final int n) {
		if (n <= 0) {
			return encryptedText;
		}

		String text = "";
		int mid = encryptedText.length() / 2;
		String odd = encryptedText.substring(0, mid);
		String even = encryptedText.substring(mid);
		for (int i = 0; i < mid; i++) {
			text += String.valueOf(even.charAt(i)) + String.valueOf(odd.charAt(i));
		}

		if (encryptedText.length() % 2 == 1) {
			text += encryptedText.charAt(encryptedText.length() - 1);
		}

		return decrypt(text, n - 1);
	}
	
	@Test
	public void testEncrypt() {
		String[] expected = new String[] {"135024", "304152", "20314"};
		String[] actual = new String[] {encrypt("012345", 1), encrypt("012345", 2), encrypt("01234", 3)};
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testDecrypt() {
		String[] expected = new String[] {"012345", "012345", "01234"};
		String[] actual = new String[] {decrypt("135024", 1), decrypt("304152", 2), decrypt("20314", 3)};
		Assert.assertArrayEquals(expected, actual);
	}

}
