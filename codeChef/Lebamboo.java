import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Problem : http://www.codechef.com/OCT13/problems/LEBAMBOO
 * @author ambika_b
 *
 */

public class Lebamboo {

	/**
	 * Minimum number of turns to turn the oHeight to eHeight
	 * @param oHeight
	 * @param eHeight
	 * @return
	 */
	public static int countMin(int[] oHeight, int[] eHeight, int totalSum) {
		int length = oHeight.length, minIndex, cSum = 0, count = -1;
		int diff[] = new int[length];
		boolean endGrowth = false;
		while( endGrowth == false ) {
			cSum = 0;
			count++;
			minIndex = 0; // initializes min to the first element of the array.
			endGrowth = true;
			for (int i = 0; i < length; i++) {
				diff[i] = eHeight[i] - oHeight[i];
				if (diff[i] < diff[minIndex])
					minIndex = i;
				cSum += oHeight[i];
				if (oHeight[i] != eHeight[i])
					endGrowth = false;
				oHeight[i]++;				
			}
			if (totalSum < cSum)
				return -1;
			else if (totalSum == cSum && endGrowth == true) {
				//System.out.println("totalSum is : " + totalSum + "current Sum is : " + cSum + "and match is " + endGrowth);
				return count;
			}
			if (oHeight[minIndex] - 2 == 0)
				return -1;
			oHeight[minIndex] = oHeight[minIndex] - 2;
		}
		return count;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder resultString = new StringBuilder();
		int testCase = Integer.parseInt(bReader.readLine());
		int[] oHeights, eHeights;
		while (testCase-- > 0) {
			int totalSum = 0, plants = Integer.parseInt(bReader.readLine());
			oHeights = new int[plants];
			eHeights = new int[plants];
			String originalHeights = bReader.readLine();
			String expectedHeights = bReader.readLine();
			StringTokenizer oTokens = new StringTokenizer(originalHeights);
			StringTokenizer eTokens = new StringTokenizer(expectedHeights);
			boolean end = false;
			for (int i = 0; oTokens.hasMoreTokens(); i++) {
				oHeights[i] = Integer.parseInt(oTokens.nextToken());
				eHeights[i] = Integer.parseInt(eTokens.nextToken());
				totalSum += eHeights[i];
				if (oHeights[i] != eHeights[i])
					end = true;
			}
			if (plants == 1) {
				int result = oHeights[0] - eHeights[0] >= 0 ? oHeights[0] - eHeights[0] : -1;
				resultString.append(result + "\n");
			}
			else if (end == false) 
				resultString.append("0" + "\n");
			else
				resultString.append(countMin(oHeights, eHeights, totalSum) + "\n");
		}
		System.out.println(resultString);
	}
}
