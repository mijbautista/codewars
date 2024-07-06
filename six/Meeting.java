package codewars.six;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

/*
 * DESCRIPTION:
 * John has invited some friends. His list is:
 * 
 * s = "Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill";
 * Could you make a program that
 * 
 * makes this string uppercase
 * gives it sorted in alphabetical order by last name.
 * When the last names are the same, sort them by first name. Last name and first name of a guest come in the result between parentheses separated by a comma.
 * 
 * So the result of function meeting(s) will be:
 * 
 * "(CORWILL, ALFRED)(CORWILL, FRED)(CORWILL, RAPHAEL)(CORWILL, WILFRED)(TORNBULL, BARNEY)(TORNBULL, BETTY)(TORNBULL, BJON)"
 * It can happen that in two distinct families with the same family name two people have the same first name too.
 *  
 */
public class Meeting {
	
	public static String meeting(String s) {
		List<Name> list = new ArrayList<>();
		for (String n : s.split(";")) {
			String[] arr = n.split(":");
			list.add(new Name(arr[0], arr[1]));
		}
		list.sort(new Comparator<Name>() {
			public int compare(Name o1, Name o2) {
				if (o1.getLast().compareTo(o2.getLast()) == 0) {
					return o1.getFirst().compareTo(o2.getFirst());
				}
				return o1.getLast().compareTo(o2.getLast());
			}
		});
		return list.stream().map(x -> String.format("(%s, %s)", x.getLast(), x.getFirst()))
				.collect(Collectors.joining());
	}

	static class Name {
		private String first;
		private String last;

		public Name(String first, String last) {
			this.first = first.toUpperCase();
			this.last = last.toUpperCase();
		}

		public String getFirst() {
			return first;
		}

		public void setFirst(String first) {
			this.first = first;
		}

		public String getLast() {
			return last;
		}

		public void setLast(String last) {
			this.last = last;
		}
	}
	
	@Test
	public void testMeeting() {
		String[] expected = new String[] {"(CORWILL, ALFRED)(CORWILL, FRED)(CORWILL, RAPHAEL)(CORWILL, WILFRED)(TORNBULL, BARNEY)(TORNBULL, BETTY)(TORNBULL, BJON)"};
		String[] actual = new String[] {meeting("Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill")};
		Assert.assertArrayEquals(expected, actual);
	}

}
