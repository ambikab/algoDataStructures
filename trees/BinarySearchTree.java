import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Simple binary Search Tree
 * @author ambika_b
 *
 */
public class BinarySearchTree<Key extends Comparable, Value> implements Iterable<Key> {

	Node<Key, Value> root;

	/**
	 * Add a node of key and value if does not exists 
	 * Update the value if the key exits
	 * @param key
	 * @param value
	 */
	public void put(Key key, Value value) {
		root = put(root, key, value);
	}

	public Node put(Node currentNode, Key key, Value value) {
		if (currentNode == null)
			return new Node(key, value);
		else if (currentNode.key.compareTo(key) == 0) {
			currentNode.value = value;
		} else if (currentNode.key.compareTo(key) < 0) { 
			currentNode.right = put(currentNode.right, key, value);
		} else {
			currentNode.left = put(currentNode.left, key, value);
		}
		return currentNode;
	}

	/**
	 * returns the value of the given key.
	 * If value not found returns null.
	 * @param key
	 * @return
	 */
	public Value get(Key key) {
		Node currentNode = root;
		while (currentNode != null) {
			if (currentNode.key.compareTo(key) == 0)
				return (Value) currentNode.value;
			else if (currentNode.key.compareTo(key) < 0)
				currentNode = currentNode.right;
			else 
				currentNode = currentNode.left;
		}
		return null;
	}

	/**
	 * Traverses the tree and prints the value in sorted order
	 * Uses in order traversal
	 * @param currentNode
	 */
	public void visit (Node currentNode) {
		if (currentNode == null)
			return;
		visit(currentNode.right);
		System.out.print(currentNode.key);
		visit(currentNode.left);

	}

	@Override
	public Iterator iterator() {
		return new BinarySearchIterator();
	}

	class BinarySearchIterator implements Iterator {

		Stack<Node> tempStack = new Stack<Node>();

		BinarySearchIterator() {
			pushToStack(root);
		}

		public void pushToStack(Node currentNode) {
			while( currentNode != null) {
				tempStack.push(currentNode);
				currentNode = currentNode.left;
			}
		}
		@Override
		public boolean hasNext() {
			return tempStack.top != null ? true : false;
		}

		@Override
		public Key next() {
			if(!hasNext()) throw new NoSuchElementException("No more element");
			Node currentNode = tempStack.pop();
			Key key = (Key) currentNode.key;
			pushToStack(currentNode.right);
			return key;

		}

		@Override
		public void remove() {
			throw new NoSuchElementException("No more elements to return!!");
		}

	}


}
