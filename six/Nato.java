package codewars.six;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

/*
 * Task
 * You'll have to translate a string to Pilot's alphabet (NATO phonetic alphabet).
 * 
 * Input:
 * 
 * If, you can read?
 * 
 * Output:
 * 
 * India Foxtrot , Yankee Oscar Uniform Charlie Alfa November Romeo Echo Alfa Delta ?
 * 
 * Note:
 * 
 * There is a preloaded dictionary that you can use, named NATO. It uses uppercase keys, e.g. NATO['A'] is "Alfa". See comments in the initial code to see how to access it in your language.
 * The set of used punctuation is ,.!?.
 * Punctuation should be kept in your return string, but spaces should not.
 * Xray should not have a dash within.
 * Every word and punctuation mark should be seperated by a space ' '.
 * There should be no trailing whitespace
 * 
 */

public class Nato {

	public static String toNATO(String string) {
		// You can use Helper.NATO, of type: Map<Character, String>
		// usage: Helper.NATO.get('A') returns "Alfa", etc.
		List<String> list = new ArrayList<>();

		for (Character c : string.toCharArray()) {
			if (Character.isAlphabetic(c)) {
				list.add(Helper.NATO.get(Character.toUpperCase(c)));
			} else if (",.!?".indexOf(c) != -1) {
				list.add(c.toString());
			}
		}

		return list.stream().collect(Collectors.joining(" "));
	}
    
    private static void doTest(String input, String expected) {
        String actual = toNATO(input);
        assertEquals("for string: <" + input + ">", expected, actual); 
    }

    @Test
    public void sampleTests() {
        doTest(
            "If you can read",
            "India Foxtrot Yankee Oscar Uniform Charlie Alfa November Romeo Echo Alfa Delta"
        );
        doTest(
            "Did not see that coming",
            "Delta India Delta November Oscar Tango Sierra Echo Echo Tango Hotel Alfa Tango Charlie Oscar Mike India November Golf"
        );
        doTest(
            "go for it!",
            "Golf Oscar Foxtrot Oscar Romeo India Tango !"
        );
        doTest(
            "the five boxing wizards jump quickly.",
            "Tango Hotel Echo Foxtrot India Victor Echo Bravo Oscar Xray India November Golf Whiskey India Zulu Alfa Romeo Delta Sierra Juliett Uniform Mike Papa Quebec Uniform India Charlie Kilo Lima Yankee ."
        );
        doTest(
            "PACK MY BOX WITH FIVE DOZEN LIQUOR JUGS?",
            "Papa Alfa Charlie Kilo Mike Yankee Bravo Oscar Xray Whiskey India Tango Hotel Foxtrot India Victor Echo Delta Oscar Zulu Echo November Lima India Quebec Uniform Oscar Romeo Juliett Uniform Golf Sierra ?"
        );
        doTest(
            "  p ? u . n  c t u  , a t i o n  ! ",
            "Papa ? Uniform . November Charlie Tango Uniform , Alfa Tango India Oscar November !"
        );
    }
    
    //IGNORE THIS
    static class Helper {
    	static Map<Character,String> NATO = new HashMap<>();
    	static {
    		NATO.put('A', "Alfa");
    		NATO.put('B',"Bravo");
    		NATO.put('C',"Charlie");
    		NATO.put('D',"Delta");
    		NATO.put('E',"Echo");
    		NATO.put('F',"Foxtrot");
    		NATO.put('G',"Golf");
    		NATO.put('H',"Hotel");
    		NATO.put('I',"India");
    		NATO.put('J',"Juliett");
    		NATO.put('K',"Kilo");
    		NATO.put('L',"Lima");
    		NATO.put('M',"Mike");
    		NATO.put('N',"November");
    		NATO.put('O',"Oscar");
    		NATO.put('P',"Papa");
    		NATO.put('Q',"Quebec");
    		NATO.put('R',"Romeo");
    		NATO.put('S',"Sierra");
    		NATO.put('T',"Tango");
    		NATO.put('U',"Uniform");
    		NATO.put('V',"Victor");
    		NATO.put('W',"Whiskey");
    		NATO.put('X',"Xray");
    		NATO.put('Y',"Yankee");
    		NATO.put('Z',"Zulu");
    	}
    }
}
