/**
 * 
 * @author ambika_b
 *
 */
public class DoublyLinkedNode<T> {
	
	DoublyLinkedNode<T> next;
	DoublyLinkedNode <T> prev;
	T nodeValue;
	
	public DoublyLinkedNode(T nodeValue) {
		this.nodeValue = nodeValue;
	}
}
