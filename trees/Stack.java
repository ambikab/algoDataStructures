import java.util.NoSuchElementException;
/**
 * Stack for tree traversal
 * @author ambika_b
 *
 */
public class Stack<Node> {

	LinkedList<Node> top;

	/**
	 * adds element to the top of the stack.
	 * @param value
	 */
	public void push(Node value) {
		if (top == null)
			top = new LinkedList<Node>(value);
		else {
			LinkedList newNode = new LinkedList<Node>(value);
			newNode.prev = top;
			top = newNode;
		}
	}

	/**
	 * Returns the top most element from the stack
	 * @return
	 */
	public Node pop() {
		if (top == null) 
			throw new NoSuchElementException("Stack under flow");
			Node temp = top.value;
			top = top.prev;
			return temp;
	}
}
