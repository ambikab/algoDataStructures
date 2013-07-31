import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author ambika_b
 *
 */
public class QueueClient {

	/**
	 * A test client.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		LinkedListQueue<Integer> q = new LinkedListQueue<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sz = new StringTokenizer(br.readLine()," ");
		while (sz.hasMoreTokens()) {
			Integer value = Integer.parseInt(sz.nextToken());
			if (!(value==0)) q.enqueue(value);
			else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
		}
		StdOut.println("(" + q.size() + " left on queue)");
		for(Integer x : q)
			System.out.println("Items in Queue : "+ x);
	}
}