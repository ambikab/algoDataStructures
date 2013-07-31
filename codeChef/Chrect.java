import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Problem : http://www.codechef.com/JULY13/problems/CHRECT
 * @author ambika_b
 *
 */
public class Chrect {
	
	public static int findMinimum(int rows, int cols, int travel) {
		if ((rows == 1 ) && (cols == 1)) return 0;
		if (travel == 1) return 1;
		if ((rows == 1) || (cols == 1)) {
			if (Math.abs(rows - cols) == 1 ) return 0;
			return travel;
		}
		return ((travel / 2) + ( travel % 2 == 0 ? 0 : 1));
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(bReader.readLine());
		StringBuilder result = new StringBuilder();
		while (testCases-- > 0) {
			StringTokenizer tokens = new StringTokenizer(bReader.readLine());
			int row = Integer.parseInt(tokens.nextToken()), col = Integer.parseInt(tokens.nextToken());
			int travel = Integer.parseInt(tokens.nextToken());
			result.append(findMinimum(row, col, travel) + "\n");
		}
		System.out.println(result);
	}

}
