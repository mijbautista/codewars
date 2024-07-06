package codewars.five;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/*
 * DESCRIPTION:
 * Greed is a dice game played with five six-sided dice. Your mission, should you choose to accept it, is to score a throw according to these rules. You will always be given an array with five six-sided dice values.
 * 
 *  Three 1's => 1000 points
 *  Three 6's =>  600 points
 *  Three 5's =>  500 points
 *  Three 4's =>  400 points
 *  Three 3's =>  300 points
 *  Three 2's =>  200 points
 *  One   1   =>  100 points
 *  One   5   =>   50 point
 * A single die can only be counted once in each roll. For example, a given "5" can only count as part of a triplet (contributing to the 500 points) or as a single 50 points, but not both in the same roll.
 * 
 * Example scoring
 * 
 *  Throw       Score
 *  ---------   ------------------
 *  5 1 3 4 1   250:  50 (for the 5) + 2 * 100 (for the 1s)
 *  1 1 1 3 1   1100: 1000 (for three 1s) + 100 (for the other 1)
 *  2 4 4 5 4   450:  400 (for three 4s) + 50 (for the 5)
 * In some languages, it is possible to mutate the input to the function. This is something that you should never do. If you mutate the input, you will not be able to pass all the tests.
 * 
 */

public class Greed {
	
	  public static int greedy(int[] dice){
	      Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	      int score = 0;
	      for (int i : dice) {
	    	  if (map.containsKey(i)) {
	    		  map.put(i, map.get(i)+1);
	    	  } else {
	    		  map.put(i, 1);
	    	  }
	      }
	      for (Map.Entry<Integer,Integer> m : map.entrySet()) {
	        score += getScore(m.getKey(), m.getValue());
	      }
	      return score;
	  }
	  
	  public static int getScore(int die, int count) {
	      int score = 0;
	      if (count >= 3) {
	          switch(die) {
	              case 1: score += 1000;break;
	              case 2: score += 200;break;
	              case 3: score += 300;break;
	              case 4: score += 400;break;
	              case 5: score += 500;break;
	              case 6: score += 600;break;
	          }
	          count -= 3;
	      }
	      if (die == 1 || die == 5) {
	        score += (die == 1 ? 100 : 50) * count;
	      }
	      return score;
	  }
	  
	  @Test
	  public void test() {
		  assertEquals(250, greedy(new int[] {5, 1, 3, 4, 1}));
		  assertEquals(1100, greedy(new int[] {1, 1, 1, 3, 1}));
	  }
}
