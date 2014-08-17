import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Problem: http://www.codechef.com/problems/CARVANS
 * @author ambika_b
 *
 */
public class Carvans {

	public static int getSpeedCount(int[] speeds) {
		int maxCnt = 1, curMax = speeds[0];
		for ( int i = 1; i < speeds.length; i++) {
			if (speeds[i] <= curMax){
				maxCnt++;
				curMax = speeds[i];
			} else 
				curMax = curMax;
		}
		return maxCnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		int testCount = Integer.parseInt(bReader.readLine());
		StringBuffer result = new StringBuffer();
		while(testCount-- > 0) {
			//ignored read.
			bReader.readLine();
			StringTokenizer tokens = new StringTokenizer(bReader.readLine());
			int[] speeds = new int[tokens.countTokens()];
			for ( int i =0; tokens.hasMoreTokens(); i++) 
				speeds[i] = Integer.parseInt(tokens.nextToken());
			result.append(getSpeedCount(speeds) + "\n");
		}
		System.out.println(result);
	}
}
