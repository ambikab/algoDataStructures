import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Problem : http://www.codechef.com/SEPT13/problems/CAOS2
 * @author ambika_b
 *
 */
public class Caos2 {

	static int[] memoizedPrimes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 
		53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 
		127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 
		193, 197, 199, 211, 223, 227, 229, 233, 239, 241 };

	static int[][] gameBlock;

	static int[] resultsMemoized = new int[500];

	public static void newWall(int x, int y) {
		editCols(x, y, 0);
		editCols(x, y, gameBlock.length - 1);
		editRows(x, y, 0);
		editRows(x, y, gameBlock[0].length - 1);
	}

	public static void editCols(int sx, int sy, int ex) {
		int inc = sx < ex ? 1 : -1;
		for (int i = sx + inc, pos = 0; pos <= 250 ; i = i + inc, pos++) 
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

	public static void initializeGame(int rows, int cols) {
		gameBlock = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j ++) {
				if (j == cols - 1 || i == rows -1 || i == 0 || j == 0) 
					gameBlock[i][j] = 0;
				else {
					int rowMin = Math.min(i , rows - 1 - i);
					if (rowMin == 0) 
						gameBlock[i][j] = 0;
					else {
						int colMin = Math.min(j , cols - 1 - j);
						gameBlock[i][j] = Math.min(colMin,rowMin);
					}
				}
			}
		}
	}

	public static String countMonsterCells (int rows, int cols) {
		int count = 0;
		for (int i= 0; i < rows; i ++)
			for (int j = 0; j < cols; j++) {
				if (gameBlock[i][j] >= 2) {
					if (resultsMemoized[gameBlock[i][j]] == 0) 
						for (int k = 0 ; k < memoizedPrimes.length && memoizedPrimes[k] <= gameBlock[i][j]; k++) 
							resultsMemoized[gameBlock[i][j]] += 1;
					count += resultsMemoized[gameBlock[i][j]];
				}
			}
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
						gameBlock[i][j] = -1;
			}
			for (int i = 0; i < rows; i++) 
				for (int j = 0; j < cols; j++) 
					if (gameBlock[i][j] == -1)
						newWall(i, j);
			resultString.append(countMonsterCells(rows, cols) + "\n");
		}
		System.out.println(resultString);
	}

}