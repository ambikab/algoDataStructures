/**
 * 
 * @author ambika_b
 * Sorts a given array of items
 */
public class MergeSort {
	
	/**
	 * merges two sorted half into a fully sorted array
	 * @param items
	 * @param hi
	 * @param mid
	 * @param lo
	 */
	public static void merge(Comparable[] items, Comparable[] aux, int hi , int mid , int lo) {
		//copy the items to an auxiliary array
		for(int i = lo; i <= hi; i++)
			aux[i] = items[i];
		int i = lo;
		int j = mid + 1;
		for(int k = lo; k <= hi; k++) {
			if(i > mid) items[k] = aux[j++];
			else if(j > hi) items[k] = aux[i++];
			else if(low(aux[i],aux[j])) items[k] = aux[i++];
			else
				items[k] = aux[j++];
		}
	}

	/**
	 *  if i is GREATER THAN j return true
	 * @param i
	 * @param j
	 * @return boolean
	 */
	public static boolean low(Comparable j , Comparable i) {
		return (i.compareTo(j) < 0);
	}

	public static void sort(Comparable[] items, Comparable[] aux, int lo, int hi) {
		if(hi <= lo) return;
		int mid = lo + (hi - lo) / 2;
		sort(items, aux, lo, mid);
		sort(items, aux, mid+1, hi);
		merge(items, aux, hi, mid, lo);		
	}
	
	/**
	 * sorts the given array in ascending Order
	 * @param items
	 */
	public static void sort(Comparable[] items) {
		Comparable[] aux = new Comparable[items.length];
		sort(items, aux, 0 , items.length-1);
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
	 * prints the element in the items. 
	 * @param items
	 */
	public static void show(Comparable[] items) {
		for(int i = 0; i < items.length; i++) 
			System.out.println(items[i].toString());
	}
}
