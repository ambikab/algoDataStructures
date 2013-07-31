/**
 * 
 * @author ambika_b
 *
 */
public class Node<T> {
	Node<T> next;
	T item;
	
	public Node(T item) {
		next = null;
		this.item = item;
	}
}
