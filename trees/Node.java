
/**
 * Node class
 * @author ambika_b
 *
 */
public class Node<Key extends Comparable, Value> {
	Key key;
	Value value;
	Node left , right;

	Node(Key key, Value value) {
		this.key = key;
		this.value = value;

	}
}