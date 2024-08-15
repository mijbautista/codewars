package codewars.six;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Test;

/*
 * Description:
 * Encrypt this!
 * 
 * You want to create secret messages which can be deciphered by the Decipher this! kata. Here are the conditions:
 * 
 * Your message is a string containing space separated words.
 * You need to encrypt each word in the message using the following rules:
 * The first letter must be converted to its ASCII code.
 * The second letter must be switched with the last letter
 * Keepin' it simple: There are no special characters in the input.
 * Examples:
 * Kata.encryptThis("Hello") => "72olle"
 * Kata.encryptThis("good") => "103doo"
 * Kata.encryptThis("hello world") => "104olle 119drlo"
 *
 */

public class EncryptThis {

    public static String encryptThis(String text) {
    	if (text.equals("")) return text;
    	return Arrays.stream(text.split(" ")).map(x -> encrypt(x)).collect(Collectors.joining(" "));
    }
    
    public static String encrypt(String text) {
    	int len = text.length();
    	switch(len) {
    	case(1):
    		return String.valueOf((int) text.charAt(0));
    	case(2):
    		return String.valueOf((int) text.charAt(0)) + String.valueOf(text.charAt(1));
    	case(3):
    		return String.valueOf((int) text.charAt(0)) + String.valueOf(text.charAt(2)) + String.valueOf(text.charAt(1));
    	default:
    		return String.valueOf((int) text.charAt(0)) + String.valueOf(text.charAt(text.length()-1)) + text.substring(2,text.length()-1) + String.valueOf(text.charAt(1));
    	}
    }
    
    @Test
    public void exampleTests() {
        assertEquals("", encryptThis(""));
        assertEquals("65 119esi 111dl 111lw 108dvei 105n 97n 111ka", encryptThis("A wise old owl lived in an oak"));
        assertEquals("84eh 109ero 104e 115wa 116eh 108sse 104e 115eokp", encryptThis("The more he saw the less he spoke"));
        assertEquals("84eh 108sse 104e 115eokp 116eh 109ero 104e 104dare", encryptThis("The less he spoke the more he heard"));
        assertEquals("87yh 99na 119e 110to 97ll 98e 108eki 116tah 119esi 111dl 98dri", encryptThis("Why can we not all be like that wise old bird"));
        assertEquals("84kanh 121uo 80roti 102ro 97ll 121ruo 104ple", encryptThis("Thank you Piotr for all your help"));
    }
}
