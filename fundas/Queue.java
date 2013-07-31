import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class Queue<T> {

	List<T> queue;

	public Queue() {
		queue = new ArrayList<T>();
	}

	/**
	 * 
	 * @param first element of the queue
	 */
	public void enqueue(T item) {
		queue.add(item);
	}

	/**
	 * removes the first item from the queue
	 * @return
	 */
	public T dequeue() {
		if(isEmpty())
			throw new NoSuchElementException();
		else {
			T firstItem = queue.get(0);
			queue.remove(0);
			return firstItem;
		}

	}

	/**
	 * checks if the Queue is empty
	 * @return
	 */
	public boolean isEmpty() {
		return queue.size() ==  0;
	}

	/**
	 * 
	 * @return size of the queue
	 */
	public int size() {
		return queue.size();
	}

	public T peek() {
		if(isEmpty()) throw new NoSuchElementException("Queue underflow!");
		else {
			return queue.get(0);
		}

	}
}
