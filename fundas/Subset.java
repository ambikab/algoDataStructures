/**
 *
 * @author Ambika Babuji
 *
 */
public class Subset {
	
	public static void main(String[] args) {
		if (args.length < 1) 
			throw new IllegalArgumentException("provide one argument");
		int k = Integer.parseInt(args[0]);
		RandomizedQueue<String> randomizedQueue = new RandomizedQueue<String>();
		while (!StdIn.isEmpty()) {
			randomizedQueue.enqueue(StdIn.readString());
		}
		while (k-- > 0) {
			System.out.println(randomizedQueue.dequeue());			
		}
	}
}
