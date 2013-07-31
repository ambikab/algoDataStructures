/*
 *
 * Contains the deque class
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Ambika Babuji
 *
 * @param <Item>
 */
public class Deque<Item> implements Iterable<Item> {

    private DoublyLinkedNode<Item> firstNode;

	private DoublyLinkedNode<Item> lastNode;

	private int size;

	/**
	 *
	 */
	public Deque() {
	}

	/**
	 *
	 * @return boolean
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 
	 * @return size
	 */
	public int size()  {
		return size;
	}

	/**
	 *
	 * @param item
	 */
	public void addFirst(Item item) {
		DoublyLinkedNode<Item> newNode =
				new DoublyLinkedNode<Item>(item);
		newNode.next = firstNode;
		if (isEmpty()) {
			lastNode = newNode;
		}
		else {
			firstNode.prev = newNode;
		}
		firstNode = newNode;
		size++;
	}

	public void addLast(Item item) {
		DoublyLinkedNode<Item> newNode = new DoublyLinkedNode<Item>(item);
		newNode.prev = lastNode;
		if (isEmpty()) {
			firstNode = newNode;
		} else {
			lastNode.next = newNode;
		}
		lastNode = newNode;
		size++; 
	}

	public Item removeFirst() {
		if (isEmpty()) throw new NoSuchElementException("queue underflow!!");
		else { 
			DoublyLinkedNode<Item> tempNode = firstNode;
			Item value = firstNode.nodeValue;
			firstNode = firstNode.next;
			tempNode = null;
			size--;
			if(isEmpty()) lastNode = null;
			return value; 
		}
	}

	public Item removeLast() {
		if (isEmpty()) throw new NoSuchElementException("queue underflow!!");
		else {
			DoublyLinkedNode<Item> tempNode = lastNode;
			Item value = tempNode.nodeValue;
			lastNode = lastNode.prev;
			tempNode = null;
			size--;
			if(isEmpty()) firstNode = null;
			return value; 
		}
	}

	public Iterator<Item> iterator() {
		return new DequeIterator<Item>();
	}

	private class DequeIterator<Item> implements Iterator<Item> {

		private DoublyLinkedNode<Item> currentNode =
				(DoublyLinkedNode<Item>) firstNode;

		@Override
		public boolean hasNext() {
			return currentNode != null;
		}

		@Override
		public Item next() {
			if (hasNext()) {
				Item nodeValue = currentNode.nodeValue;
				currentNode = currentNode.next;
				return nodeValue;
			} else {
				throw new NoSuchElementException();
			}
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	/**
	 *
	 * @author Ambika Babuji
	 * @param <Item>
	 */
	private class DoublyLinkedNode<Item> {

		Item nodeValue;
		private DoublyLinkedNode<Item> next;
		private DoublyLinkedNode<Item> prev;

		/**
		 *
		 * @param nodeValue
		 */
		public DoublyLinkedNode(Item nodeValue) {
			if (nodeValue == null) {
				throw new NullPointerException();
			}
			this.nodeValue = nodeValue;
		}
	}
}