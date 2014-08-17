import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Problem: http://www.codechef.com/problems/RRSUM
 * @author ambika_b
 *
 */
public class RrSum {

	
	public static void main(String[] args) throws IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer desc = new StringTokenizer(bReader.readLine());
		StringBuffer result = new StringBuffer();
		long n = Long.parseLong(desc.nextToken()), queries = Long.parseLong(desc.nextToken());
		long min = 1 + n + 1, max = n + (2 * n);
		while (queries-- > 0) {
			long number = Long.parseLong(bReader.readLine());
			long offset1 = number - min, offset2 = max - number;
			long answer = (offset1 > offset2 ? offset2 : offset1) + 1;
			result.append((answer < 1 ? 0 : answer) + "\n" );
		}
		System.out.println(result);
	}
}