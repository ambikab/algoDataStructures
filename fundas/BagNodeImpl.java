import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author ambika_b
 *
 * @param <T>
 */
public class BagNodeImpl<T> implements Iterable<T> {

	Node<T> firstNode;
	int bagSize=0;

	@Override
	public Iterator<T> iterator() {
		return new NodeIterator();
	}

	/**
	 * Implementation for iterating linked Nodes
	 * @author ambika_b
	 *
	 */
	private class NodeIterator implements Iterator<T> {

		private Node<T> currNode = firstNode;

		@Override
		public boolean hasNext() {
			return currNode != null;
		}

		@Override
		public T next() {
			T value = currNode.item;
			currNode = currNode.next;
			return (T) value;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}


	}

	public void add(T item) {
		Node<T> node = new Node<T>(item);
		if(isEmpty())
			firstNode = node;
		else {
			node.next = firstNode;
			firstNode = node;	
		}
		bagSize++;
	}

	public boolean isEmpty() {
		return bagSize == 0;
	}

	public int size() {
		return bagSize;
	}
}
