import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Problem : http://www.codechef.com/BTCD2013/problems/PRSN
 * @author ambika_b
 *
 */

public class Prsn {

	/*
	 * calculates the minimum number of bananas required.
	 * @param index of the cells from which the monkeys  will
	 * be released.
	 */

	public static int minBribe (int[] cellNos) {
		int startIndex = 0, lastIndex = cellNos.length - 1;
		int bribe = 0;
		while (lastIndex - startIndex > 1) {
			int diffUpr = cellNos[lastIndex] - cellNos[lastIndex - 1];
			int diffLwr = cellNos[startIndex + 1] - cellNos[startIndex];
			bribe += cellNos[lastIndex] - cellNos[startIndex];
			if (diffUpr > diffLwr) {
				lastIndex = lastIndex - 1;
				cellNos[lastIndex]--;
			} else {
				startIndex = startIndex + 1;
				cellNos[startIndex]++;
			}
		}
		return bribe;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder resultString = new StringBuilder();
		int testCase = Integer.parseInt(bReader.readLine());
		while (testCase-- > 0) {
			StringTokenizer cellIndexTkn, input = new StringTokenizer(bReader.readLine());
			int cellSize = Integer.parseInt(input.nextToken()), releaseCnt = Integer.parseInt(input.nextToken());
			int[] monkeyCells = new int[releaseCnt + 2];
			monkeyCells[0] = 1;
			monkeyCells[releaseCnt + 1] = cellSize;
			cellIndexTkn = new StringTokenizer(bReader.readLine());
			for (int i = 1; cellIndexTkn.hasMoreTokens(); i++) 
				monkeyCells[i] = Integer.parseInt(cellIndexTkn.nextToken());
			resultString.append(minBribe(monkeyCells) + "\n");
		}
		System.out.println(resultString);
	}

}