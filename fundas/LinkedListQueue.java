import java.util.Iterator;
import java.util.NoSuchElementException;


public class LinkedListQueue<T> implements Iterable<T>{

	private Node<T> firstNode;

	private Node<T> lastNode;

	private int queueSize;

	public LinkedListQueue() {
	}
	
	public void enqueue(T item) {
		Node<T> newLastNode = new Node<T>(item);
		if(isEmpty())
			firstNode = newLastNode;
		else 
			lastNode.next = newLastNode;
		lastNode = newLastNode;
		queueSize++;
	}

	public T peek() {
		if(isEmpty()) throw new NoSuchElementException("Queue underflow!!");
		else
			return firstNode.item;
	}

	public T dequeue() {
		if(isEmpty()) throw new NoSuchElementException("Queue underflow!!");
		else {
			T value = firstNode.item;
			if(firstNode.next == null)
				lastNode = null;
			firstNode = firstNode.next;
			queueSize--;
			return value;
		}	
	}

	public int size() {
		return queueSize;
	}

	public boolean isEmpty() {
		return queueSize == 0;
	}

	@Override
	public Iterator<T> iterator() {
		return new QueueIterator();
	}

	private class QueueIterator<T> implements Iterator<T> {

		private Node<T> head = (Node<T>) firstNode;
		
		private Node<T> tail = (Node<T>) lastNode;
		
		@Override
		public boolean hasNext() {
			return head != null;
		}

		@Override
		public T next() {
			T value = head.item;
			head = head.next;
			return value;
		}

		@Override
		public void remove() {
			// dequeue(); 
			throw new UnsupportedOperationException("unsupported operation exception !!"); 
		}
		
	}
}
