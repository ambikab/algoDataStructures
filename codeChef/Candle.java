import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * http://www.codechef.com/problems/CANDLE
 * @author ambika_b
 *
 */
public class Candle {

	public static String getNum(int[] candleCount, int minIndex) {
		StringBuffer num = new StringBuffer();
		if (minIndex == 0)
			num.append("1");
		while(candleCount[minIndex]-- >= 0) 
			num.append(minIndex);
		return num.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		int testCaseCnt = Integer.parseInt(bReader.readLine());
		StringBuffer result = new StringBuffer();
		while(testCaseCnt-- > 0) {
			StringTokenizer tokens = new StringTokenizer(bReader.readLine());
			int candleCount[] = new int[10], min = 0;
			for ( int i = 0; i <= 9; i++) {
				candleCount[i] = Integer.parseInt(tokens.nextToken());
				if ((candleCount[i] == candleCount[min]) && (min == 0))
					min = i;
				min = candleCount[i] < candleCount[min] ? i : min; //get the lowest seen so far.
			}
			result.append(getNum(candleCount, min) + "\n");
		}
		System.out.println(result);
	}
}