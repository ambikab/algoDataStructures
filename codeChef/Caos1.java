import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.print.attribute.standard.Finishings;

/**
 * Problem : http://www.codechef.com/SEPT13/problems/CAOS1
 * @author ambika_b
 *
 */
public class Caos1 {

	static int[][] gameBlock;

	/**
	 * adjusts the value of the matrix when it is hit by a wall
	 * @param x
	 * @param y
	 */
	public static void newWall(int x, int y) {
		gameBlock[x][y] = -1;
		editCols(x, y, 0);
		editCols(x, y, gameBlock.length - 1);
		editRows(x, y, 0);
		editRows(x, y, gameBlock[0].length - 1);
	}

	public static void editCols(int sx, int sy, int ex) {
		int inc = sx < ex ? 1 : -1;
		for (int i = sx + inc, pos = 0; ; i = i + inc, pos++) 
			if ((inc == 1 && i > ex) || (inc == -1 && i < ex) || (gameBlock[i][sy] == -1))
				return;
			else 
				gameBlock[i][sy] = pos < gameBlock[i][sy] ? pos : gameBlock[i][sy];
	}

	public static void editRows (int sx, int sy, int ey) {
		int inc = sy < ey ? 1 : -1;
		for (int i = sy + inc, pos = 0; ; i = i + inc, pos++ )
			if (( inc == 1 && i > ey) || (inc == -1 && i < ey) || (gameBlock[sx][i] == -1))
				return;
			else
				gameBlock[sx][i] = pos < gameBlock[sx][i] ? pos : gameBlock[sx][i]; 
	}

	/**
	 * initializes the game block
	 * @param rows
	 * @param cols
	 */
	public static void initializeGame(int rows, int cols) {
		gameBlock = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j ++) {
				if (j == cols - 1 || i == rows -1) 
					gameBlock[i][j] = 0;
				else {
					int rowMin = Math.min(i , rows - 1 - i);
					int colMin = Math.min(j , cols - 1 - j);
					gameBlock[i][j] = Math.min(colMin,rowMin);
				}
			}
		}
	}

	/**
	 * Counts the number of monster cells in the game matrix.
	 * @return mosterCellCount
	 */
	public static String countMonsterCells (int rows, int cols) {
		int count = 0;
		for (int i= 0; i < rows; i ++)
			for (int j = 0; j < cols; j++) 
				if( 2 <= gameBlock[i][j] )
					count++;
		return count + "";
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder resultString = new StringBuilder();
		int testCase = Integer.parseInt(bReader.readLine());
		while (testCase-- > 0) {
			StringTokenizer inputString = new StringTokenizer(bReader.readLine());
			int rows = Integer.parseInt(inputString.nextToken());
			int cols = Integer.parseInt(inputString.nextToken());
			initializeGame(rows,cols);
			for (int i = 0; i < rows; i++) {
				inputString = new StringTokenizer(bReader.readLine());
				String input = inputString.nextToken();
				for (int j = 0; j < cols; j++) 
					if (input.charAt(j) == '#')
						newWall(i, j);
			}
			resultString.append(countMonsterCells(rows, cols) + "\n");
		}
		System.out.println(resultString);
	}

}
