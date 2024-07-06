package codewars.six;

import org.junit.Assert;
import org.junit.Test;

/*
 * DESCRIPTION:
 * Prior to having fancy iPhones, teenagers would wear out their thumbs sending SMS messages on candybar-shaped feature phones with 3x4 numeric keypads.
 * 
 * ------- ------- -------
 * |     | | ABC | | DEF |
 * |  1  | |  2  | |  3  |
 * ------- ------- -------
 * ------- ------- -------
 * | GHI | | JKL | | MNO |
 * |  4  | |  5  | |  6  |
 * ------- ------- -------
 * ------- ------- -------
 * |PQRS | | TUV | | WXYZ|
 * |  7  | |  8  | |  9  |
 * ------- ------- -------
 * ------- ------- -------
 * |  *  | |space| |  #  |
 * |     | |  0  | |     |
 * ------- ------- -------
 * Prior to the development of T9 systems (predictive text entry), the method to type words was called "multi-tap" and involved pressing a button repeatedly to cycle through all its possible values, in order. For example:
 * 
 * Pressing the button 7 repeatedly will cycle through the letters P -> Q -> R -> S -> 7 -> P -> ....
 * Pressing the button 0 is cycling through SPACE -> 0 -> SPACE -> 0 -> ....
 * Buttons with a single symbol on it just type this symbol.
 * A character is "locked in" and inserted into the message once the user presses a different key or pauses for a short period of time (thus, no extra button presses are required beyond what is needed for each letter individually). For example:
 * 
 * To type a letter "R" you would press the 7 key three times (as the screen display for the current character cycles through P->Q->R->S->7).
 * To type in a digit 3, you would press the button 3 four times.
 * To type in the message "ABC", you would press the button 2 once, wait a second, then press the button 2 twice to enter the letter B, then pause for another second, and press the button 2 three times, to enter the letter C. You would have to press the button 2 six times in total.
 * In order to send the message "WHERE DO U WANT 2 MEET L8R" a teen would have to actually do 47 button presses. No wonder they abbreviated...
 * 
 * For this assignment, write code that can calculate the amount of button presses required for any phrase, with the following requirements:
 * 
 * Punctuation can be ignored for this exercise.
 * Likewise, the phone doesn't distinguish between upper and lowercase characters (but you should allow your module to accept input in either form, for convenience).
 * Tested phrases contain letters (A-Z and a-z), digits (0-9), and special characters # and *.
 * 
 */
public class Keypad {
	
	public static int presses(String phrase) {
		final String ONE = "1ADGJMPTW*# ";
		final String TWO = "0BEHKNQUX";
		final String THREE = "CFILORVY";
		final String FOUR = "234568SZ";
		final String FIVE = "79";
		int ctr = 0;
		for (char c : phrase.toUpperCase().toCharArray()) {
			if (ONE.indexOf(c) != -1) {
				ctr += 1;
			} else if (TWO.indexOf(c) != -1) {
				ctr += 2;
			} else if (THREE.indexOf(c) != -1) {
				ctr += 3;
			} else if (FOUR.indexOf(c) != -1) {
				ctr += 4;
			} else if (FIVE.indexOf(c) != -1) {
				ctr += 5;
			}
		}
		return ctr;
	}
	
	@Test
	public void testKeypad() {
		int[] expected = new int[] {47, 60, 4, 0};
		int[] actual = new int[] {presses("WHERE DO U WANT 2 MEET L8R"), presses("d*XLprdFJluvlNxciigwkfpjpHcNl"), presses("*#0"), presses("?")};
		Assert.assertArrayEquals(expected, actual);
	}

}
