package codewars.six;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

/*
 * DESCRIPTION:
 * Given two arrays a and b write a function comp(a, b) (orcompSame(a, b)) that checks whether the two arrays have the "same" elements, with the same multiplicities (the multiplicity of a member is the number of times it appears). "Same" means, here, that the elements in b are the elements in a squared, regardless of the order.
 * 
 * Examples
 * Valid arrays
 * a = [121, 144, 19, 161, 19, 144, 19, 11]  
 * b = [121, 14641, 20736, 361, 25921, 361, 20736, 361]
 * comp(a, b) returns true because in b 121 is the square of 11, 14641 is the square of 121, 20736 the square of 144, 361 the square of 19, 25921 the square of 161, and so on. It gets obvious if we write b's elements in terms of squares:
 * 
 * a = [121, 144, 19, 161, 19, 144, 19, 11] 
 * b = [11*11, 121*121, 144*144, 19*19, 161*161, 19*19, 144*144, 19*19]
 * Invalid arrays
 * If, for example, we change the first number to something else, comp is not returning true anymore:
 * 
 * a = [121, 144, 19, 161, 19, 144, 19, 11]  
 * b = [132, 14641, 20736, 361, 25921, 361, 20736, 361]
 * comp(a,b) returns false because in b 132 is not the square of any number of a.
 * 
 * a = [121, 144, 19, 161, 19, 144, 19, 11]  
 * b = [121, 14641, 20736, 36100, 25921, 361, 20736, 361]
 * comp(a,b) returns false because in b 36100 is not the square of any number of a.
 * 
 */
public class AreSame {
	
	public static boolean comp(int[] a, int[] b) {
		if (a == null || b == null)
			return false;
		List<Integer> list = Arrays.stream(b).boxed().collect(Collectors.toList());
		for (int x : a) {
			list.remove((Object) (x * x));
		}
		return list.size() == 0;
	}
	
	@Test
	public void testComp() {
		int[] a = new int[] {121, 144, 19, 161, 19, 144, 19, 11};  
		int[] b = new int[] {121, 14641, 20736, 361, 25921, 361, 20736, 361};
		int[] c = new int[] { 121, 144, 19, 161, 19, 144, 19, 11 };
		int[] d = new int[] { 132, 14641, 20736, 361, 25921, 361, 20736, 361 };
		boolean[] expected = new boolean[] {true,false};
		boolean[] actual = new boolean[] {comp(a,b), comp(c, d)};
		Assert.assertArrayEquals(expected, actual);
	}

}
