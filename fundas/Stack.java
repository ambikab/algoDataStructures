import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * 
 * @author ambika_b
 * ArrayList implementation of stack
 */
public class Stack<T> {

	List<T> stack;
	
	public Stack() {
		stack = new ArrayList<T>();
	}
	public void push(T item) {
		stack.add(item);
	}
	
	public T pop() {
		if(isEmpty()) throw new NoSuchElementException("stack underflow!!");
		else
			return stack.remove(size()-1);
	}
	
	public int size() {
		return stack.size();
	}
	
	public boolean isEmpty() {
		return stack.size() ==  0;
	}
	
}
