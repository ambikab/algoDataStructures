import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author ambika_b
 *
 */
public class MChairs {

	static long[] fact = new long[50000000]; 

	static long[] combination;

	static {
		fact[0] = 1;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int testCases = Integer.parseInt(bReader.readLine());
		while (testCases-- > 0) {
			combination = new long[50000000];
			int count = Integer.parseInt(bReader.readLine());
			long result = 0;
			for (int i = 1; i < count; i++) 
				result += combination(count, i);
			long combo = ( result + 1 ) % 1000000007;
			output.append(combo + "\n");
		}
		System.out.println(output.toString());
	}

	public static long combination (int n, int r) {
		if (n - r < r) 
			return combination[n - r];
		if (fact[n] == 0)
			factorial(n);
		if (r == 1)
			combination[r] = n;
		else
			combination[r] = fact[n] / (fact[ n - r] * fact[r]);
		return combination[r];

	}

	public static void factorial(int number) {
		for (int i = 1; i <= number; i++) 
			if (fact[i] == 0) 
				fact[i] = fact[i - 1] * i;
	}

}
