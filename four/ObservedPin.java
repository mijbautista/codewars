package codewars.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/*
 * DESCRIPTION:
 * Alright, detective, one of our colleagues successfully observed our target person, Robby the robber. We followed him to a secret warehouse, where we assume to find all the stolen stuff. The door to this warehouse is secured by an electronic combination lock. Unfortunately our spy isn't sure about the PIN he saw, when Robby entered it.
 * 
 * The keypad has the following layout:
 * 
 * ┌───┬───┬───┐
 * │ 1 │ 2 │ 3 │
 * ├───┼───┼───┤
 * │ 4 │ 5 │ 6 │
 * ├───┼───┼───┤
 * │ 7 │ 8 │ 9 │
 * └───┼───┼───┘
 *     │ 0 │
 *     └───┘
 * He noted the PIN 1357, but he also said, it is possible that each of the digits he saw could actually be another adjacent digit (horizontally or vertically, but not diagonally). E.g. instead of the 1 it could also be the 2 or 4. And instead of the 5 it could also be the 2, 4, 6 or 8.
 * 
 * He also mentioned, he knows this kind of locks. You can enter an unlimited amount of wrong PINs, they never finally lock the system or sound the alarm. That's why we can try out all possible (*) variations.
 * 
 * * possible in sense of: the observed PIN itself and all variations considering the adjacent digits
 * 
 * Can you help us to find all those variations? It would be nice to have a function, that returns an array (or a list in Java/Kotlin and C#) of all variations for an observed PIN with a length of 1 to 8 digits. We could name the function getPINs (get_pins in python, GetPINs in C#). But please note that all PINs, the observed one and also the results, must be strings, because of potentially leading '0's. We already prepared some test cases for you.
 * 
 * Detective, we are counting on you!
 * 
 */

public class ObservedPin {

	public static final Map<String, List<String>> adjacent = new HashMap<>();
	static {
		adjacent.put("1", Arrays.asList("1", "2", "4"));
		adjacent.put("2", Arrays.asList("1", "2", "3", "5"));
		adjacent.put("3", Arrays.asList("2", "3", "6"));
		adjacent.put("4", Arrays.asList("1", "4", "5", "7"));
		adjacent.put("5", Arrays.asList("2", "4", "5", "6", "8"));
		adjacent.put("6", Arrays.asList("3", "5", "6", "9"));
		adjacent.put("7", Arrays.asList("4", "7", "8"));
		adjacent.put("8", Arrays.asList("5", "7", "8", "9", "0"));
		adjacent.put("9", Arrays.asList("6", "8", "9"));
		adjacent.put("0", Arrays.asList("8", "0"));
	}

	public static List<String> getPINs(String observed) {
		List<String> entered = Arrays.asList(observed.split(""));
		List<List<String>> combinations = new ArrayList<List<String>>();
		int ctr = 1;
		for (String s : entered) {
			combinations.add(adjacent.get(s));
			ctr *= adjacent.get(s).size();
		}
		String[] result = new String[ctr];
		Arrays.fill(result, "");
		for (int i = 0; i < combinations.size(); i++) {
			List<String> currList = combinations.get(i);
			ctr /= currList.size();
			for (int j = 0; j < result.length; j++) {
				result[j] += currList.get((j / ctr) % (currList.size()));
			}
		}
		return Arrays.asList(result);
	}

	public static HashMap<String, String[]> expectations = new HashMap<String, String[]>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 2807282042844820983L;

		{
			put("8", new String[] { "5", "7", "8", "9", "0" });
			put("11", new String[] { "11", "21", "41", "12", "22", "42", "14", "24", "44" });
			put("369",
					new String[] { "236", "238", "239", "256", "258", "259", "266", "268", "269", "296", "298", "299",
							"336", "338", "339", "356", "358", "359", "366", "368", "369", "396", "398", "399", "636",
							"638", "639", "656", "658", "659", "666", "668", "669", "696", "698", "699" });
		}
	};
	private final static Comparator<String> comp = (s1, s2) -> s1.compareTo(s2);

	@Test
	public void testPins() {
		for (String entered : expectations.keySet()) {
			test(entered, Arrays.asList(expectations.get(entered)), ObservedPin.getPINs(entered));
		}
	}

	private void test(String entered, List<String> expected, List<String> result) {
		result.sort(comp);
		expected.sort(comp);
		Assert.assertEquals("For observed PIN " + entered, expected, result);
	}

}
