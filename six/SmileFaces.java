package codewars.six;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/*
 * Given an array (arr) as an argument complete the function countSmileys that should return the total number of smiling faces.
 * 
 * Rules for a smiling face:
 * 
 * Each smiley face must contain a valid pair of eyes. Eyes can be marked as : or ;
 * A smiley face can have a nose but it does not have to. Valid characters for a nose are - or ~
 * Every smiling face must have a smiling mouth that should be marked with either ) or D
 * No additional characters are allowed except for those mentioned.
 * 
 * Valid smiley face examples: :) :D ;-D :~)
 * Invalid smiley faces: ;( :> :} :]
 * 
 * Example
 * countSmileys([':)', ';(', ';}', ':-D']);       // should return 2;
 * countSmileys([';D', ':-(', ':-)', ';~)']);     // should return 3;
 * countSmileys([';]', ':[', ';*', ':$', ';-D']); // should return 1;
 * Note
 * In case of an empty array return 0. You will not be tested with invalid input (input will always be an array). Order of the face (eyes, nose, mouth) elements will always be the same.
 */

public class SmileFaces {
	
	  public static int countSmileys(List<String> arr) {
	      return (int) arr.stream().filter(s -> isValidSmiley(s)).count();
	  }
	  
	  public static boolean isValidSmiley(String s) {
		  boolean valid = (":;".indexOf(s.charAt(0)) != -1) && (")D".indexOf(s.charAt(s.length()-1)) != -1);
		  if (s.length() == 2) {
			  return valid;
		  } else if (s.length() ==3) {
			  return valid && ("-~".indexOf(s.charAt(1)) != -1);
		  }
		  return false;
	  }
	  
	  @Test
	  public void testCountSmileys() {
		  int[] expected = new int[] {2, 3};
		  int[] actual = new int[] {countSmileys(List.of(":)",":D",":-}",":-()")), countSmileys(List.of(";D",":-(",":-)",";~)"))};
		  Assert.assertArrayEquals(expected, actual);
	  }

}
