import java.io.IOException;

/**
 * 
 * @author ambika_b
 *
 */
public class SortClient {
	
	/**
	 * @param args
	 * Change the type of the instance to check various sorting techniques implemented.
	 * Read strings from standard input, sort them, and print.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Integer[] items = {new Integer(1),new Integer(2),new Integer(6),new Integer(3),new Integer(11),new Integer(10),new Integer(21),new Integer(5), new Integer(9)};
		//String[] items = {"e","f","c","i","b","d","o","a","g"};
		QuickSort.sort(items);
		QuickSort.show(items);
	}
}
