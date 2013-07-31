import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
/**
 * CODE : INTEST
 * USe a fast reader that can handle enormous amounts of data in the program
 * @author Nivi
 *
 */
public class InTest{
 
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//TODO : creating a custom input reader class which is fast.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n,k;
		int result = 0;
		StringTokenizer getTokens = new StringTokenizer(br.readLine());
		n = Integer.parseInt(getTokens.nextToken());
		k = Integer.parseInt(getTokens.nextToken());
		while (n-- > 0) {
			int newNumber = Integer.parseInt(br.readLine());
			if (newNumber % k == 0) result++;			
		}
		
		System.out.println(result);
	}
 
}
 
