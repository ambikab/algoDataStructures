import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author ambika_b
 *
 */
public class Integ {

	static long[] gameRow;

	static int negCount = 0;

	public static long findCost(long opCost) {
		long subVal = 0;
		long totalCoins = 0;
		Arrays.sort(gameRow);
		for (int i = negCount - 1; i >= 0; i--) {
			gameRow[i] = 0 - ( gameRow[i] * -1 - subVal );
			if (gameRow[i] < 0 ) {
				if ( opCost <= negCount) {
					totalCoins +=  ( gameRow[i] * opCost * -1 );
					subVal += 0 - gameRow[i];
				}
				else 
					totalCoins += ( gameRow[i] * -1 );
			}
			negCount--;
		}
		return totalCoins;
	}


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(bReader.readLine());
		gameRow = new long[size];
		StringTokenizer tokens = new StringTokenizer(bReader.readLine());
		for (int i = 0; tokens.hasMoreTokens(); i++ ) {
			gameRow[i] = Integer.parseInt(tokens.nextToken());
			if (gameRow[i] < 0) negCount++;
		}
		int opCost = Integer.parseInt(bReader.readLine());
		if( negCount == 0 )
			System.out.println("0" + "\n");
		else {
			System.out.println(findCost(opCost) + "\n");
		}
	}

}
