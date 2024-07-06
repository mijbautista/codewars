package codewars.four;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/*
 * DESCRIPTION:
 * Connect Four
 * Take a look at wiki description of Connect Four game:
 * 
 * Wiki Connect Four
 * 
 * The grid is 6 row by 7 columns, those being named from A to G.
 * 
 * You will receive a list of strings showing the order of the pieces which dropped in columns:
 * 
 * List<String> myList = new ArrayList<String>(Arrays.asList(
 *     "A_Red",
 *     "B_Yellow",
 *     "A_Red",
 *     "B_Yellow",
 *     "A_Red",
 *     "B_Yellow",
 *     "G_Red",
 *     "B_Yellow"
 * ));
 * The list may contain up to 42 moves and shows the order the players are playing.
 * 
 * The first player who connects four items of the same color is the winner.
 * 
 * You should return "Yellow", "Red" or "Draw" accordingly.
 * 
 */

public class ConnectFour {
	
	private static String[][] GRID = new String[6][7];
	private static List<String> COLUMNS = Arrays.asList("A", "B", "C", "D", "E", "F", "G");

	public static void printGrid() {
		for (String[] arr : GRID) {
			for (String s : arr) {
				System.out.print(s.isEmpty() ? "[_]" : "[" + (s.equals("Yellow") ? "Y" : "R") + "]");
			}
			System.out.println("");
		}
	}

	public static void clearGrid() {
		for (int i = 0; i < GRID.length; i++) {
			Arrays.fill(GRID[i], "");
		}
	}

	public static String whoIsWinner(List<String> piecesPossitionList) {
		clearGrid();
		for (String s : piecesPossitionList) {
			String[] piece = s.split("_");
			placePiece(piece[0], piece[1]);
			if (getWinner() != "Draw") {
				printGrid();
				return getWinner();
			}
		}
		return getWinner();
	}

	public static String getWinner() {
		return checkVertical() == null
				? checkHorizontal() == null ? checkDiagonals() == null ? "Draw" : checkDiagonals() : checkHorizontal()
				: checkVertical();
	}

	public static String checkHorizontal() {
		for (int i = 0; i < GRID.length; i++) {
			for (int j = 0; j < GRID[i].length - 3; j++) {
				if (Set.copyOf(Arrays.asList(GRID[i][j], GRID[i][j + 1], GRID[i][j + 2], GRID[i][j + 3])).size() == 1
						&& !GRID[i][j].isEmpty()) {
					return GRID[i][j];
				}
			}
		}
		return null;
	}

	public static String checkVertical() {
		for (int i = 0; i < GRID.length - 3; i++) {
			for (int j = 0; j < GRID[i].length; j++) {
				if (Set.copyOf(Arrays.asList(GRID[i][j], GRID[i + 1][j], GRID[i + 2][j], GRID[i + 3][j])).size() == 1
						&& !GRID[i][j].isEmpty()) {
					return GRID[i][j];
				}
			}
		}
		return null;
	}

	public static String checkDiagonals() {
		for (int i = 0; i < GRID.length - 3; i++) {
			for (int j = 0; j < GRID[i].length - 3; j++) {
				if (Set.copyOf(Arrays.asList(GRID[i][j], GRID[i + 1][j + 1], GRID[i + 2][j + 2], GRID[i + 3][j + 3]))
						.size() == 1 && !GRID[i][j].isEmpty()) {
					return GRID[i][j];
				}
			}
			for (int j = GRID[i].length - 1; j >= 3; j--) {
				if (Set.copyOf(Arrays.asList(GRID[i][j], GRID[i + 1][j - 1], GRID[i + 2][j - 2], GRID[i + 3][j - 3]))
						.size() == 1 && !GRID[i][j].isEmpty()) {
					return GRID[i][j];
				}
			}
		}
		return null;
	}

	public static void placePiece(String column, String piece) {
		for (int i = GRID.length - 1; i >= 0; i--) {
			if (GRID[i][COLUMNS.indexOf(column)].isEmpty()) {
				GRID[i][COLUMNS.indexOf(column)] = piece;
				break;
			}
		}
	}
	
	@Test
	public void test() {
		String[] expected = new String[] {"Yellow"};
		String[] actual = new String[] {whoIsWinner(List.of("A_Red",
														    "B_Yellow",
														    "A_Red",
														    "B_Yellow",
														    "A_Red",
														    "B_Yellow",
														    "G_Red",
														    "B_Yellow"))};
		Assert.assertArrayEquals(expected, actual);
	}

}
