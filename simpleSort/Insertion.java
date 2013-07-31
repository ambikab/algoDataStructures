/**
 *  
 * @author ambika_b
 * Sorts the array using Insertion sort
 */
public class Insertion {

	/**
	 *  if i is GREATER THAN j return true 
	 * @param i
	 * @param j
	 * @return boolean
	 */
	public static boolean low(Comparable j , Comparable i) {
		return (i.compareTo(j) < 0);
	}

	/**
	 * sorts the given array in ascending Order
	 * @param items
	 */
	public static void sort(Comparable[] items) {
		for(int i = 1; i < items.length; i++) 
			for(int j = i; j > 0 ; j--)
				if(low(items[j-1], items[j])) exchange(items, j, j-1); 
	}

	/**
	 * checks if the array is sorted
	 * @param items
	 * @return boolean
	 */
	public static boolean isSorted(Comparable[] items) {
		for(int i = 0; i < items.length-1; i++)
			if(low(items[i+1], items[i])) return false;
		return true;
	}

	/**
	 * interchanges array's element between the given indices.
	 * @param items
	 * @param i
	 * @param j
	 */
	public static void exchange(Comparable[] items, int i, int j) {
		Comparable temp = items[i];
		items[i] = items[j];
		items[j] = temp;
	}

	/**
	 * prints the element in the items. 
	 * @param items
	 */
	public static void show(Comparable[] items) {
		for(int i = 0; i < items.length; i++) 
			System.out.println(items[i].toString());
	}

}
