import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author ambika_b
 * Resizeable array implementation!!
 * @param <Item>
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
	
	private Item[] queue;
	private int queueSize;
	
	// construct an empty randomized queue
	public RandomizedQueue() {
		queue = (Item[]) new Object[2];
	}

	// is the queue empty?
	public boolean isEmpty() {
		return queueSize == 0;
	}

	// return the number of items on the queue
	public int size() {
		return queueSize;
	}

	private void resize(int newSize) {
		Item[] newArray = (Item[]) new Object[newSize];
		for (int i = 0; i < queueSize; i++)
			newArray[i] = queue[i];
		queue = newArray;
	}

	// add the item
	public void enqueue(Item item) {
		if (item == null) throw new NullPointerException("Value can not be null");
		if (queueSize >= (queue.length / 2))
			resize(queue.length * 2); //double the array size
		queue[queueSize] = item;
		queueSize++;
	}
	
	// delete and return a random item
	public Item dequeue() {
		if (isEmpty()) throw new NoSuchElementException("Queue underflow!!");
		int randomIndex = StdRandom.uniform(queueSize); // generates random number from (0, queueSize]
		Item value = queue[randomIndex];
		queue[randomIndex] = queue[--queueSize];
		return value;
	}
	
	// return (but do not delete) a random item
	public Item sample() {
		if (isEmpty()) throw new NoSuchElementException("Queue underflow!!");
		int randomIndex = StdRandom.uniform(queueSize); // generates random number from (0, queueSize]
		return queue[randomIndex];
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new RandomizedQueueIterator<Item>();
	}

	private class RandomizedQueueIterator<T> implements Iterator<T> {
		
		private int currentQueueIndex = 0;
		private T[] queueArray = (T[]) queue;
		
		@Override
		public boolean hasNext() {
			return currentQueueIndex < queueSize;
		}

		@Override
		public T next() {
			if (!hasNext()) throw new NoSuchElementException("No more elements to return!!");
			return queueArray[currentQueueIndex++];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Operation not permitted through an iterator!");
		}
	}
}