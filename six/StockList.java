package codewars.six;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

/*
 * DESCRIPTION:
 * A bookseller has lots of books classified in 26 categories labeled A, B, ... Z. Each book has a code c of 3, 4, 5 or more characters. The 1st character of a code is a capital letter which defines the book category.
 * 
 * In the bookseller's stocklist each code c is followed by a space and by a positive integer n (int n >= 0) which indicates the quantity of books of this code in stock.
 * 
 * For example an extract of a stocklist could be:
 * 
 * L = {"ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"}.
 * or
 * L = ["ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"] or ....
 * You will be given a stocklist (e.g. : L) and a list of categories in capital letters e.g :
 * 
 * M = {"A", "B", "C", "W"} 
 * or
 * M = ["A", "B", "C", "W"] or ...
 * and your task is to find all the books of L with codes belonging to each category of M and to sum their quantity according to each category.
 * 
 * For the lists L and M of example you have to return the string (in Haskell/Clojure/Racket/Prolog a list of pairs):
 * 
 * (A : 20) - (B : 114) - (C : 50) - (W : 0)
 * where A, B, C, W are the categories, 20 is the sum of the unique book of category A, 114 the sum corresponding to "BKWRK" and "BTSQZ", 50 corresponding to "CDXEF" and 0 to category 'W' since there are no code beginning with W.
 * 
 * If L or M are empty return string is "" (Clojure/Racket/Prolog should return an empty array/list instead).
 */
public class StockList {

	public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
		if (lstOfArt.length == 0 || lstOf1stLetter.length == 0)
			return "";
		Map<String, Integer> map = new HashMap<>();
		for (String s : lstOf1stLetter) {
			map.put(s, 0);
		}

		for (String stock : lstOfArt) {
			String key = String.valueOf(stock.charAt(0));
			if (map.containsKey(key)) {
				map.put(key, map.computeIfAbsent(key, v -> 0) + Integer.valueOf(stock.split(" ")[1]));
			}
		}

		return map.entrySet().stream().map(e -> String.format("(%s : %s)", e.getKey(),e.getValue()))
				.collect(Collectors.joining(" - "));
	}
	
	@Test
	public void testStockSummary() {
		String[] stock = new String[]{"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"};
		String[] expected = new String[] {"(A : 200) - (B : 1140)", "(C : 500) - (D : 600)"};
		String[] actual = new String[] {stockSummary(stock, new String[]{"A", "B"}), stockSummary(stock, new String[] {"C","D"})};
		Assert.assertArrayEquals(expected, actual);
	}

}
