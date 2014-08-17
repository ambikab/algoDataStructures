import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * http://www.codechef.com/OCT13/problems/MAANDI
 * @author ambika_b
 *
 */

public class Maandi {
	
	public static int findCount(int number) {
		int limit = (int) Math.sqrt(number);
		int count = isOverLucky(number) ? 1 : 0;
		for (int i = 2; i <= limit; i++) {
			if (number % i == 0 ) {
				int fact2 = number / i;
				if (isOverLucky(fact2))
					count++;
				if (isOverLucky(i))
					count++;
			}
		}
		return count;
		
	}
	
	public static boolean isOverLucky(int divisor) {
		return (divisor + "").matches(".*7.*") || (divisor + "").matches(".*4.*") ;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder resultString = new StringBuilder();
		int testCase = Integer.parseInt(bReader.readLine());
		while (testCase-- > 0) {
			int number = Integer.parseInt(bReader.readLine());
			resultString.append(findCount(number) + "\n");
		}
		System.out.println(resultString);
	}

}
