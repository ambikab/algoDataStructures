import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author ambika_b
 *
 */
public class StackClient {

	public static void main(String args[]) throws IOException {
		LinkedListStack<String> s = new LinkedListStack<String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sz = new StringTokenizer(br.readLine()," ");
		while (sz.hasMoreTokens()) {
			String item = sz.nextToken();
			if (!item.equals("-")) s.push(item);
			else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
		}
		StdOut.println("(" + s.size() + " left on stack)");
		for(String x : s) 
			System.out.println("Tokens from the stack  :" + x);
	}
}
