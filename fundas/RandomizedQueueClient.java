import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author ambika_b
 *
 */
public class RandomizedQueueClient {

	public static void main(String[] args) throws IOException {
		//initialize a randomized queue
		RandomizedQueue<String> randomizedQueue = new RandomizedQueue<String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sz = new StringTokenizer(br.readLine()," ");
		while (sz.hasMoreTokens()) {
			String value = sz.nextToken();
			if (!(value.equals("-"))) randomizedQueue.enqueue(value);
			//else if (!randomizedQueue.isEmpty()) StdOut.print(randomizedQueue.dequeue() + " ");
		}
		for(int i=0; i<randomizedQueue.size(); i++)
			StdOut.print(randomizedQueue.sample() + " ");
		StdOut.println("(" + randomizedQueue.size() + " left on queue)");
		for(String x : randomizedQueue)
			System.out.println("Items in Queue : "+ x);

	}

}
