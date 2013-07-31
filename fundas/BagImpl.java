import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class BagImpl<T> implements Bag<T>, Iterable<T> {
	
	List<T> bag;
	
	BagImpl() {
		bag  = new ArrayList<T>();
	}

	@Override
	public void add(T item) {
		bag.add(item);
	}

	@Override
	public boolean isEmpty() {
		return bag.size() == 0;
	}

	@Override
	public int size() {
		return bag.size();
	}

	@Override
	public Iterator<T> iterator() {
		return this.bag.iterator();
	}
	
}
