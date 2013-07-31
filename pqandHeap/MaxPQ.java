import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MaxPQ<T> implements Iterable<T>{

	public T[] array;
	private int size;
	private Comparator<T> comparator;

	public MaxPQ(int PQSize) {
		this.array = (T[]) new Object[PQSize + 1];
		size = 0;
	}

	public void insert(T value) {
		array[size + 1] = value;
		swim(++size); 
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public T delMax() {
		if(isEmpty()) throw new NoSuchElementException("Array underflow!!");
		T temp = array[1];
		exchange(array, 1, size);
		array[size--] = null;		
		sink(1);
		return temp;
	}

	public void sink(int position) {
		int greater = position;
		while(position <= this.size()) {
			if( 2 * position <= size() && isLess(array[position], array[position * 2]))
				greater = position * 2;
			else if (2 * position + 1 <= size() && isLess(array[greater], array[position * 2 + 1])) 
				greater = position * 2 + 1;
			if (position != greater)
				exchange(array, greater, position);
			position++;
		}
	}
	
	public void swim(int position) {
		while (position / 2 >= 1 && (isLess(array[position / 2], array[position]))) {
			exchange(array, position , position / 2);
			position = position / 2;
		}
	}
	
	public boolean isLess(T less, T greater) 
	{
		 if (comparator == null) {
	            return ((Comparable<T>) less).compareTo(greater) < 0;
	        }
	        else {
	            return comparator.compare(less, greater) <= 0;
	        }				
	}
	
	public void  exchange(T[] array, int one, int two) {
		T temp = array[one];
		array[one] = array[two];
		array[two] = temp;
	}

	@Override
	public Iterator<T> iterator() {
		return new QueueIterator();
	}
	
	class QueueIterator implements Iterator<T>{

		private T[] arrayCopy = array;
		private int currentPointer = 0;
		
		@Override
		public boolean hasNext() {
			return array[currentPointer] != null;
		}

		@Override
		public T next() {
			if (!hasNext()) throw new NoSuchElementException("No more elements to return!!");
			T value = array[currentPointer++];
			return value;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Operation not permitted through an iterator!");
		}
	}
}
