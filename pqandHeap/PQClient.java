
/**
 * Client to test the Priority Queue implementation
 * @author Nivi
 *
 */
public class PQClient {

	
	/**
	 * Client to test the priority queue implementation
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] values = {new Integer(20),new Integer(5),new Integer(4),new Integer(6),new Integer(3)};
		MaxPQ maxPQ = new MaxPQ(5);
		for(Integer value : values)
			maxPQ.insert(value);
		System.out.println("Values in max priority queue");
		for(Object value : maxPQ.array)
			System.out.println(value);
		System.out.println("Values in sorted order in the heap :" );
		while( ! maxPQ.isEmpty())
			System.out.println(maxPQ.delMax());
	}
}