import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author ambika_b
 *
 */
public class LinkedListStack<T> implements Iterable<T>{

	private Node<T> stackHead;

	private int size;

	public LinkedListStack() {

	}

	@Override
	public Iterator<T> iterator() {
		return new StackIterator<T>();
	}

	private class StackIterator<T> implements Iterator<T> {

		Node<T> stackPointer = (Node<T>) stackHead;

		@Override
		public boolean hasNext() {
			return stackPointer != null;
		}

		@Override
		public T next() {
			T value = stackPointer.item;
			stackPointer = stackPointer.next;
			return value;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Operation not supported!");
		}

	}
	public boolean isEmpty() {
		return size == 0;
	}

	public int size(){
		return size;
	}

	public T pop() {
		if(isEmpty()) throw new NoSuchElementException("stack underflow!!");
		else
		{
			T popValue = stackHead.item;
			stackHead = stackHead.next;
			size--;
			return popValue;
		}
	}

	public void push(T item) {
		Node<T> newNode = new Node<T>(item);
		if(!isEmpty()) 
			newNode.next = stackHead;
		stackHead = newNode;
		size++;
	}
}
