import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * INCOMPLETE!!
 * Problem : http://www.codechef.com/BTCD2013/problems/SPLCND
 * @author ambika_b
 *
 */
public class Splcnd {

	public static String timonsShare(int[] bugValues) {
		int min = bugValues[0], result = bugValues[0];
		int timonShare = bugValues[0];
		for (int i = 1; i < bugValues.length; i++) {
			result = result ^ bugValues[i]; 
			min = min > bugValues[i] ? bugValues[i] : min;
			timonShare += bugValues[i];
		}
		return result == 0 ? timonShare - min + "" : "NO";
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder resultString = new StringBuilder();
		int testCases = Integer.parseInt(bReader.readLine());
		while (testCases-- > 0 ) {
			int bugCount = Integer.parseInt(bReader.readLine());
			int[] bugs = new int[bugCount];
			StringTokenizer input = new StringTokenizer(bReader.readLine());
			for (int i = 0; input.hasMoreTokens(); i++)
				bugs[i] = Integer.parseInt(input.nextToken());
			resultString.append(timonsShare(bugs) + "\n");
		}
		System.out.println(resultString);
	}
}
