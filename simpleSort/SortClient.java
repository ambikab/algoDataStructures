import java.io.IOException;

/**
 * 
 * @author Ambika Babuji
 * Client to test the sorting algorithm specified.
 */
public class SortClient {

	/**
	 * @param args
	 * Change the type of the instance to check various sorting techniques implemented.
	 * Read strings from standard input, sort them, and print.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//Integer[] items = {new Integer(21),new Integer(2),new Integer(6),new Integer(3),new Integer(1),new Integer(10),new Integer(11)};
		String[] items = {"e","f","c","a","b","d","h","i","g"};
		Insertion.sort(items);
		Insertion.show(items);
	}

}