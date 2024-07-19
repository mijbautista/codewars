package codewars.six;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

/*
 * In this kata you have to write a method that folds a given array of integers by the middle x-times.
 * 
 * An example says more than thousand words:
 * 
 * Fold 1-times:
 * [1,2,3,4,5] -> [6,6,3]
 * 
 * A little visualization (NOT for the algorithm but for the idea of folding):
 * 
 *  Step 1         Step 2        Step 3       Step 4       Step5
 *                      5/           5|         5\          
 *                     4/            4|          4\      
 * 1 2 3 4 5      1 2 3/         1 2 3|       1 2 3\       6 6 3
 * ----*----      ----*          ----*        ----*        ----*
 * 
 * 
 * Fold 2-times:
 * [1,2,3,4,5] -> [9,6]
 * As you see, if the count of numbers is odd, the middle number will stay. Otherwise the fold-point is between the middle-numbers, so all numbers would be added in a way.
 * 
 * The array will always contain numbers and will never be null. The parameter runs will always be a positive integer greater than 0 and says how many runs of folding your method has to do.
 * 
 * If an array with one element is folded, it stays as the same array.
 * 
 * The input array should not be modified!
 * 
 * Have fun coding it and please don't forget to vote and rank this kata! :-)
 * 
 * I have created other katas. Have a look if you like coding and challenges.
 * 
 */

public class FoldArray {

	public static int[] foldArray(int[] array, int runs) {
		if (runs == 0) {
			return array;
		}
		int arrLen = array.length;
		int mid = arrLen / 2;
		boolean isOdd = arrLen % 2 == 1;
		int[] newArray = new int[isOdd ? mid + 1 : mid];
		for (int i = 0; i < mid; i++) {
			newArray[i] = array[i] + array[arrLen - 1 - i];
		}
		if (isOdd) {
			newArray[mid] = array[mid];
		}
		return foldArray(newArray, runs-1);
	}
	
    @Test
    public void basicTests() {
        int[] input = new int[] { 1, 2, 3, 4, 5 };
        int[] expected = new int[] { 6, 6, 3 };
        assertEquals(Arrays.toString(expected), Arrays.toString(foldArray(input, 1)));

        expected = new int[] { 9, 6 };
        assertEquals(Arrays.toString(expected), Arrays.toString(foldArray(input, 2)));

        expected = new int[] { 15 };
        assertEquals(Arrays.toString(expected), Arrays.toString(foldArray(input, 3)));

        input = new int[] { -9, 9, -8, 8, 66, 23 };
        expected = new int[] { 14, 75, 0 };
        assertEquals(Arrays.toString(expected), Arrays.toString(foldArray(input, 1)));
    }

}
