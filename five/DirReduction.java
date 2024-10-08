package codewars.five;

import java.util.Arrays;
import java.util.Objects;

import org.junit.Assert;
import org.junit.Test;

/*
 * DESCRIPTION:
 * Once upon a time, on a way through the old wild mountainous west,�
 * � a man was given directions to go from one point to another. The directions were "NORTH", "SOUTH", "WEST", "EAST". Clearly "NORTH" and "SOUTH" are opposite, "WEST" and "EAST" too.
 * 
 * Going to one direction and coming back the opposite direction right away is a needless effort. Since this is the wild west, with dreadful weather and not much water, it's important to save yourself some energy, otherwise you might die of thirst!
 * 
 * How I crossed a mountainous desert the smart way.
 * The directions given to the man are, for example, the following (depending on the language):
 * 
 * ["NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"].
 * or
 * { "NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST" };
 * or
 * [North, South, South, East, West, North, West]
 * You can immediately see that going "NORTH" and immediately "SOUTH" is not reasonable, better stay to the same place! So the task is to give to the man a simplified version of the plan. A better plan in this case is simply:
 * 
 * ["WEST"]
 * or
 * { "WEST" }
 * or
 * [West]
 * Other examples:
 * In ["NORTH", "SOUTH", "EAST", "WEST"], the direction "NORTH" + "SOUTH" is going north and coming back right away.
 * 
 * The path becomes ["EAST", "WEST"], now "EAST" and "WEST" annihilate each other, therefore, the final result is [] (nil in Clojure).
 * 
 * In ["NORTH", "EAST", "WEST", "SOUTH", "WEST", "WEST"], "NORTH" and "SOUTH" are not directly opposite but they become directly opposite after the reduction of "EAST" and "WEST" so the whole path is reducible to ["WEST", "WEST"].
 * 
 * Task
 * Write a function dirReduc which will take an array of strings and returns an array of strings with the needless directions removed (W<->E or S<->N side by side).
 * 
 * The Haskell version takes a list of directions with data Direction = North | East | West | South.
 * The Clojure version returns nil when the path is reduced to nothing.
 * The Rust version takes a slice of enum Direction {North, East, West, South}.
 * 
 */

public class DirReduction {
	
	public static String[] dirReduc(String[] arr) {
		boolean changed = false;
		for (int i = 0; i < arr.length-1; i++) {
			if (isRedundant(arr[i],arr[i+1])) {
				arr[i] = null;
				arr[i+1] = null;
				changed = true;
			}
		}
		String[] arr2 = Arrays.stream(arr).filter(Objects::nonNull).toArray(String[]::new);
		return changed ? dirReduc(arr2) : arr2;
	}
	
	public static boolean isRedundant(String a, String b) {
		if ((a + b).equals("NORTHSOUTH") || 
			(a + b).equals("SOUTHNORTH") ||
			(a + b).equals("EASTWEST") ||
			(a + b).equals("WESTEAST")) {
			return true;
		}
		return false;
	}
	
	@Test
	public void testReduc() {
		String[][] expected = new String[][] {{}, {"WEST"}};
		String[][] actual = new String[][] {dirReduc(new String[] {"NORTH", "SOUTH", "EAST", "WEST"}), dirReduc(new String[] {"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"})};
		Assert.assertArrayEquals(expected, actual);
	}

}
