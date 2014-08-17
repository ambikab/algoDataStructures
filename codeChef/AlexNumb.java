import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author ambika_b
 *
 */

public class AlexNumb {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder resultString = new StringBuilder();
		int testCase = Integer.parseInt(bReader.readLine());
		while (testCase-- > 0) {
			long count = Integer.parseInt(bReader.readLine());
			StringTokenizer tokens = new StringTokenizer(bReader.readLine());
			long result = 0;
			for (int i = 1; i <= count; i++) {
				Integer.parseInt(tokens.nextToken());
				result = result + (count - i);
			}
			resultString.append(result + "\n");	
		}
		System.out.println(resultString.toString());
	}
}